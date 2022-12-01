package com.week7.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.week7.UserDao.ProductDao;
import com.week7.UserDao.UserDao;
import com.week7.controller.Factory;
import com.week7.entities.Products;
import com.week7.entities.User;

/**
 * Servlet implementation class DeleteServlet
 */
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		try {
	
		int id=Integer.parseInt(request.getParameter("id"));
		ProductDao pdao=new ProductDao(Factory.getFactory());
		pdao.deleteProduct(id);
//		HttpSession httpSession= request.getSession();
		response.sendRedirect("admin.jsp");	
		} catch (Exception e) {
			// TODO: handle exception
			
		}
		doGet(request, response);
	}

}
