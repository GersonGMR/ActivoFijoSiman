package com.siman.activofijo1.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.hibernate.Criteria;
import org.hibernate.SharedSessionContract;
import org.hibernate.criterion.Restrictions;
import org.springframework.boot.web.servlet.server.Session;
import com.siman.activofijo1.model.ClaseEquipoModel;
import com.siman.activofijo1.model.MarcaEquipoModel;
import com.siman.activofijo1.model.TipoEquipoModel;
import com.siman.activofijo1.utils.HibernateUtil;

public class AjaxAppDAO {
	//TIPO_EQUIPOS
	@SuppressWarnings({ "deprecation", "unchecked" })
	public Map<Integer, String> getTipoEquipoMap(){
		Session hsession = null ;
		List<TipoEquipoModel>  TipoEquipos = null;
		Map<Integer, String> TipoEquiposMap = new HashMap<>();
		try  {
			hsession = (Session) HibernateUtil.getSessionFactory().openSession();
			Criteria criteria = ((SharedSessionContract) hsession).createCriteria(TipoEquipoModel.class);
			TipoEquipos = criteria.list();
		}catch (Exception e){
			e.printStackTrace();
		}
		if (!TipoEquipos.isEmpty()) {
			for (TipoEquipoModel model: TipoEquipos) {
				TipoEquiposMap.put(model.getTipoEquipoId(), model.getdescripcion());
			}
		}
		return TipoEquiposMap;		
	}
	//CLASE_EQUIPOS
	@SuppressWarnings("unchecked")
	public Map<Integer, String> getClaseEquipoMap(Integer tipoequipoId){
		Session hsession = null ; 
		List<ClaseEquipoModel> ClaseEquipos = null;
		Map<Integer, String> ClaseEquiposMap = new HashMap<>();
		try {
			hsession = (Session) HibernateUtil.getSessionFactory().openSession();
			@SuppressWarnings("deprecation")
			Criteria criteria = ((SharedSessionContract) hsession).createCriteria(ClaseEquipoModel.class);
			criteria.add(Restrictions.eq("tipoequipoId",tipoequipoId));
			ClaseEquipos = criteria.list();
		}catch (Exception e) {
			e.printStackTrace();			
		}
		if (!ClaseEquipos.isEmpty()) {
			for (ClaseEquipoModel model: ClaseEquipos) {
				ClaseEquiposMap.put(model.getClaseEquipoId(), model.getClaseEquipoNombre());
			}
		}
		return ClaseEquiposMap ;		
	}
	//MARCA_EQUIPOS
	@SuppressWarnings("unchecked")
	public Map<Integer, String> getMarcaEquipoMap(Integer claseequipoId){
		Session hsession = null ; 
		List<MarcaEquipoModel> MarcaEquipos = null;
		Map<Integer, String> MarcaEquiposMap = new HashMap<>();
		try {
			hsession = (Session) HibernateUtil.getSessionFactory().openSession();
			@SuppressWarnings("deprecation")
			Criteria criteria = ((SharedSessionContract) hsession).createCriteria(MarcaEquipoModel.class);
			criteria.add(Restrictions.eq("claseequipoId",claseequipoId));
			MarcaEquipos = criteria.list();
		}catch (Exception e) {
			e.printStackTrace();			
		}
		if (!MarcaEquipos.isEmpty()) {
			for (MarcaEquipoModel model: MarcaEquipos) {
				MarcaEquiposMap.put(model.getMarcaId(), model.getMarcaNombre());
			}
		}
		return MarcaEquiposMap ;		
	}
}
