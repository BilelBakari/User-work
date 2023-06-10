package com.picosoft.biz.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.picosoft.biz.entities.FamillePiece;
@Repository
public interface FamillePieceRepository extends CrudRepository<FamillePiece, Integer> {


}
