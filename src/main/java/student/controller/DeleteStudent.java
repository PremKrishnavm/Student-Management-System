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

@WebServlet("/deleteStudent")
public class DeleteStudent extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Admin admin = (Admin) session.getAttribute("admin");

		if (admin != null) {

			String StudentId = (String) req.getParameter("studentId");

			int id = Integer.parseInt(StudentId);

			StudentDao dao = new StudentDao();

			dao.deleteStudent(id);

			List<Student> students = dao.getAllStudents(admin);
			req.setAttribute("students", students);

			req.getRequestDispatcher("ViewStudents.jsp").forward(req, resp);
		} else {
			resp.sendRedirect("AdminLogin.jsp");
		}
	}
}