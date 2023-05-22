package com.web;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.DAO;
import com.beans.*;




@WebServlet("/")
public class CountryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DAO countryDAO;
	
	public void init() {
		countryDAO = new DAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/update":
				editCountry(request, response);
				break;
			case "/edit":
                showEditForm(request, response);
                break;
			case "/listedit":
				listeditCountry(request, response);
				break;
			default:
				listCountry(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listCountry(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<CountryBean> listCountry = countryDAO.selectAllCountrys();
		request.setAttribute("listCountry", listCountry);
		RequestDispatcher dispatcher = request.getRequestDispatcher("country-list.jsp");
		dispatcher.forward(request, response);
	}
	
	
	private void listeditCountry(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<CountryBean> listCountry = countryDAO.selectAllCountrys();
		request.setAttribute("listCountry", listCountry);
		RequestDispatcher dispatcher = request.getRequestDispatcher("loggedinlist.jsp");
		dispatcher.forward(request, response);
	}
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, ServletException, IOException {
		        int id = Integer.parseInt(request.getParameter("id"));
		        CountryBean existingCountry = countryDAO.selectCountry(id);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("country-form.jsp");
		        request.setAttribute("country", existingCountry);
		        request.setAttribute("id", id);
		        dispatcher.forward(request, response);
		    }
	

	private void editCountry(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		float $2020 = Float.parseFloat(request.getParameter("$2020"));
		float $2021 = Float.parseFloat(request.getParameter("$2021"));
		float $2022 = Float.parseFloat(request.getParameter("$2022"));		
		// Speichern der eingegebenen Daten in einem CountryBean-Objekt und Ausführen der updateCountry-Methode
		CountryBean newcoun = new CountryBean(id, name, $2020, $2021, $2022);			
		countryDAO.updateCountry(newcoun);		
		
		// Eintrag in der Tabelle "dataedit"
		String loggedInUsername = (String) request.getSession().getAttribute("loggedInUsername");
		countryDAO.saveDataEdit(loggedInUsername, name);
		
		response.sendRedirect("list");
}

}	

