package com.picosoft.biz.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.picosoft.biz.entities.Piece;
import com.picosoft.biz.repository.PieceRrpository;

@Service
public class PieceServiceImpl implements IPieceService {
	private static final Logger l = LogManager.getLogger(PieceServiceImpl.class);
	@Autowired
	PieceRrpository pieceRrpository ;
	@Override
	public Piece addPiece(Piece piece) {
		// TODO Auto-generated method stub
		return pieceRrpository.save(piece);
	}

	@Override
	public void updatePiece(Piece piece, int id) {
		Piece piece2 = pieceRrpository.findById(id).get();
		piece2.setDescription(piece.getDescription());
		piece2.setImage(piece.getImage());
		pieceRrpository.save(piece2);
		
	}

	@Override
	public void DeletePiece(int id) {
		pieceRrpository.deleteById(id);
		
		
	}

	@Override
	public List<Piece> retreiveAllPiece() {
		List<Piece> listpiece = (List<Piece>) pieceRrpository.findAll() ;
		for(Piece piece : listpiece) {
			l.info("piece : "+piece);
		}
		return listpiece;
	}

}
