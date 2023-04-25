package student.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import student.Dao.AdminDao;
import student.Dto.Admin;

@WebServlet("/login")
public class AdminLogin extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("AdminEmail");
		String password = req.getParameter("AdminPassword");
		
		Admin admin	= new AdminDao().AdminLogin(email, password);
		
		if(admin!=null) {
			HttpSession session = req.getSession();
			// getSession method will check if there is any previous session started anywhere
			// before in this project. for the perticular browser,
			// if there is no session found a new session object if created , or else 
			// the existing session object will be given.
			
//			req.setAttribute("admin", admin);
			session.setAttribute("admin", admin);
			req.getRequestDispatcher("Dashboard.jsp").forward(req, resp);		
		}else {
			resp.sendRedirect("AdminSignUp.jsp");
		}
	}

}
