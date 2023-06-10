package com.picosoft.biz.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.picosoft.biz.entities.Modele;
import com.picosoft.biz.services.ModeleServiceImpl;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@CrossOrigin
public class ModeleController {
	@Autowired
	ModeleServiceImpl modeleServiceImpl ;
    @Operation(security = {@SecurityRequirement(name = "bearer-key")})
	@GetMapping(value = "/retrieves-all-modele")
	@ResponseBody
	public List<Modele> getAllModele() {
		List<Modele> list = modeleServiceImpl.retreiveAllModele();
		return list;
	}
    
    @Operation(security = {@SecurityRequirement(name = "bearer-key")})
	@PostMapping(value = "/save-Modele")
	public Modele saveModeleTemp(@RequestBody Modele modele) {
		modeleServiceImpl.addModele(modele);
		return modele;

	}

    @Operation(security = {@SecurityRequirement(name = "bearer-key")})
	@PutMapping("/update-Modele/{id}")
	@ResponseBody
	public ResponseEntity<String> updateModele(@RequestBody Modele modele,
			@PathVariable("id") int id) {
		modeleServiceImpl.updateModele(modele, id);
		return new ResponseEntity<String>("Modele updated successfully", HttpStatus.OK);

	}
    @Operation(security = {@SecurityRequirement(name = "bearer-key")})
	@DeleteMapping("/delete-Modele/{id}")
	@ResponseBody
	public ResponseEntity<String> deleteModele(@PathVariable("id") int id) {
		modeleServiceImpl.DeleteModele(id);
		return new ResponseEntity<String>("Modele deleted successfully", HttpStatus.ACCEPTED);

	}


}
