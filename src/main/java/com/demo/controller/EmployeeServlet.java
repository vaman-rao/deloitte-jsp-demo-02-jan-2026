package com.demo.controller;

import com.demo.model.Employee;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/employees")
public class EmployeeServlet extends HttpServlet {

	private static final long serialVersionUID = -3463112793575983719L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// Model data
		List<Employee> list = new ArrayList<>();
		list.add(new Employee(101, "Sonu"));
		list.add(new Employee(102, "Monu"));
		list.add(new Employee(103, "Tonu"));

		// Pass data to view
		req.setAttribute("employees", list);

		// Forward to JSP
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/employees.jsp");

		rd.forward(req, resp);
	}
}
