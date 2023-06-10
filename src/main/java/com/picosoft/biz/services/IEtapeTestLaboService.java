package com.picosoft.biz.services;

import java.util.List;

import com.picosoft.biz.entities.EtapeTestLabo;

public interface IEtapeTestLaboService {
	public EtapeTestLabo addEtapeTestLabo(EtapeTestLabo etapeTestLabo);
	public void updateEtapeTestLabo(EtapeTestLabo etapeTestLabo ,int id);
	public void DeleteEtapeTestLabo(int id);
	public List<EtapeTestLabo> retreiveAllEtapeTestLabo() ;
}
