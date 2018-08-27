package com.capgemini.accountopening.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.capgemini.accountopening.helper.AccountNumGenerator;
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
	public void toConfimation(HttpServletResponse response) {
		String accNum = AccountNumGenerator.getAccType(customer.getAccountDetails().getAccType());
		customer.getAccountDetails().setAccNumber(accNum);
		personalDetailsService.savePersonalDetails(customer.getPersonalDetails());
		customer.getAccountDetails().setCustomerId(customer.getPersonalDetails().getId());
		customer.getContactDetails().setCustomerId(customer.getPersonalDetails().getId());
		contactDetailsService.saveContactDetails(customer.getContactDetails());
		accountDetailsService.saveAccountDetails(customer.getAccountDetails());
		if(customer.getAccountDetails().getHasNominee().equals("true"))
			customer.getNomineeDetails().setCustomerId(customer.getPersonalDetails().getId());
			nomineeDetailsService.saveNomineeDetails(customer.getNomineeDetails());
		try {
			response.sendRedirect("/final/"+accNum);
		} catch (IOException e) {
			System.out.println("Test");
			e.printStackTrace();
		}
	}

}