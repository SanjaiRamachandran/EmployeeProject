package com.mailinboxreader.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mailinboxreader.service.ReadService;

@RestController
@RequestMapping(value="/mail")
public class ReadController {
	
	@Autowired
	ReadService rs;
	
	@GetMapping(value="/readMail")
	public List<String> fetchInboxEmails(){
		return rs.fetchInboxEmails();
	}
	
}
