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

import com.picosoft.biz.entities.FamillePiece;
import com.picosoft.biz.services.FamillePieceServiceImpl;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
public class FamillePieceController {
	@Autowired
	FamillePieceServiceImpl impl;
    @Operation(security = {@SecurityRequirement(name = "bearer-key")})
	@GetMapping(value = "/retrieves-all-Famillepiece")
	@ResponseBody
	public List<FamillePiece> getFamillePieces() {
		List<FamillePiece> list = impl.retreiveAllFamillePiece();
		return list;
	}
    @Operation(security = {@SecurityRequirement(name = "bearer-key")})
	@PostMapping(value = "/save-Famillepiece/{idModele}")
	public FamillePiece saveFamillePiece(@RequestBody FamillePiece famillePiece,@PathVariable("idModele") int idModele) {
		impl.addFamillePiece(famillePiece,idModele);
		return famillePiece;

	}

    @Operation(security = {@SecurityRequirement(name = "bearer-key")})
	@PutMapping("/update-Famillepiece/{id}")
	@ResponseBody
	public ResponseEntity<String> updateFamillePiece(@RequestBody FamillePiece famillePiece,
			@PathVariable("id") int id) {
		impl.updateFamillePiece(famillePiece, id);
		return new ResponseEntity<String>("Famille Piece updated successfully", HttpStatus.OK);

	}
    @Operation(security = {@SecurityRequirement(name = "bearer-key")})
	@DeleteMapping("/delete-Famille-piece/{id}")
	@ResponseBody
	public ResponseEntity<String> deleteRentingannonce(@PathVariable("id") int id) {
		impl.DeleteFamillePiece(id);
		return new ResponseEntity<String>("Famille Piece deleted successfully", HttpStatus.ACCEPTED);

	}
}
