package com.picosoft.biz.services;

import java.util.List;

import com.picosoft.biz.entities.FamillePiece;

public interface IFamillePieceService {
	public FamillePiece addFamillePiece(FamillePiece piece,int idModele);
	public void updateFamillePiece(FamillePiece piece ,int id);
	public void DeleteFamillePiece(int id);
	public List<FamillePiece> retreiveAllFamillePiece() ;
}
