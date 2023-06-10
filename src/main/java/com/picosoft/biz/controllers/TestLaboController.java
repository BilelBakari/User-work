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

import com.picosoft.biz.entities.TestLabo;
import com.picosoft.biz.services.TestLaboServiceImpl;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
public class TestLaboController {
	@Autowired
	TestLaboServiceImpl impl;
    @Operation(security = {@SecurityRequirement(name = "bearer-key")})
	@GetMapping(value = "/retrieves-all-TestLabo")
	@ResponseBody
	public List<TestLabo> getAllTestLabo() {
		List<TestLabo> list = impl.retreiveAllTestLabo();
		return list;
	}
    @Operation(security = {@SecurityRequirement(name = "bearer-key")})
	@PostMapping(value = "/save-TestLabo")
	public TestLabo saveTestLabo(@RequestBody TestLabo testLabo) {
		impl.addTestLabo(testLabo);
		return testLabo;
		
	}
    @Operation(security = {@SecurityRequirement(name = "bearer-key")})
	@PutMapping("/update-EtapeLabo/{id}")
	@ResponseBody
	public ResponseEntity<String> updateTestLabo(@RequestBody TestLabo testLabo,
			@PathVariable("id") int id) {
		impl.updateTestLabo(testLabo, id);
		return new ResponseEntity<String>(" test Labo updated successfully", HttpStatus.OK);

	}
    @Operation(security = {@SecurityRequirement(name = "bearer-key")})
	@DeleteMapping("/delete-TestLabo/{id}")
	@ResponseBody
	public ResponseEntity<String> deleteTestLabo(@PathVariable("id") int id) {
		impl.DeleteTestLabo(id);
		return new ResponseEntity<String>("Test Labo deleted successfully", HttpStatus.ACCEPTED);

	}

}
