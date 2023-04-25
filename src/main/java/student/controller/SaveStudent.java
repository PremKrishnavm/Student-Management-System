package student.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import student.Dao.AdminDao;
import student.Dao.StudentDao;
import student.Dto.Admin;
import student.Dto.Student;

@WebServlet("/save")
public class SaveStudent extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		Admin admin = (Admin) session.getAttribute("admin");
		if (admin != null) {

			String name = req.getParameter("studentName");
			String gender = req.getParameter("studentGender");
			String StringStudentPh_no = req.getParameter("studentPh_no");
			String email = req.getParameter("studentEmail");

			long PhoneNumber = Long.parseLong(StringStudentPh_no);

			ServletContext context = getServletContext();
			String fee = context.getInitParameter("studentFee");

			double studentfee = Double.parseDouble(fee);

			Student student = new Student();
			student.setStudentName(name);
			student.setStudentGender(gender);
			student.setStudentPh_no(PhoneNumber);
			student.setStudentEmail(email);
			student.setStudentFee(studentfee);
			student.setAdmin(admin);

			new StudentDao().saveStudent(student);
			// after saving the student assign the student to the related admin
			List<Student> students = admin.getStudents();
			students.add(student);
			new AdminDao().updateAdmin(admin);

			resp.sendRedirect("Dashboard.jsp");
		} else {
			resp.sendRedirect("AdminLogin.jsp");
		}
	}
}
