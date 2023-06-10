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

import com.picosoft.biz.entities.EtapeTest;
import com.picosoft.biz.services.EtapeTestServiceImpl;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
@RestController
public class EtapeTestController {
	@Autowired
	EtapeTestServiceImpl etapeTestServiceImpl;
    @Operation(security = {@SecurityRequirement(name = "bearer-key")})
	@GetMapping(value = "/retrieves-all-EtapeTest")
	@ResponseBody
	public List<EtapeTest> getAllEtapeTest() {
		List<EtapeTest> list = etapeTestServiceImpl.retreiveAllEtapeTest();
		return list;
	}
    @Operation(security = {@SecurityRequirement(name = "bearer-key")})
	@PostMapping(value = "/save-EtapeTest")
	public EtapeTest saveFamillePiece(@RequestBody EtapeTest etapeTest) {
		etapeTestServiceImpl.addEtapeTest(etapeTest);
		return etapeTest;

	}
    @Operation(security = {@SecurityRequirement(name = "bearer-key")})
	@PutMapping("/update-EtapeTest/{id}")
	@ResponseBody
	public ResponseEntity<String> updateEtapeTest(@RequestBody EtapeTest etapeTest,
			@PathVariable("id") int id) {
		etapeTestServiceImpl.updateEtapeTest(etapeTest, id);
		return new ResponseEntity<String>("etapte test updated successfully", HttpStatus.OK);

	}
    @Operation(security = {@SecurityRequirement(name = "bearer-key")})
	@DeleteMapping("/delete-EtapeTest/{id}")
	@ResponseBody
	public ResponseEntity<String> deleteEtapeTest(@PathVariable("id") int id) {
		etapeTestServiceImpl.DeleteEtapeTest(id);
		return new ResponseEntity<String>("EtapeTest deleted successfully", HttpStatus.ACCEPTED);

	}
}
