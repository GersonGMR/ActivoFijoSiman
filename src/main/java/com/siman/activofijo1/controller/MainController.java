package com.siman.activofijo1.controller;
import java.security.Principal;
import java.util.List;

import com.siman.activofijo1.dao.claseEquipoDAO;
import com.siman.activofijo1.dao.familiaEquipoDAO;
import com.siman.activofijo1.dao.marcaEquipoDAO;
import com.siman.activofijo1.dao.modeloEquipoDAO;
import com.siman.activofijo1.dao.tipoEquipoDAO;
import com.siman.activofijo1.model.claseEquipo;
import com.siman.activofijo1.model.marcaEquipo;
import com.siman.activofijo1.model.modeloEquipo;
import com.siman.activofijo1.model.familiaEquipo;
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
	@Autowired
	private claseEquipoDAO dao1;
	@Autowired
	private marcaEquipoDAO dao2;
	@Autowired
	private familiaEquipoDAO dao3;
	@Autowired
	private modeloEquipoDAO dao4;
	
	@RequestMapping(value = { "/index" }, method = RequestMethod.GET)
    public ModelAndView login() {
    	ModelAndView modelAndView = new ModelAndView();
    	modelAndView.setViewName("index"); //resources/templates/index.html
        return modelAndView;
    }
	
	@RequestMapping(value = "/ingresoActivo", method = RequestMethod.GET)
    public ModelAndView ingresoActivo() {
    	ModelAndView modelAndView = new ModelAndView();
    	modelAndView.setViewName("ingresoActivo"); //resources/templates/ingresoActivo.html
    	return modelAndView;
    }
	
	@RequestMapping(value = { "/home" }, method = RequestMethod.GET)
    public ModelAndView home() {
    	ModelAndView modelAndView = new ModelAndView();
    	modelAndView.setViewName("home"); //resources/templates/home.html
        return modelAndView;
    }
	
	@RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
    public String logoutSuccessfulPage(Model model) {
        model.addAttribute("title", "Logout");
        return "logoutSuccessfulPage";
    }
	
	//INICIO VISTAS MANTENIMIENTO TIPO_EQUIPO
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
	//FIN VISTAS MANTENIMIENTO TIPO_EQUIPO
	
	//INICIO VISTAS MANTENIMIENTO CLASE_EQUIPO
	@RequestMapping("/claseEquipo")
	public String viewClasePage(Model model) {
		List<claseEquipo> listClase = dao1.list();
	    model.addAttribute("listClase", listClase);
	    return "claseEquipo"; //resources/templates/claseEquipo.html
	}
	
	@RequestMapping(value = "/saveClase", method = RequestMethod.POST)
	public String saveClase(@ModelAttribute("claseequipo") claseEquipo claseequipo) {
	    dao1.saveClase(claseequipo);
	      
	    return "redirect:/claseEquipo";
	}
	
	@RequestMapping("/editClase/{id_claseequipo}")
	public ModelAndView showEditClaseForm(@PathVariable(name = "id_claseequipo") int id_claseequipo) {
	    ModelAndView mav = new ModelAndView("claseEquipo_Modif");
	    claseEquipo listClase = dao1.getClase(id_claseequipo);
	    mav.addObject("listClase", listClase);
	    
	  //LLENANDO COMBOBOX
	    List<claseEquipo> getTipo = dao1.getTipo();
	    mav.addObject("descripcion", getTipo);
	    return mav;
	}
	
	@RequestMapping("/claseEquipo_Save")
	public String showNewClaseForm(Model model) {
		claseEquipo listClase = new claseEquipo();
	    model.addAttribute("listClase", listClase);
	    
	    //LLENANDO COMBOBOX
	    List<claseEquipo> getTipo = dao1.getTipo();
	    model.addAttribute("descripcion", getTipo);
	    
	    return "claseEquipo_Save";
	}
	
	@RequestMapping(value = "/updateClase", method = RequestMethod.POST)
	public String updateClase(@ModelAttribute("claseEquipo") claseEquipo claseequipo) {
	    dao1.updateClase(claseequipo);
	      
	    return "redirect:/claseEquipo";
	}
	
	@RequestMapping("/deleteClase/{id_claseequipo}")
	public String deleteClase(@PathVariable(name = "id_claseequipo") int id_claseequipo) {
	    dao1.deleteClase(id_claseequipo);
	    return "redirect:/claseEquipo";      
	}
	//FIN VISTAS MANTENIMIENTO CLASE_EQUIPO
	
	//INICIO VISTAS MANTENIMIENTO MARCA
		@RequestMapping("/marcaEquipo")
		public String viewMarcaPage(Model model) {
			List<marcaEquipo> listMarca = dao2.list();
		    model.addAttribute("listMarca", listMarca);
		    return "marca"; //resources/templates/marca.html
		}
		
		@RequestMapping(value = "/saveMarca", method = RequestMethod.POST)
		public String saveMarca(@ModelAttribute("marcaequipo") marcaEquipo marcaequipo) {
		    dao2.saveMarca(marcaequipo);
		      
		    return "redirect:/marcaEquipo";
		}
		
		@RequestMapping("/editMarca/{id_marca}")
		public ModelAndView showEditMarcaForm(@PathVariable(name = "id_marca") int id_marca) {
		    ModelAndView mav = new ModelAndView("marca_Modif");
		    marcaEquipo listMarca = dao2.getMarca(id_marca);
		    mav.addObject("listMarca", listMarca);
		    
		  //LLENANDO COMBOBOX
		    List<marcaEquipo> getClasemarca = dao2.getClasemarca();
		    mav.addObject("nombre_claseequipo", getClasemarca);
		    return mav;
		}
		
		@RequestMapping("/marcaEquipo_Save")
		public String showNewMarcaForm(Model model) {
			familiaEquipo listMarca = new familiaEquipo();
		    model.addAttribute("listMarca", listMarca);
		    
		    //LLENANDO COMBOBOX
		    List<marcaEquipo> getClasemarca = dao2.getClasemarca();
		    model.addAttribute("nombre_claseequipo", getClasemarca);
		    
		    return "marca_Save";
		}
		
		@RequestMapping(value = "/updateMarca", method = RequestMethod.POST)
		public String updateMarca(@ModelAttribute("marcaEquipo") marcaEquipo marcaequipo) {
		    dao2.updateMarca(marcaequipo);
		      
		    return "redirect:/marcaEquipo";
		}
		
		@RequestMapping("/deleteMarca/{id_marca}")
		public String deleteMarca(@PathVariable(name = "id_marca") int id_marca) {
		    dao2.deleteMarca(id_marca);
		    return "redirect:/marcaEquipo";      
		}
		//FIN VISTAS MANTENIMIENTO MARCA
		
		//INICIO VISTAS MANTENIMIENTO FAMILIA
				@RequestMapping("/familia")
				public String viewFamiliaPage(Model model) {
					List<familiaEquipo> listFamilia = dao3.list();
				    model.addAttribute("listFamilia", listFamilia);
				    return "familia"; //resources/templates/marca.html
				}
				
				@RequestMapping(value = "/saveFamilia", method = RequestMethod.POST)
				public String saveFamilia(@ModelAttribute("familiaequipo") familiaEquipo familiaequipo) {
				    dao3.saveFamilia(familiaequipo);
				      
				    return "redirect:/familia";
				}
				
				@RequestMapping("/editFamilia/{id_familia}")
				public ModelAndView showEditFamiliaForm(@PathVariable(name = "id_familia") int id_familia) {
				    ModelAndView mav = new ModelAndView("familia_Modif");
				    familiaEquipo listFamilia = dao3.getFamilia(id_familia);
				    mav.addObject("listFamilia", listFamilia);
				    
				  //LLENANDO COMBOBOX
				    List<familiaEquipo> getFamarca = dao3.getFamarca();
				    mav.addObject("nombre_marca", getFamarca);
				    return mav;
				}
				
				@RequestMapping("/familia_Save")
				public String showNewFamiliaForm(Model model) {
					familiaEquipo listFamilia = new familiaEquipo();
				    model.addAttribute("listFamilia", listFamilia);
				    
				    //LLENANDO COMBOBOX
				    List<familiaEquipo> getFamarca = dao3.getFamarca();
				    model.addAttribute("nombre_marca", getFamarca);
				    
				    return "familia_Save";
				}
				
				@RequestMapping(value = "/updateFamilia", method = RequestMethod.POST)
				public String updateFamilia(@ModelAttribute("familiaEquipo") familiaEquipo familiaequipo) {
				    dao3.updateFamilia(familiaequipo);
				      
				    return "redirect:/familia";
				}
				
				@RequestMapping("/deleteFamilia/{id_familia}")
				public String deleteFamilia(@PathVariable(name = "id_familia") int id_familia) {
				    dao3.deleteFamilia(id_familia);
				    return "redirect:/familia";      
				}
				//FIN VISTAS MANTENIMIENTO FAMILIA
				
				//INICIO VISTAS MANTENIMIENTO MODELO
				@RequestMapping("/modelo")
				public String viewModeloPage(Model model) {
					List<modeloEquipo> listModelo = dao4.list();
				    model.addAttribute("listModelo", listModelo);
				    return "modelo"; //resources/templates/modelo.html
				}
				
				@RequestMapping(value = "/saveModelo", method = RequestMethod.POST)
				public String saveModelo(@ModelAttribute("modeloequipo") modeloEquipo modeloequipo) {
				    dao4.saveModelo(modeloequipo);
				      
				    return "redirect:/modelo";
				}
				
				@RequestMapping("/editModelo/{id_modelo}")
				public ModelAndView showEditModeloForm(@PathVariable(name = "id_modelo") int id_modelo) {
				    ModelAndView mav = new ModelAndView("modelo_Modif");
				    modeloEquipo listModelo = dao4.getModelo(id_modelo);
				    mav.addObject("listModelo", listModelo);
				    
				  //LLENANDO COMBOBOX
				    List<modeloEquipo> getMofam = dao4.getMofam();
				    mav.addObject("nombre_familia", getMofam);
				    return mav;
				}
				
				@RequestMapping("/modelo_Save")
				public String showNewModeloForm(Model model) {
					modeloEquipo listModelo = new modeloEquipo();
				    model.addAttribute("listModelo", listModelo);
				    
				    //LLENANDO COMBOBOX
				    List<modeloEquipo> getMofam = dao4.getMofam();
				    model.addAttribute("nombre_familia", getMofam);
				    
				    return "modelo_Save";
				}
				
				@RequestMapping(value = "/updateModelo", method = RequestMethod.POST)
				public String updateModelo(@ModelAttribute("modeloEquipo") modeloEquipo modeloequipo) {
				    dao4.updateModelo(modeloequipo);
				      
				    return "redirect:/modelo";
				}
				
				@RequestMapping("/deleteModelo/{id_modelo}")
				public String deleteModelo(@PathVariable(name = "id_modelo") int id_modelo) {
				    dao4.deleteModelo(id_modelo);
				    return "redirect:/modelo";      
				}
				//FIN VISTAS MANTENIMIENTO MODELO
		
    
}