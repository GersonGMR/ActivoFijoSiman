package com.siman.activofijo1;

import java.io.IOException;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.siman.activofijo1.dao.AjaxAppDAO;
import com.google.gson.Gson;

public class MarcaEquipoServlet {
	
	@WebServlet("/MarcaEquiposServlet")
	public class MarcaEquiposServlet extends HttpServlet{
		private static final long serialVersionUID = 1L;
		
		protected void doGet(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {
			
			String claseequipoId = request.getParameter("claseequipoId");
			AjaxAppDAO dao = new AjaxAppDAO();
			Map<Integer, String> MarcaEquiposMap = dao.getMarcaEquipoMap(Integer.parseInt(claseequipoId));
			System.out.println(MarcaEquiposMap);
			Gson json = new Gson();
			String MarcaEquiposString = json.toJson(MarcaEquiposMap);
			response.setContentType("text/html");
			response.getWriter().write(MarcaEquiposString); 
		}	
	}
}