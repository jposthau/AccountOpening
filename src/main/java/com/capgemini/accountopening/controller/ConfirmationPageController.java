package com.capgemini.accountopening.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.capgemini.accountopening.model.Customer;
import com.capgemini.accountopening.service.AccountDetailsService;
import com.capgemini.accountopening.service.ContactDetailsService;
import com.capgemini.accountopening.service.NomineeDetailsService;
import com.capgemini.accountopening.service.PersonalDetailsService;

@Controller
public class ConfirmationPageController {
	
	@Autowired
	private Customer customer;
	
	@Autowired
	private PersonalDetailsService personalDetailsService;
	
	@Autowired
	private ContactDetailsService contactDetailsService;
	
	@Autowired
	private AccountDetailsService accountDetailsService;
	
	@Autowired
	private NomineeDetailsService nomineeDetailsService;
		
	@RequestMapping(value="/confirmation", method=RequestMethod.GET)
    public String confimationForm(Model model) {
        return "confirmation";
    }
	
	@RequestMapping(value="/confirmation", method=RequestMethod.POST)
	public String toConfimation() {
		personalDetailsService.savePersonalDetails(customer.getPersonalDetails());
		contactDetailsService.saveContactDetails(customer.getContactDetails());
		accountDetailsService.saveAccountDetails(customer.getAccountDetails());
		nomineeDetailsService.saveNomineeDetails(customer.getNomineeDetails());
		return "final";
	}

}