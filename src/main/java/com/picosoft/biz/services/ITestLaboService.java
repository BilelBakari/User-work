package com.picosoft.biz.services;

import java.util.List;

import com.picosoft.biz.entities.TestLabo;

public interface ITestLaboService {
	public TestLabo addTestLabo(TestLabo TestLabo);
	public void updateTestLabo(TestLabo TestLabo ,int id);
	public void DeleteTestLabo(int id);
	public List<TestLabo> retreiveAllTestLabo() ;
}
