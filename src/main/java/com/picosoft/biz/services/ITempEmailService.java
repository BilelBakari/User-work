package com.picosoft.biz.services;

import java.util.List;

import com.picosoft.biz.entities.TempEmail;

public interface ITempEmailService {
	public TempEmail addTemp(TempEmail tempemail);
	public void updateTempEmail(TempEmail tempemail ,int id);
	public void DeleteTempEmail(int id);
	public List<TempEmail> retreiveAllTempEmail() ;
}
