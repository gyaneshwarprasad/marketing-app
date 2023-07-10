package com.marketingapp1.service;

import java.util.List;

import com.marketingapp1.entity.Lead;

public interface LeadService {

	public void saveLead(Lead lead);
	
	public List<Lead> listLead();
	
	public void daleteLead(long id);
	
	public Lead updateLead(long id);
	
	public void updateReg(Lead lead);
	
}
