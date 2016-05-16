package com.parohyapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.parohyapp.api.LoginBean;
import com.parohyapp.bank.Client;
import com.parohyapp.database.account.AccountDAO;
import com.parohyapp.database.card.CardDAO;
import com.parohyapp.database.client.ClientDAO;

@Controller
public class HomePageController {
	
	@Autowired
	ClientDAO clientDAO;
	
	@Autowired
	AccountDAO accountDAO;
	
	@Autowired
	CardDAO cardDAO;
	
	@RequestMapping("/indexLogin")
	public ModelAndView getHomePageLogin(){
		ModelAndView model = new ModelAndView("loginPage");
		LoginBean loginBean = new LoginBean();
		model.addObject("loginBean",loginBean);
		return model;
	}
	
	@RequestMapping(value = "/loginClient", method = RequestMethod.POST)
	public String loginClient(@ModelAttribute("loginBean") LoginBean loginBean, ModelMap model){
		int id = clientDAO.getLoginClient(loginBean.getUsername(), loginBean.getPassword());
		if(id!=0){
			Client client = clientDAO.getClient(id);
			model.addAttribute("client",client);
			return "homePage";
		}				
		return "loginPage";
	}
}
