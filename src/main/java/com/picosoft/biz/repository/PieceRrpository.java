package com.picosoft.biz.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.picosoft.biz.entities.Piece;
@Repository
public interface PieceRrpository extends CrudRepository<Piece, Integer> {

}
