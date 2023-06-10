package com.picosoft.biz.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.picosoft.biz.entities.TempEmail;
import com.picosoft.biz.repository.TempEmailRepository;
@Service
public class TempEmailImpl implements ITempEmailService{
	private static final Logger l = LogManager.getLogger(TempEmailImpl.class);
	@Autowired
	TempEmailRepository emailRepository ;
	@Override
	public TempEmail addTemp(TempEmail tempemail) {
		// TODO Auto-generated method stub
		return emailRepository.save(tempemail);
	}

	@Override
	public void updateTempEmail(TempEmail tempemail, int id) {
		TempEmail temp2 = emailRepository.findById(id).get();
		temp2.setJsonorHtmlData(tempemail.getJsonorHtmlData());
		emailRepository.save(temp2);
		
		
	}

	@Override
	public void DeleteTempEmail(int id) {
		emailRepository.deleteById(id);		
	}

	@Override
	public List<TempEmail> retreiveAllTempEmail() {
		List<TempEmail> listtempemail = (List<TempEmail>) emailRepository.findAll() ;
		for(TempEmail tempemail : listtempemail) {
			l.info("piece : "+tempemail);
		}
		return listtempemail;
	}

}
