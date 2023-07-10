package com.marketingapp1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.marketingapp1.dto.EmailDto;
import com.marketingapp1.dto.LeadDto;
import com.marketingapp1.entity.Lead;
import com.marketingapp1.service.LeadService;
import com.marketingapp1.util.EmailService;

@Controller
public class LeadController {

	@Autowired
	private LeadService leadService;
	
	
	@Autowired
	private EmailService emailService;
	
	
    @RequestMapping("/sendEmail")
    public String sendEmail(EmailDto emailDto){
	 
       emailService.sendEmail(emailDto.getEmail(), emailDto.getSubject(), emailDto.getMessage());
    		
   	return "send_email";
    }
    
    
 // http://localhost:8080/email
    @RequestMapping("/email")
	public String viewEmailform() {
		return "send_email";
	}
		

	// http://localhost:8080/create

	@RequestMapping("/create")
	public String viewLeadform() {
		return "create_lead";
	}

	@RequestMapping("/saveReg")
	public String saveLead(@ModelAttribute Lead lead , Model model) {
		leadService.saveLead(lead);
		emailService.sendEmail( lead.getEmail(), "Wellcome", "test");
		model.addAttribute("msg" , "Record is save");
		return "create_lead";

	}

	// http://localhost:8080/listAll
	@RequestMapping("/listAll")
	public String listAll(Model model) {
		List<Lead> leads = leadService.listLead();
		model.addAttribute("leads", leads);
		return "search_result";

	}
	
	
	@RequestMapping("/delete")
	public String deleteLead(@RequestParam("id") long id  , Model model){
	leadService.daleteLead(id);
		
	List<Lead> leads = leadService.listLead();
	model.addAttribute("leads", leads);
	return "search_result";
	}

	
	@RequestMapping("/update")
	public String updateLead(@RequestParam("id") long id  , Model model){
	 Lead  lead = leadService.updateLead(id);
	 model.addAttribute("lead" ,lead);
	return "update_lead"; 
	}

	
	

 @RequestMapping("/updateReg")
	public String updateReg(LeadDto leadDto, Model model){
	  
	 Lead lead = new Lead();
	  
	 lead.setId(leadDto.getId());
	 lead.setFirstName(leadDto.getFirstName());
	 lead.setLastName(leadDto.getLastName());
	 lead.setEmail(leadDto.getEmail());
	 lead.setMobile(leadDto.getMobile());
	 
	 leadService.updateReg(lead);
	 
	 List<Lead> leads = leadService.listLead();
		model.addAttribute("leads", leads);
		return "search_result";
	 
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
