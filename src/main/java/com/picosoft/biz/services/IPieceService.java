package com.picosoft.biz.services;

import java.util.List;

import com.picosoft.biz.entities.Piece;


public interface IPieceService {
	public Piece addPiece(Piece piece);
	public void updatePiece(Piece piece ,int id);
	public void DeletePiece(int id);
	public List<Piece> retreiveAllPiece() ;
}
