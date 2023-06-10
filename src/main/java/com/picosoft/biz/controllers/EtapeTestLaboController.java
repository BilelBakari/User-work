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

import com.picosoft.biz.entities.EtapeTestLabo;
import com.picosoft.biz.services.EtapeTestLaboServiceImpl;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
@RestController
public class EtapeTestLaboController {
	@Autowired
	EtapeTestLaboServiceImpl etapeTestLaboServiceImpl;
    @Operation(security = {@SecurityRequirement(name = "bearer-key")})
	@GetMapping(value = "/retrieves-all-EtapeTestLabp")
	@ResponseBody
	public List<EtapeTestLabo> getAllEtapeTest() {
		List<EtapeTestLabo> list = etapeTestLaboServiceImpl.retreiveAllEtapeTestLabo();
		return list;
	}
    @Operation(security = {@SecurityRequirement(name = "bearer-key")})
	@PostMapping(value = "/save-EtapeTestLabo")
	public EtapeTestLabo saveFamillePiece(@RequestBody EtapeTestLabo etapeTestLabo) {
		etapeTestLaboServiceImpl.addEtapeTestLabo(etapeTestLabo);
		return etapeTestLabo;

	}

    @Operation(security = {@SecurityRequirement(name = "bearer-key")})
    @PutMapping("/update-EtapeTestLabo/{id}")
	@ResponseBody
	public ResponseEntity<String> updateEtapeTestLabo(@RequestBody EtapeTestLabo etapeTestLabo,
			@PathVariable("id") int id) {
		etapeTestLaboServiceImpl.updateEtapeTestLabo(etapeTestLabo, id);
		return new ResponseEntity<String>("etapte test Labo updated successfully", HttpStatus.OK);

	}
    @Operation(security = {@SecurityRequirement(name = "bearer-key")})
	@DeleteMapping("/delete-EtapeTestLabo/{id}")
	@ResponseBody
	public ResponseEntity<String> deleteEtapeTestLabo(@PathVariable("id") int id) {
		etapeTestLaboServiceImpl.DeleteEtapeTestLabo(id);
		return new ResponseEntity<String>("EtapeTest Labo deleted successfully", HttpStatus.ACCEPTED);

	}


}
