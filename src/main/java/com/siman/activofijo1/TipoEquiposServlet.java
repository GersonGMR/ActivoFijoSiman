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



public class TipoEquiposServlet {
	
	@WebServlet("/TipoEquiposServlet")
	public class TipoEquipoServlet extends HttpServlet{
		private static final long serialVersionUID = 1L;
		
		protected void doGet(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {
			AjaxAppDAO dao = new AjaxAppDAO();
			Map<Integer, String> TipoEquiposMap = dao.getTipoEquipoMap();
			Gson json = new Gson();
			String TipoEquiposString = json.toJson(TipoEquiposMap);
			response.setContentType("text/html");
			response.getWriter().write(TipoEquiposString);
		}	
	}
}
