package com.picosoft.biz.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.picosoft.biz.entities.Modele;
@Repository
public interface ModeleRepository extends CrudRepository<Modele, Integer>{

}
