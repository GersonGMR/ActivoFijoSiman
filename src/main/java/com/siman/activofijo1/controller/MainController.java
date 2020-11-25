package com.siman.activofijo1.controller;
import java.security.Principal;
import java.util.List;

import com.siman.activofijo1.dao.claseEquipoDAO;
import com.siman.activofijo1.dao.compradorDAO;
import com.siman.activofijo1.dao.familiaEquipoDAO;
import com.siman.activofijo1.dao.garantiaDAO;
import com.siman.activofijo1.dao.hdDAO;
import com.siman.activofijo1.dao.marcaEquipoDAO;
import com.siman.activofijo1.dao.memoriaDAO;
import com.siman.activofijo1.dao.modeloEquipoDAO;
import com.siman.activofijo1.dao.procesadorDAO;
import com.siman.activofijo1.dao.provDAO;
import com.siman.activofijo1.dao.soDAO;
import com.siman.activofijo1.dao.tipoEquipoDAO;
import com.siman.activofijo1.model.claseEquipo;
import com.siman.activofijo1.model.compradorModel;
import com.siman.activofijo1.model.marcaEquipo;
import com.siman.activofijo1.model.memoriaModel;
import com.siman.activofijo1.model.modeloEquipo;
import com.siman.activofijo1.model.procesadorModel;
import com.siman.activofijo1.model.provModel;
import com.siman.activofijo1.model.soModel;
import com.siman.activofijo1.model.familiaEquipo;
import com.siman.activofijo1.model.garantiaModel;
import com.siman.activofijo1.model.hdModel;
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
	@Autowired
	private memoriaDAO dao5;
	@Autowired
	private soDAO dao6;
	@Autowired
	private procesadorDAO dao7;
	@Autowired
	private hdDAO dao8;
	@Autowired
	private provDAO dao9;
	@Autowired
	private garantiaDAO dao10;
	@Autowired
	private compradorDAO dao11;
	
	@RequestMapping(value = { "/index" }, method = RequestMethod.GET)
    public ModelAndView login() {
    	ModelAndView modelAndView = new ModelAndView();
    	modelAndView.setViewName("index"); //resources/templates/index.html
        return modelAndView;
    }
	
	/*@RequestMapping(value = "/ingresoActivo", method = RequestMethod.GET)
    public ModelAndView ingresoActivo() {
    	ModelAndView modelAndView = new ModelAndView();
    	modelAndView.setViewName("ingresoActivo"); //resources/templates/ingresoActivo.html
    	return modelAndView;
    }*/
	
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
				
				//INICIO VISTAS MANTENIMIENTO MEMORIA
				@RequestMapping("/memoria")
				public String viewMemoPage(Model model) {
					List<memoriaModel> listMemo = dao5.list();
				    model.addAttribute("listMemo", listMemo);
				    return "memoria"; //resources/templates/memoria.html
				}
				
				@RequestMapping(value = "/saveMemo", method = RequestMethod.POST)
				public String saveMemo(@ModelAttribute("memoriamodel") memoriaModel memoriamodel) {
				    dao5.saveMemo(memoriamodel);
				      
				    return "redirect:/memoria";
				}
				
				@RequestMapping("/editMemo/{id_memoria}")
				public ModelAndView showEditMemoForm(@PathVariable(name = "id_memoria") int id_memoria) {
				    ModelAndView mav = new ModelAndView("memoria_Modif");
				    memoriaModel listMemo = dao5.getMemo(id_memoria);
				    mav.addObject("listMemo", listMemo);
				    return mav;
				}
				
				@RequestMapping("/memoria_Save")
				public String showMemoForm(Model model) {
					memoriaModel listMemo = new memoriaModel();
				    model.addAttribute("listMemo", listMemo);
				    return "memoria_Save";
				}
				
				@RequestMapping(value = "/updateMemo", method = RequestMethod.POST)
				public String updateMemo(@ModelAttribute("listMemo") memoriaModel memoriamodel) {
				    dao5.updateMemo(memoriamodel);
				      
				    return "redirect:/memoria";
				}
				
				@RequestMapping("/deleteMemo/{id_memoria}")
				public String deleteMemo(@PathVariable(name = "id_memoria") int id_memoria) {
				    dao5.deleteMemo(id_memoria);
				    return "redirect:/memoria";      
				}
				//FIN VISTAS MANTENIMIENTO MEMORIA
				
				//INICIO VISTAS MANTENIMIENTO SO
				@RequestMapping("/sistemaOp")
				public String viewSOPage(Model model) {
					List<soModel> listSO = dao6.list();
				    model.addAttribute("listSO", listSO);
				    return "sistemaOp"; //resources/templates/memoria.html
				}
				
				@RequestMapping(value = "/saveSO", method = RequestMethod.POST)
				public String saveSO(@ModelAttribute("somodel") soModel somodel) {
				    dao6.saveSO(somodel);
				      
				    return "redirect:/sistemaOp";
				}
				
				@RequestMapping("/editSO/{id_sistemaop}")
				public ModelAndView showEditSOForm(@PathVariable(name = "id_sistemaop") int id_sistemaop) {
				    ModelAndView mav = new ModelAndView("sistemaOp_Modif");
				    soModel listSO = dao6.getSO(id_sistemaop);
				    mav.addObject("listSO", listSO);
				    return mav;
				}
				
				@RequestMapping("/sistemaOp_Save")
				public String showSOForm(Model model) {
					soModel listSO = new soModel();
				    model.addAttribute("listSO", listSO);
				    return "sistemaOp_Save";
				}
				
				@RequestMapping(value = "/updateSO", method = RequestMethod.POST)
				public String updateSO(@ModelAttribute("listSO") soModel somodel) {
				    dao6.updateSO(somodel);
				      
				    return "redirect:/sistemaOp";
				}
				
				@RequestMapping("/deleteSO/{id_sistemaop}")
				public String deleteSO(@PathVariable(name = "id_sistemaop") int id_sistemaop) {
				    dao6.deleteSO(id_sistemaop);
				    return "redirect:/sistemaOp";      
				}
				//FIN VISTAS MANTENIMIENTO SO
				
				//INICIO VISTAS MANTENIMIENTO PRO
				@RequestMapping("/procesador")
				public String viewProPage(Model model) {
					List<procesadorModel> listPro = dao7.list();
				    model.addAttribute("listPro", listPro);
				    return "procesador"; //resources/templates/memoria.html
				}
				
				@RequestMapping(value = "/savePro", method = RequestMethod.POST)
				public String savePro(@ModelAttribute("procesadormodel") procesadorModel procesadormodel) {
				    dao7.savePro(procesadormodel);
				      
				    return "redirect:/procesador";
				}
				
				@RequestMapping("/editPro/{id_procesador}")
				public ModelAndView showEditProForm(@PathVariable(name = "id_procesador") int id_procesador) {
				    ModelAndView mav = new ModelAndView("procesador_Modif");
				    procesadorModel listPro = dao7.getPro(id_procesador);
				    mav.addObject("listPro", listPro);
				    return mav;
				}
				
				@RequestMapping("/procesador_Save")
				public String showProForm(Model model) {
					procesadorModel listPro = new procesadorModel();
				    model.addAttribute("listPro", listPro);
				    return "procesador_Save";
				}
				
				@RequestMapping(value = "/updatePro", method = RequestMethod.POST)
				public String updatePro(@ModelAttribute("listPro") procesadorModel procesadormodel) {
				    dao7.updatePro(procesadormodel);
				      
				    return "redirect:/procesador";
				}
				
				@RequestMapping("/deletePro/{id_procesador}")
				public String deletePro(@PathVariable(name = "id_procesador") int id_procesador) {
				    dao7.deletePro(id_procesador);
				    return "redirect:/procesador";      
				}
				//FIN VISTAS MANTENIMIENTO PRO
				
				//INICIO VISTAS MANTENIMIENTO HD
				@RequestMapping("/discoDuro")
				public String viewhdPage(Model model) {
					List<hdModel> listHD = dao8.list();
				    model.addAttribute("listHD", listHD);
				    return "discoDuro"; //resources/templates/memoria.html
				}
				
				@RequestMapping(value = "/saveHD", method = RequestMethod.POST)
				public String saveHD(@ModelAttribute("hdmodel") hdModel hdmodel) {
				    dao8.saveHD(hdmodel);
				      
				    return "redirect:/discoDuro";
				}
				
				@RequestMapping("/editHD/{id_discoduro}")
				public ModelAndView showEdithdForm(@PathVariable(name = "id_discoduro") int id_discoduro) {
				    ModelAndView mav = new ModelAndView("discoDuro_Modif");
				    hdModel listHD = dao8.getHD(id_discoduro);
				    mav.addObject("listHD", listHD);
				    return mav;
				}
				
				@RequestMapping("/discoDuro_Save")
				public String showhdForm(Model model) {
					hdModel listHD = new hdModel();
				    model.addAttribute("listHD", listHD);
				    return "discoDuro_Save";
				}
				
				@RequestMapping(value = "/updateHD", method = RequestMethod.POST)
				public String updateHD(@ModelAttribute("listHD") hdModel hdmodel) {
				    dao8.updateHD(hdmodel);
				      
				    return "redirect:/discoDuro";
				}
				
				@RequestMapping("/deleteHD/{id_discoduro}")
				public String deleteHD(@PathVariable(name = "id_discoduro") int id_discoduro) {
				    dao8.deleteHD(id_discoduro);
				    return "redirect:/discoDuro";      
				}
				//FIN VISTAS MANTENIMIENTO HD
				
				//INICIO VISTAS MANTENIMIENTO PROVEEDOR
				@RequestMapping("/proveedor")
				public String viewprovPage(Model model) {
					List<provModel> listProv = dao9.list();
				    model.addAttribute("listProv", listProv);
				    return "proveedor"; //resources/templates/memoria.html
				}
				
				@RequestMapping(value = "/saveProv", method = RequestMethod.POST)
				public String saveProv(@ModelAttribute("provmodel") provModel provmodel) {
				    dao9.saveProv(provmodel);
				      
				    return "redirect:/proveedor";
				}
				
				@RequestMapping("/editProv/{id_proveedor}")
				public ModelAndView showEditprovForm(@PathVariable(name = "id_proveedor") int id_proveedor) {
				    ModelAndView mav = new ModelAndView("proveedor_Modif");
				    provModel listProv = dao9.getProv(id_proveedor);
				    mav.addObject("listProv", listProv);
				    return mav;
				}
				
				@RequestMapping("/proveedor_Save")
				public String showProvForm(Model model) {
					provModel listProv = new provModel();
				    model.addAttribute("listProv", listProv);
				    return "proveedor_Save";
				}
				
				@RequestMapping(value = "/updateProv", method = RequestMethod.POST)
				public String updateProv(@ModelAttribute("listProv") provModel provmodel) {
				    dao9.updateProv(provmodel);
				      
				    return "redirect:/proveedor";
				}
				
				@RequestMapping("/deleteProv/{id_proveedor}")
				public String deleteProv(@PathVariable(name = "id_proveedor") int id_proveedor) {
				    dao9.deleteProv(id_proveedor);
				    return "redirect:/proveedor";      
				}
				//FIN VISTAS MANTENIMIENTO PROVEEDOR
				
				//INICIO VISTAS MANTENIMIENTO GARANTIA
				@RequestMapping("/garantia")
				public String viewGarPage(Model model) {
					List<garantiaModel> listGar = dao10.list();
				    model.addAttribute("listGar", listGar);
				    return "garantia"; //resources/templates/memoria.html
				}
				
				@RequestMapping(value = "/saveGar", method = RequestMethod.POST)
				public String saveGar(@ModelAttribute("garantiamodel") garantiaModel garantiamodel) {
				    dao10.saveGar(garantiamodel);
				      
				    return "redirect:/garantia";
				}
				
				@RequestMapping("/editGar/{id_garantia}")
				public ModelAndView showEditGarForm(@PathVariable(name = "id_garantia") int id_garantia) {
				    ModelAndView mav = new ModelAndView("garantia_Modif");
				    garantiaModel listGar = dao10.getGar(id_garantia);
				    mav.addObject("listGar", listGar);
				    return mav;
				}
				
				@RequestMapping("/garantia_Save")
				public String showGarForm(Model model) {
					garantiaModel listGar = new garantiaModel();
				    model.addAttribute("listGar", listGar);
				    return "garantia_Save";
				}
				
				@RequestMapping(value = "/updateGar", method = RequestMethod.POST)
				public String updateGar(@ModelAttribute("listGar") garantiaModel garantiamodel) {
				    dao10.updateGar(garantiamodel);
				      
				    return "redirect:/garantia";
				}
				
				@RequestMapping("/deleteGar/{id_garantia}")
				public String deleteGar(@PathVariable(name = "id_garantia") int id_garantia) {
				    dao10.deleteGar(id_garantia);
				    return "redirect:/garantia";      
				}
				//FIN VISTAS MANTENIMIENTO GARANTIA
				
				//INICIO VISTAS MANTENIMIENTO COMPRADOR
				@RequestMapping("/comprador")
				public String viewComPage(Model model) {
					List<compradorModel> listCom = dao11.list();
				    model.addAttribute("listCom", listCom);
				    return "comprador"; //resources/templates/memoria.html
				}
				
				@RequestMapping(value = "/saveCom", method = RequestMethod.POST)
				public String saveCom(@ModelAttribute("compradormodel") compradorModel compradormodel) {
				    dao11.saveCom(compradormodel);
				      
				    return "redirect:/comprador";
				}
				
				@RequestMapping("/editCom/{id_comprador}")
				public ModelAndView showEditComForm(@PathVariable(name = "id_comprador") int id_comprador) {
				    ModelAndView mav = new ModelAndView("comprador_Modif");
				    compradorModel listCom = dao11.getCom(id_comprador);
				    mav.addObject("listCom", listCom);
				    return mav;
				}
				
				@RequestMapping("/comprador_Save")
				public String showComForm(Model model) {
					compradorModel listCom = new compradorModel();
				    model.addAttribute("listCom", listCom);
				    return "comprador_Save";
				}
				
				@RequestMapping(value = "/updateCom", method = RequestMethod.POST)
				public String updateCom(@ModelAttribute("listCom") compradorModel compradormodel) {
				    dao11.updateCom(compradormodel);
				      
				    return "redirect:/comprador";
				}
				
				@RequestMapping("/deleteCom/{id_comprador}")
				public String deleteCom(@PathVariable(name = "id_comprador") int id_comprador) {
				    dao11.deleteCom(id_comprador);
				    return "redirect:/comprador";      
				}
				//FIN VISTAS MANTENIMIENTO COMPRADOR
	
	//INICIO VISTAS MANTENIMIENTO ACTIVOFIJO
	@RequestMapping("/ingresoActivo")
	public String showActivoForm(Model model) {
		activoFijo listActivo = new activoFijo();
	    model.addAttribute("listActivo", listActivo);
	    
	    //LLENANDO COMBOBOX
	    List<activoFijo> getTipoEquipo = dao5.getTipoEquipo();
	    model.addAttribute("tequipo", getTipoEquipo);
	    
	    List<activoFijo> getProveedor = dao5.getProveedor();
	    model.addAttribute("gproveedor", getProveedor);
	    
	    List<activoFijo> getGarantia = dao5.getGarantia();
	    model.addAttribute("ggarantia", getGarantia);
	    
	    List<activoFijo> getClaseEquipo = dao5.getClaseEquipo();
	    model.addAttribute("gclase", getClaseEquipo);
	    
	    List<activoFijo> getMarca = dao5.getMarca();
	    model.addAttribute("gmarca", getMarca);
	    
	    List<activoFijo> getFamilia = dao5.getFamilia();
	    model.addAttribute("gfamilia", getFamilia);
	    
	    List<activoFijo> getModelo = dao5.getModelo();
	    model.addAttribute("gmodelo", getModelo);
	    
	    List<activoFijo> getSistemaOp = dao5.getSistemaOp();
	    model.addAttribute("gsistemao", getSistemaOp);
	    
	    List<activoFijo> getComprador = dao5.getComprador();
	    model.addAttribute("gcomprador", getComprador);
	    
	    List<activoFijo> getProcesador = dao5.getProcesador();
	    model.addAttribute("procesador", getProcesador);
	    
	    List<activoFijo> getMemoria = dao5.getMemoria();
	    model.addAttribute("memoria", getMemoria);
	    
	    List<activoFijo> getDiscoDuro = dao5.getDiscoDuro();
	    model.addAttribute("disco", getDiscoDuro);
	    
	    return "ingresoActivo";
	}
	
	@RequestMapping(value = "/saveActivo", method = RequestMethod.POST)
	public String saveActivo(@ModelAttribute("activofijo") activoFijo activofijo) {
	    dao5.saveActivo(activofijo);
	      
	    return "redirect:/ingresoActivo";
	}
	//FIN VISTAS MANTENIMIENTO ACTIVOFIJO
    
}
