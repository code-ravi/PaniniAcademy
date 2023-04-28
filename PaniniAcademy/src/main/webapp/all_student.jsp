<%@page import="org.hibernate.Query"%>
<%@page import="com.jalaproject.entities.Student"%>
<%@page import="java.util.List"%>

<%@page import="com.jalaproject.helper.FactoryProvider"%>
<%@page import="org.hibernate.Session"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Students</title>
<%@include file="bootstrap_links.jsp"%>
</head>
<body>
	<div class="container">
		<h2 class="mb-3">All Students</h2>

		<a href="./registrationform.html" target="body"
			class="btn btn-primary my-3">Add Student</a>

		<div class="table-responsive">
			<table class="table table-bordered table-striped">
				<thead>
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email</th>
						<th>Phone</th>
						<th>Gender</th>
						<th>Date of Birth</th>
						<th>Country</th>
						<th>City</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<%
					Session s = FactoryProvider.getFactory().openSession();
					Query q = s.createQuery("from Student");
					List<Student> studentList = q.list();
					for (Student student : studentList) {
					%>
					<tr>
						<td><%=student.getFirstName()%></td>
						<td><%=student.getLastName()%></td>
						<td><%=student.getEmail()%></td>
						<td><%=student.getPhone()%></td>
						<td><%=student.getGender()%></td>
						<td><%=student.getDob()%></td>
						<td><%=student.getCountry()%></td>
						<td><%=student.getCity()%></td>
						<td class="text-nowrap"><a class="btn btn-primary"
							href="update_student.jsp?student_id=<%=student.getId()%>">Edit</a>
							<a class="btn btn-danger"
							href="delete?student_id=<%=student.getId()%>">Delete</a></td>
					</tr>
					<%
					}
					s.close();
					%>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>

