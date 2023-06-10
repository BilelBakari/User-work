package com.picosoft.biz.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.picosoft.biz.entities.TempEmail;
import com.picosoft.biz.services.TempEmailImpl;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
@RestController
public class TempEmailController {
	@Autowired
	TempEmailImpl emailImpl ;
	@Operation(security = {@SecurityRequirement(name = "bearer-key")})
	@GetMapping(value = "/retrieves-all-tempemail")
	@ResponseBody
	public List<TempEmail> getAllTempEmail() {
		List<TempEmail> list = emailImpl.retreiveAllTempEmail();
		return list;
	}
	@Operation(security = {@SecurityRequirement(name = "bearer-key")})
	@PostMapping(value = "/save-TempEmail")
	public TempEmail saveTempEmail(@RequestBody TempEmail tempemail) {
		emailImpl.addTemp(tempemail);
		return tempemail;

	}
	
	@Operation(security = {@SecurityRequirement(name = "bearer-key")})
	// creating a put mapping that upgrade rent annonce
	@PutMapping("/update-TempEmail/{id}")
	@ResponseBody
	public ResponseEntity<String> updateTempEmail(@RequestBody TempEmail tempEmail,
			@PathVariable("id") int id) {
		emailImpl.updateTempEmail(tempEmail, id);
		return new ResponseEntity<String>("TempEmail updated successfully", HttpStatus.OK);

	}
	@Operation(security = {@SecurityRequirement(name = "bearer-key")})
	@DeleteMapping("/delete-Temp-email/{id}")
	@ResponseBody
	public ResponseEntity<String> deleteRentingannonce(@PathVariable("id") int id) {
		emailImpl.DeleteTempEmail(id);
		return new ResponseEntity<String>("Temp email deleted successfully", HttpStatus.ACCEPTED);

	}

}
