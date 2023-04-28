package com.jalaproject.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.jalaproject.entities.Student;
import com.jalaproject.helper.FactoryProvider;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String email = request.getParameter("userEmail");
		LocalDate userDOB = LocalDate.parse(request.getParameter("userDOB"));

		Session s = FactoryProvider.getFactory().openSession();
		Transaction tx = s.beginTransaction();

		Query<Student> query = s.createQuery("FROM Student WHERE email=:email", Student.class);
		query.setParameter("email", email);

		List<Student> students = query.getResultList();
		Student student = null;

		if (students.size() > 0) {
			student = students.get(0);
		}
		out.println("<html>");
		out.println("<body bgcolor='lightblue'>");
		out.println("<center>");
		out.println("<font color='red' size='6'>");
		out.println("<br><br><br>");
		if (student != null && student.getDob().equals(userDOB)) {
			out.println("Login Successful!");
		} else {
			out.println("Login Failed");
		}

		out.println("</font></center></body></html>");
		
		tx.commit();
		s.close();

	}

}
