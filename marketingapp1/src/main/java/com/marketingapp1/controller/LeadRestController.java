package com.marketingapp1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.marketingapp1.entity.Lead;
import com.marketingapp1.repository.LeadRepository;

@RestController
@RequestMapping("/api/leads")
public class LeadRestController {

	@Autowired
	private LeadRepository leadRepo;

	// http://localhost:8080/api/leads

	@GetMapping
	public List<Lead> getAllLead() {
		List<Lead> lead = leadRepo.findAll();
		return lead;
	}

	@PostMapping
	public void saveLead(@RequestBody Lead lead) {

		leadRepo.save(lead);
	}

	@PutMapping
	public void updateLead(@RequestParam("id") long id, @RequestBody Lead lead) {

		lead.setId(id);
		leadRepo.save(lead);
	}

	@DeleteMapping
	public void DeleteLead(@RequestParam("id") long id) {

		leadRepo.deleteById(id);
	}

}
