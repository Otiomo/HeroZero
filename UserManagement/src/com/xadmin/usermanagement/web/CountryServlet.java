package com.xadmin.usermanagement.web;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xadmin.usermanagement.dao.CountryDAO;
import com.xadmin.usermanagement.model.Country;



/*
 CountryServlet.java
 This Servlet acts as a page controller for the application, handling all requests from the user.
*/

@WebServlet("/")
public class CountryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CountryDAO countryDAO;
	
	public void init() {
		countryDAO = new CountryDAO();
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
			case "/new":
				showNewForm(request, response);
				break;
			case "/update":
				updateCountry(request, response);
				break;
			case "/edit":
                showEditForm(request, response);
                break;
			case "/insert":
				insertCountry(request, response);
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
		List<Country> listCountry = countryDAO.selectAllCountrys();
		request.setAttribute("listCountry", listCountry);
		RequestDispatcher dispatcher = request.getRequestDispatcher("country-list.jsp");
		dispatcher.forward(request, response);
	}
	private void listeditCountry(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Country> listCountry = countryDAO.selectAllCountrys();
		request.setAttribute("listCountry", listCountry);
		RequestDispatcher dispatcher = request.getRequestDispatcher("loggedinlist.jsp");
		dispatcher.forward(request, response);
	}
	

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("country-form.jsp");
		dispatcher.forward(request, response);
	}
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, ServletException, IOException {
		        int id = Integer.parseInt(request.getParameter("id"));
		        Country existingCountry = countryDAO.selectCountry(id);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("country-form.jsp");
		        request.setAttribute("country", existingCountry);
		        dispatcher.forward(request, response);
		    }
	private void insertCountry(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String name = request.getParameter("name");
		Float $2022 = Float.parseFloat(request.getParameter("$2022"));
		Float $2021 = Float.parseFloat(request.getParameter("$2021"));
		Float $2020 = Float.parseFloat(request.getParameter("$2020"));
		Country newCountry = new Country (name, $2022, $2021, $2020);
		countryDAO.insertCountry(newCountry);
		response.sendRedirect("list");
	}

	private void updateCountry(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		float $2020 = Float.parseFloat(request.getParameter("$2020"));
		float $2021 = Float.parseFloat(request.getParameter("$2021"));
		float $2022 = Float.parseFloat(request.getParameter("$2022"));
		Country book = new Country(id, name, $2020, $2021, $2022);
		countryDAO.updateCountry(book);
		response.sendRedirect("listedit");
	}

}	

