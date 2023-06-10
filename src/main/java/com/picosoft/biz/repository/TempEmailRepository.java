package com.picosoft.biz.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.picosoft.biz.entities.TempEmail;
@Repository
public interface TempEmailRepository extends CrudRepository<TempEmail, Integer> {

}
