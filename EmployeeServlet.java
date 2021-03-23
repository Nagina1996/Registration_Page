package net.javaguides.registration.controller;
import javax.servlet.*;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.javaguides.registration.dao.EmployeeDao;
import net.javaguides.registration.model.Employee;

@WebServlet("/register")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private EmployeeDao employeeDao=new EmployeeDao();
       
   
    public EmployeeServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB_INF/views/EmployeeRegister.jsp");
		dispatcher.forward(request,response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		String Firstname=request.getParameter("Firstname");
		String Lastname=request.getParameter("Lastname");
		String Username=request.getParameter("Username");
		String Password=request.getParameter("Password");
		String Address=request.getParameter("Address");
		String Contact=request.getParameter("Contact");
		
		Employee employee=new Employee();
		employee.setFirstname(Firstname);
		employee.setLastname(Lastname);
		employee.setUsername(Username);
		employee.setPassword(Password);
		employee.setAddress(Address);
		employee.setContact(Contact);
		
		try{
			employeeDao.registerEmployee(employee);
		}
	catch(ClassNotFoundException e) {
		e.printStackTrace();
	}
		RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB_INF/views/employeedetails.jsp");
		dispatcher.forward(request,response);
		
		
	}

}
