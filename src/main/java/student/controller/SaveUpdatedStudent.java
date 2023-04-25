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

@WebServlet("/saveUpdatedStudent")
public class SaveUpdatedStudent extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Admin admin = (Admin) session.getAttribute("admin");

		if (admin != null) {

			int StudentId = Integer.parseInt(req.getParameter("studentId"));
			String studentName = req.getParameter("studentName");
			String StudentGender = req.getParameter("studentGender");
			String studentEmail = req.getParameter("studentEmail");
			long studentPh_No = Long.parseLong(req.getParameter("studentPhoneNumber"));
			double studentFee = Double.parseDouble(req.getParameter("studentFee"));

			Student student = new Student();
			student.setStudentId(StudentId);
			student.setStudentName(studentName);
			student.setStudentGender(StudentGender);
			student.setStudentPh_no(studentPh_No);
			student.setStudentEmail(studentEmail);
			student.setStudentFee(studentFee);
			student.setAdmin(admin);

			new StudentDao().updateStudent(student);

			List<Student> students = new StudentDao().getAllStudents(admin);
			req.setAttribute("students", students);

			req.getRequestDispatcher("ViewStudents.jsp").forward(req, resp);

		} else {
			resp.sendRedirect("AdminLogin.jsp");
		}
	}
}