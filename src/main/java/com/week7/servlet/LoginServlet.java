package com.week7.servlet;


import java.io.IOException;
import java.io.PrintWriter;



import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import org.apache.jasper.tagplugins.jstl.core.Out;
import org.hibernate.SessionFactory;



import com.google.protobuf.ByteString.Output;
import com.week7.controller.Factory;
import com.week7.UserDao.UserDao;
import com.week7.entities.User;
public class LoginServlet extends HttpServlet {
private static final long serialVersionUID = 1L;

public LoginServlet() {
super();
// TODO Auto-generated constructor stub
}
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// TODO Auto-generated method stub
response.getWriter().append("Served at: ").append(request.getContextPath());
String userEmail=request.getParameter("userEmail");
String userPassword=request.getParameter("userPassword");
UserDao userdao=new UserDao(Factory.getFactory());
User user=userdao.getUserByEmailAndPassword(userEmail, userPassword);
HttpSession httpSession= request.getSession();

if(user==null)
{
httpSession.setAttribute("message","Invalid id/password");
response.sendRedirect("index.jsp");
return;
}
else
{
httpSession.setAttribute("current-user", userEmail);
response.sendRedirect("admin.jsp");

}







}
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// TODO Auto-generated method stub
doGet(request, response);
}

}

