package com.picosoft.biz.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.picosoft.biz.entities.EtapeTest;
@Repository
public interface IEtapeTestRepository extends CrudRepository<EtapeTest, Integer> {

}
