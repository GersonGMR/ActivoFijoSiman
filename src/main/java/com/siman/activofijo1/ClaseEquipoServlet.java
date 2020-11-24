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

public class ClaseEquipoServlet {
	
	@WebServlet("/ClaseEquiposServlet")
	public class ClaseEquiposServlet extends HttpServlet{
		private static final long serialVersionUID = 1L;
		
		protected void doGet(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {
			
			String tipoequipoId = request.getParameter("tipoequipoId");
			AjaxAppDAO dao = new AjaxAppDAO();
			Map<Integer, String> ClaseEquiposMap = dao.getClaseEquipoMap(Integer.parseInt(tipoequipoId));
			System.out.println(ClaseEquiposMap);
			Gson json = new Gson();
			String ClaseEquiposString = json.toJson(ClaseEquiposMap);
			response.setContentType("text/html");
			response.getWriter().write(ClaseEquiposString);
		}	
	}
}
