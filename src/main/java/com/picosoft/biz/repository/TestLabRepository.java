package com.picosoft.biz.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.picosoft.biz.entities.TestLabo;

@Repository
public interface TestLabRepository extends CrudRepository<TestLabo, Integer> {
	

}
