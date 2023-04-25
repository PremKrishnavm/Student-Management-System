package student.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import student.Dao.StudentDao;
import student.Dto.Admin;
import student.Dto.Student;

@WebServlet("/viewStudents")
public class getAllStudents extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		Admin admin = (Admin) session.getAttribute("admin");
		if (admin != null) {

			List<Student> students = new StudentDao().getAllStudents(admin);

			req.setAttribute("students", students);

			req.getRequestDispatcher("ViewStudents.jsp").forward(req, resp);
		} else {
			resp.sendRedirect("AdminLogin.jsp");
		}
	}
}
