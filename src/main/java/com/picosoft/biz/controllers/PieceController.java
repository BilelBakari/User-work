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

import com.picosoft.biz.entities.Piece;
import com.picosoft.biz.services.PieceServiceImpl;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;


@RestController
public class PieceController {
	@Autowired 
	PieceServiceImpl impl ;
    @Operation(security = {@SecurityRequirement(name = "bearer-key")})
	@GetMapping(value = "/retrieves-all-piece")
	@ResponseBody
	public List<Piece> getPiece() {
		List<Piece> list = impl.retreiveAllPiece();
		return list;
	}
    @Operation(security = {@SecurityRequirement(name = "bearer-key")})
	@PostMapping(value="/save-piece")
	public Piece savePiece(@RequestBody Piece piece) 
	{
		impl.addPiece(piece);
		return piece;
	
	}
    @Operation(security = {@SecurityRequirement(name = "bearer-key")})
  	@PutMapping("/update-piece/{id}")
  	@ResponseBody
  	public ResponseEntity<String> updateRentAnnonce(
  		@RequestBody Piece piece,@PathVariable("id")int id) {
  		impl.updatePiece(piece,id);
  		return new ResponseEntity<String>("Piece updated successfully",HttpStatus.OK);
  		
  	}
    @Operation(security = {@SecurityRequirement(name = "bearer-key")})
	@DeleteMapping("/delete-piece/{id}")
  	@ResponseBody
  	public ResponseEntity<String>  deleteRentingannonce(@PathVariable("id")int id) {
		impl.DeletePiece(id);
  	    return new ResponseEntity<String>("Piece deleted successfully",HttpStatus.ACCEPTED);
  		
  	}
}
