package com.jalaproject.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.jalaproject.entities.Student;
import com.jalaproject.helper.FactoryProvider;

public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			// 1. Validate the form data
			int studentId = Integer.parseInt(request.getParameter("studentId").trim());
			String firstName = request.getParameter("userFirstName");
			String lastName = request.getParameter("userLastName");
			String email = request.getParameter("userEmail");
			String phone = request.getParameter("userPhone");
			LocalDate dob = LocalDate.parse(request.getParameter("userDOB"));
			String gender = request.getParameter("userGender");
			String address = request.getParameter("userAddress");
			String country = request.getParameter("userCountry");
			String city = request.getParameter("userCity");
			String qualification = request.getParameter("userQualification");
			String[] skills = request.getParameterValues("userSkills");
			String skill = String.join(", ", skills);

			// Validate required fields
			if (firstName == null || firstName.trim().isEmpty() || lastName == null || lastName.trim().isEmpty()
					|| email == null || email.trim().isEmpty() || phone == null || phone.trim().isEmpty() || dob == null
					|| gender == null || gender.trim().isEmpty() || address == null || address.trim().isEmpty()
					|| country == null || country.trim().isEmpty() || city == null || city.trim().isEmpty()
					|| qualification == null || qualification.trim().isEmpty() || skills == null
					|| skills.length == 0) {
				response.sendRedirect("registrationform.html?error=Please fill in all required fields");
				return;
			}

			// Validate phone number format
			if (!phone.matches("\\d{10}")) {
				response.sendRedirect("registrationform.html?error=Please enter a valid phone number");
				return;
			}

			Session s = FactoryProvider.getFactory().openSession();
			Transaction tx = s.beginTransaction();

			Student student = s.get(Student.class, studentId);

			student.setFirstName(firstName);
			student.setLastName(lastName);
			student.setEmail(email);
			student.setPhone(phone);
			student.setDob(dob);
			student.setGender(gender);
			student.setAddress(address);
			student.setCountry(country);
			student.setCity(city);
			student.setQualification(qualification);
			student.setSkills(skill);

			tx.commit();
			s.close();

			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<h1 style='text-align: center;'>Record updated successfully</h1>");
			out.println("<h1 style='text-align: center;'><a href='all_student.jsp'>View all Students</a></h1>");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
