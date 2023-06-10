package com.picosoft.biz.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.picosoft.biz.entities.Rapport;
@Repository
public interface RapportReppository extends CrudRepository<Rapport, String> {

}
