package com.picosoft.biz.controllers;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.picosoft.biz.config.JwtTokenUtil;
import com.picosoft.biz.entities.DAOUser;
import com.picosoft.biz.entities.JwtRequest;
import com.picosoft.biz.entities.JwtResponse;
import com.picosoft.biz.entities.Role;
import com.picosoft.biz.entities.UserDTO;
import com.picosoft.biz.services.JwtUserDetailsService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@CrossOrigin
public class JwtAuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private JwtUserDetailsService userDetailsService;

	

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

		final String token = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new JwtResponse(token));
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<?> saveUser(@RequestBody UserDTO user) throws Exception {
		return ResponseEntity.ok(userDetailsService.save(user));
	}

	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
	@Operation(security = {@SecurityRequirement(name = "bearer-key")})
	@GetMapping(value = "/init")
	@ResponseBody
	    public void initRoleAndUser() {
		   userDetailsService.initRoleAndUser();
	    }
	@Operation(security = {@SecurityRequirement(name = "bearer-key")})
	@GetMapping(value = "/currentUser")
	@ResponseBody
	private UserDetails currentUser() throws Exception {
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		//String username = userDetails.getUsername();
		return userDetails;
	}
	
	@Operation(security = {@SecurityRequirement(name = "bearer-key")})
	@GetMapping(value = "/detailsuser")
	@ResponseBody
	private String DetailsUser() throws Exception {
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String password = userDetails.toString();
		return password;
	}
	@Operation(security = {@SecurityRequirement(name = "bearer-key")})
	@PutMapping("/update-user")
  	@ResponseBody
  	public ResponseEntity<String> updateRentAnnonce(@RequestBody DAOUser user) {
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = userDetails.getUsername();
		userDetailsService.UpdateAccountUserByUsername(username, user);
  		return new ResponseEntity<String>("Piece updated successfully",HttpStatus.OK);
  		
  	}
	@CrossOrigin(origins = {"http://localhost:4200"} ,methods = {RequestMethod.GET})
	@Operation(security = {@SecurityRequirement(name = "bearer-key")})
	@GetMapping(value = "/retrieves-all-users")
	@ResponseBody	
	public List<DAOUser> getUsers() {
		List<DAOUser> list = userDetailsService.retreiveAllUsers();
		return list;
	}
	@GetMapping(value = "/UserById/{id}")
	@ResponseBody
	public DAOUser getUserById(@PathVariable("id") int id) {
		return userDetailsService.findById(id);
	}
	@CrossOrigin(origins = {"http://localhost:4200"} ,methods = {RequestMethod.DELETE})
	@Operation(security = {@SecurityRequirement(name = "bearer-key")})
	@DeleteMapping("/delete-user/{id}")
  	@ResponseBody
  	public ResponseEntity<String>  deleteRenting(@PathVariable("id")int id) {
		userDetailsService.DeleteUser(id);
  	    return new ResponseEntity<String>("Piece deleted successfully",HttpStatus.ACCEPTED);
  		
  	}

}