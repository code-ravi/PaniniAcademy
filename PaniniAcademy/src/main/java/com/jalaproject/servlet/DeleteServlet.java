package com.jalaproject.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.jalaproject.entities.Student;
import com.jalaproject.helper.FactoryProvider;

public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			int studentId = Integer.parseInt(request.getParameter("student_id").trim());

			// to perform delete operation using hibernate
			Session session = FactoryProvider.getFactory().openSession();
			Transaction tx = session.beginTransaction();

			Student student = session.get(Student.class, studentId);

			session.delete(student);
			tx.commit();
			session.close();
			
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<h1 style='text-align: center;'>Record deleted successfully!</h1>");
			
			out.println("<h1 style='text-align: center;'><a href='all_student.jsp'>View all Students</a></h1>");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
