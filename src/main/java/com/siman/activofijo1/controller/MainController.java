package com.siman.activofijo1.controller;
import java.security.Principal;

import com.siman.activofijo1.utils.WebUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
 
@Controller
public class MainController {
 
    @RequestMapping(value = { "/index" }, method = RequestMethod.GET)
    public ModelAndView login() {
    	ModelAndView modelAndView = new ModelAndView();
    	modelAndView.setViewName("index"); //resources/templates/index.html
        return modelAndView;
    }
    
    @RequestMapping(value = { "/home" }, method = RequestMethod.GET)
    public ModelAndView home() {
    	ModelAndView modelAndView = new ModelAndView();
    	modelAndView.setViewName("home"); //resources/templates/index.html
        return modelAndView;
    }
    
    @RequestMapping(value = "/ingresoActivo", method = RequestMethod.GET)
    public ModelAndView ingresoActivo() {
    	ModelAndView modelAndView = new ModelAndView();
    	modelAndView.setViewName("ingresoActivo"); //resources/templates/home.html
    	return modelAndView;
    }
    
    @RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
    public String logoutSuccessfulPage(Model model) {
        model.addAttribute("title", "Logout");
        return "logoutSuccessfulPage";
    }
    
    
}
