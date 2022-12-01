package com.week7.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.week7.UserDao.ProductDao;
import com.week7.controller.Factory;
import com.week7.entities.Products;

/**
 * Servlet implementation class UpdateServlet
 */
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out=response.getWriter();
		try {
	
		int id=Integer.parseInt(request.getParameter("id"));
		String title=request.getParameter("title");
		String size=request.getParameter("size");
		int quantity=Integer.parseInt(request.getParameter("quantity"));
		String image=request.getParameter("image");
		
  
		ProductDao pdao=new ProductDao(Factory.getFactory());
		Products prod = new Products(id, title, quantity, size, image);
		pdao.updateProduct(prod);
//		HttpSession httpSession= request.getSession();
		response.sendRedirect("admin.jsp");	
		} catch (Exception e) {
			// TODO: handle exception
			
		}
		doGet(request, response);
		doGet(request, response);
	}

}
