package com.jalaproject.entities;

import java.time.LocalDate;
import java.util.Random;

import javax.persistence.Entity;

import javax.persistence.Id;

@Entity
public class Student {

	@Id
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private LocalDate dob;
	private String gender;
	private String address;
	private String country;
	private String city;
	private String qualification;
	private String skills;

	// Getters and Setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob2) {
		this.dob = dob2;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	// Constructors
	public Student(String firstName, String lastName, String email, String phone, LocalDate dob, String gender,
			String address, String country, String city, String qualification, String skills) {
		super();
		this.id = new Random().nextInt(10000);
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.dob = dob;
		this.gender = gender;
		this.address = address;
		this.country = country;
		this.city = city;
		this.qualification = qualification;
		this.skills = skills;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", phone=" + phone + ", dob=" + dob + ", gender=" + gender + ", address=" + address + ", country="
				+ country + ", city=" + city + ", qualification=" + qualification + ", skills=" + skills + "]";
	}

	

}
