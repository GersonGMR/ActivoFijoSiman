package com.siman.activofijo1.controller;
import java.security.Principal;
import java.util.List;

import com.siman.activofijo1.dao.tipoEquipoDAO;
import com.siman.activofijo1.model.tipoEquipo;
import com.siman.activofijo1.utils.WebUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
 
@Controller
public class MainController {
	
	@Autowired
	private tipoEquipoDAO dao;
	
	@RequestMapping("/tipoEquipo1")
	public String viewHomePage(Model model) {
		List<tipoEquipo> listEquipo = dao.list();
	    model.addAttribute("listEquipo", listEquipo);
	    return "tipoEquipo"; //resources/templates/tipoEquipo.html
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("tipoequipo") tipoEquipo tipoequipo) {
	    dao.save(tipoequipo);
	      
	    return "redirect:/tipoEquipo1";
	}
	
	@RequestMapping("/edit/{id_tipoequipo}")
	public ModelAndView showEditForm(@PathVariable(name = "id_tipoequipo") int id_tipoequipo) {
	    ModelAndView mav = new ModelAndView("tipoEquipo_Modif");
	    tipoEquipo listEquipo = dao.get(id_tipoequipo);
	    mav.addObject("listEquipo", listEquipo);
	    return mav;
	}
	
	@RequestMapping("/tipoEquipo_Save")
	public String showNewForm(Model model) {
		tipoEquipo listEquipo = new tipoEquipo();
	    model.addAttribute("listEquipo", listEquipo);
	    return "tipoEquipo_Save";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@ModelAttribute("listEquipo") tipoEquipo tipoequipo) {
	    dao.update(tipoequipo);
	      
	    return "redirect:/tipoEquipo1";
	}
	
	@RequestMapping("/delete/{id_tipoequipo}")
	public String delete(@PathVariable(name = "id_tipoequipo") int id_tipoequipo) {
	    dao.delete(id_tipoequipo);
	    return "redirect:/tipoEquipo1";      
	}
 
    @RequestMapping(value = { "/index" }, method = RequestMethod.GET)
    public ModelAndView login() {
    	ModelAndView modelAndView = new ModelAndView();
    	modelAndView.setViewName("index"); //resources/templates/index.html
        return modelAndView;
    }
    
    @RequestMapping(value = { "/home" }, method = RequestMethod.GET)
    public ModelAndView home() {
    	ModelAndView modelAndView = new ModelAndView();
    	modelAndView.setViewName("home"); //resources/templates/home.html
        return modelAndView;
    }
    
    @RequestMapping(value = "/ingresoActivo", method = RequestMethod.GET)
    public ModelAndView ingresoActivo() {
    	ModelAndView modelAndView = new ModelAndView();
    	modelAndView.setViewName("ingresoActivo"); //resources/templates/ingresoActivo.html
    	return modelAndView;
    }

    
    @RequestMapping(value = "/tipoEquipo_Modif", method = RequestMethod.GET)
    public ModelAndView tipoEquipo_Modif() {
    	ModelAndView modelAndView = new ModelAndView();
    	modelAndView.setViewName("tipoEquipo_Modif"); //resources/templates/tipoEquipo_Modif.html
    	return modelAndView;
    }
    
    @RequestMapping(value = "/claseEquipo", method = RequestMethod.GET)
    public ModelAndView claseEquipo() {
    	ModelAndView modelAndView = new ModelAndView();
    	modelAndView.setViewName("claseEquipo"); //resources/templates/claseEquipo.html
    	return modelAndView;
    }
    
    @RequestMapping(value = "/claseEquipo_Save", method = RequestMethod.GET)
    public ModelAndView claseEquipo_Save() {
    	ModelAndView modelAndView = new ModelAndView();
    	modelAndView.setViewName("claseEquipo_Save"); //resources/templates/claseEquipo_Save.html
    	return modelAndView;
    }
    
    @RequestMapping(value = "/claseEquipo_Modif", method = RequestMethod.GET)
    public ModelAndView claseEquipo_Modif() {
    	ModelAndView modelAndView = new ModelAndView();
    	modelAndView.setViewName("claseEquipo_Modif"); //resources/templates/claseEquipo_Modif.html
    	return modelAndView;
    }
    
    @RequestMapping(value = "/marca", method = RequestMethod.GET)
    public ModelAndView marca() {
    	ModelAndView modelAndView = new ModelAndView();
    	modelAndView.setViewName("marca"); //resources/templates/marca.html
    	return modelAndView;
    }
    
    @RequestMapping(value = "/marca_Save", method = RequestMethod.GET)
    public ModelAndView marca_Save() {
    	ModelAndView modelAndView = new ModelAndView();
    	modelAndView.setViewName("marca_Save"); //resources/templates/marca_Save.html
    	return modelAndView;
    }
    
    @RequestMapping(value = "/marca_Modif", method = RequestMethod.GET)
    public ModelAndView marca_Modif() {
    	ModelAndView modelAndView = new ModelAndView();
    	modelAndView.setViewName("marca_Modif"); //resources/templates/marca_Modif.html
    	return modelAndView;
    }
    
    @RequestMapping(value = "/familia", method = RequestMethod.GET)
    public ModelAndView familia() {
    	ModelAndView modelAndView = new ModelAndView();
    	modelAndView.setViewName("familia"); //resources/templates/familia.html
    	return modelAndView;
    }
    
    @RequestMapping(value = "/familia_Save", method = RequestMethod.GET)
    public ModelAndView familia_Save() {
    	ModelAndView modelAndView = new ModelAndView();
    	modelAndView.setViewName("familia_Save"); //resources/templates/familia_Save.html
    	return modelAndView;
    }
    
    @RequestMapping(value = "/familia_Modif", method = RequestMethod.GET)
    public ModelAndView familia_Modif() {
    	ModelAndView modelAndView = new ModelAndView();
    	modelAndView.setViewName("familia_Modif"); //resources/templates/familia_Modif.html
    	return modelAndView;
    }
    
    @RequestMapping(value = "/modelo", method = RequestMethod.GET)
    public ModelAndView modelo() {
    	ModelAndView modelAndView = new ModelAndView();
    	modelAndView.setViewName("modelo"); //resources/templates/modelo.html
    	return modelAndView;
    }
    
    @RequestMapping(value = "/modelo_Save", method = RequestMethod.GET)
    public ModelAndView modelo_Save() {
    	ModelAndView modelAndView = new ModelAndView();
    	modelAndView.setViewName("modelo_Save"); //resources/templates/modelo_Save.html
    	return modelAndView;
    }
    
    @RequestMapping(value = "/modelo_Modif", method = RequestMethod.GET)
    public ModelAndView modelo_Modif() {
    	ModelAndView modelAndView = new ModelAndView();
    	modelAndView.setViewName("modelo_Modif"); //resources/templates/modelo_Modif.html
    	return modelAndView;
    }
    
    @RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
    public String logoutSuccessfulPage(Model model) {
        model.addAttribute("title", "Logout");
        return "logoutSuccessfulPage";
    }
    
    
}