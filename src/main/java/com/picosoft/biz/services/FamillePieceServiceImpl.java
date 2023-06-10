package com.picosoft.biz.services;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.picosoft.biz.entities.FamillePiece;
import com.picosoft.biz.entities.Modele;
import com.picosoft.biz.repository.FamillePieceRepository;
import com.picosoft.biz.repository.ModeleRepository;
@Service
public class FamillePieceServiceImpl implements IFamillePieceService {
	private static final Logger l = LogManager.getLogger(FamillePieceServiceImpl.class);
	@Autowired 
	FamillePieceRepository famillePieceRepository ;
	@Autowired
	ModeleRepository modeleRepository ;
	@Override
	public FamillePiece addFamillePiece(FamillePiece piece,int idModele) {
		// TODO Auto-generated method stub
		Modele modele = modeleRepository.findById(idModele).orElse(null);
		piece.setModele(modele);
		return famillePieceRepository.save(piece);
	}

	@Override
	public void updateFamillePiece(FamillePiece famPi, int id) {
	FamillePiece famillePiece = famillePieceRepository.findById(id).get() ;
	famillePiece.setNomFamillePiece(famPi.getDescription());
	famillePiece.setDescription(famPi.getDescription());
	famillePieceRepository.save(famillePiece);	
	}

	@Override
	public void DeleteFamillePiece(int id) {
		famillePieceRepository.deleteById(id);
		
	}

	@Override
	public List<FamillePiece> retreiveAllFamillePiece() {
		List<FamillePiece> famillePieces = (List<FamillePiece>) famillePieceRepository.findAll();
		for(FamillePiece famillePiece :famillePieces) {
			l.info("Famille de piece :" +famillePiece );
		}
		return famillePieces;
	}

}
