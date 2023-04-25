package student.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student.Dao.StudentDao;
import student.Dto.Student;

@WebServlet("/updateStudent")
public class UpdateStudent extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// you have to find a existing student from the database,
		// then send the student to the jsp file.
		// then grt data from the jsp and save it.
		String id = req.getParameter("studentId");
		Student student = new StudentDao().getStudent(Integer.parseInt(id));
		
		req.setAttribute("students", student);
		
		req.getRequestDispatcher("UpdateStudent.jsp").forward(req, resp);
	}
}
