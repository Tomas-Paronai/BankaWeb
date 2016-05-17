package com.parohyapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.parohyapp.api.HashGen;
import com.parohyapp.api.PasswordBean;
import com.parohyapp.bank.Client;
import com.parohyapp.database.client.ClientDAO;

@Controller
public class ProfileController {
	
	@Autowired
	ClientDAO clientDAO;
	
	@RequestMapping("password")
	public String passwordChangePage(@RequestParam(value = "user", required = true) String userHash, ModelMap model){		
		if(userHash != null){
			model.addAttribute("clientId",userHash);
			model.addAttribute("passwordBean",new PasswordBean());
			return "newPassword";
		}
		
		return "";
	}
	
	@RequestMapping(value = "changePassword", method = RequestMethod.POST)
	public String getBackToLogin(@ModelAttribute("client") Integer id, @ModelAttribute("passwordBean") PasswordBean passwordBean, ModelMap model){
		if(passwordBean.getPassword().equals(passwordBean.getPasswordRe())){
			clientDAO.changePassword(passwordBean.getPassword(), id);
		}			
		return "loginPage";		
	}
	
	@RequestMapping(value = "changePassword", method = RequestMethod.GET)
	public String getBackToLogin(@RequestParam(value = "user", required = true) String userHash){
		//TODO send mail
		
		return "loginPage";
	}
	
}
