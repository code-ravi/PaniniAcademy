<%@page import="com.jalaproject.entities.Student"%>
<%@page import="com.jalaproject.helper.FactoryProvider"%>
<%@page import="org.hibernate.Session"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Your details</title>

</head>
<body>
	<div>
		<h1>Edit Your Details</h1>
		<br>
		<%
		int studentId = Integer.parseInt(request.getParameter("student_id").trim());
		Session s = FactoryProvider.getFactory().openSession();
		Student student = (Student) s.get(Student.class, studentId);
		s.close();
		%>

			<!-- This is update form -->
			<form action="update" method="post">
				<input value="<%=student.getId()%>" name="studentId" type="hidden" />
				<table>
				<tr>
					<td>First Name</td>
					<td><input type="text" name="userFirstName" required="required" 
						 value="<%=student.getFirstName()%>" /></td>
				</tr>
				<tr>
					<td>Last Name</td>
					<td><input type="text" name="userLastName" required="required" 
					value="<%=student.getLastName()%>"/></td>
				</tr>
				<tr>
					<td>Email</td>
					<td><input type="email" name="userEmail" required="required" 
					value="<%=student.getEmail()%>"/></td>
				</tr>
				<tr>
					<td>Phone Number</td>
					<td><input type="number" name="userPhone" required="required" 
					value="<%=student.getPhone()%>"/></td>
				</tr>
				<tr>
					<td>Date Of Birth</td>
					<td><input type="date" name="userDOB" required="required" 
					value="<%=student.getDob()%>"/></td>
				</tr>
				<tr >
					<td>Gender</td>
					<td><input type="radio" name="userGender" value="Male" />Male
						<input type="radio" name="userGender" value="Female" />Female 
						<input type="radio" name="userGender" value="noGender" />Other
					</td>
				</tr>
				<tr > <td>Address</td>
					<td><textarea rows="4" cols="80" name="userAddress">
					<%=student.getAddress()%>"</textarea></td>
				</tr>
				<tr>
					<td >Country</td>
					<td><select name="userCountry" required="required">
							<option value="India" >India</option>
							<option value="Russia">Russia</option>
							<option value="USA">USA</option>
							<option value="Brazil">Brazil</option>
							<option value="France">France</option>
					</select></td>
				</tr>
				<tr><td>City</td>
					<td><input type="text" name="userCity" required="required" 
					value="<%=student.getCity()%>"/></td>
				<tr>
					<td>Heighest Qualification</td>
					<td>
						<input type="radio" name="userQualification" value="BSC" />BSC
						<input type="radio" name="userQualification" value="BTech/BE" />BTech/BE
						<input type="radio" name="userQualification" value="MTech" />MTech
						<input type="radio" name="userQualification" value="BCA" />BCA 
						<input type="radio" name="userQualification" value="PHD" />PHD 
						<input type="radio" name="userQualification" value="BSC" />BCom
					</td>		
				</tr>	
				<tr>
					<td>Skills</td>
					<td>
							<input type="checkbox" name="userSkills" value="AWS" />AWS
							<input type="checkbox" name="userSkills" value=" QA-Automation" /> QA-Automation
							<input type="checkbox" name="userSkills" value="WebServices" />WebServices
							<input type="checkbox" name="userSkills" value="DevOps" />DevOps
							<input type="checkbox" name="userSkills" value="fullstack" />Full Stack Developer
							<input type="checkbox" name="userSkills" value="Middleware" />Middleware
					</td>
				</tr> 
				<tr>
					<td><input type="submit" value="Save"/></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>