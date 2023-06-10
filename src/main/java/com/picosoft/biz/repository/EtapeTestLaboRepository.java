package com.picosoft.biz.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.picosoft.biz.entities.EtapeTestLabo;
@Repository
public interface EtapeTestLaboRepository extends CrudRepository<EtapeTestLabo, Integer> {

}
