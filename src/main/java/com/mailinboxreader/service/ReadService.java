package com.mailinboxreader.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import jakarta.mail.Folder;
import jakarta.mail.Message;
import jakarta.mail.Session;
import jakarta.mail.Store;

@Service
public class ReadService {
	
	@Autowired
	JavaMailSender js;
	
		public List<String> fetchInboxEmails() {
        List<String> emails = new ArrayList<>();
        try {
        	Properties p=new Properties();
        	p.put("mail.store.protocol", "imaps");
        	Session s=Session.getInstance(p);
        	Store st=s.getStore("imaps");
        	st.connect("imap.gmail.com", "sanjairanjani@gmail.com", "ptrumcjzjmvtthrj");
        	
        	Folder inbox=st.getFolder("INBOX");
        	inbox.open(Folder.READ_ONLY);
        	
        	Message[] m=inbox.getMessages(1, 5);
        	for(Message x:m) {
        		System.out.println("Email Subject: " +x.getSubject());
        		System.out.println("From: " + x.getFrom()[0]);
                System.out.println("Received Date: " + x.getReceivedDate());
                System.out.println("Content: " + x.getContent());
                System.out.println("---------------------------");
                emails.add(x.getSubject());
        	}
        	inbox.close(false);
        	st.close();
        }
        catch(Exception e) {
        	e.printStackTrace();
        	}
        return emails;              
        }
}
