package com.capgemini.accountopening.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="c_address")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ContactDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="address_id")
	private Long address_Id;
	
	@Column(name="customer_id")
	private Long customer_Id;
	
	@Column(name="address1")
	private String address1;
	
	@Column(name="address2")
	private String address2;
	
	@Column(name="city")
	private String city;
	
	@Column(name="state")
	private String state;
	
	@Column(name="postal")
	private int postal;
	
	@Column(name="country")
	private String country;
	
	@Column(name="phone")
	private String phone;
	
	@Column(name="email")
	private String email;

	public Long getAddress_Id() {
		return address_Id;
	}

	public void setAddress_Id(Long address_Id) {
		this.address_Id = address_Id;
	}

	public Long getCustomer_Id() {
		return customer_Id;
	}

	public void setCustomer_Id(Long customer_Id) {
		this.customer_Id = customer_Id;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPostal() {
		return postal;
	}

	public void setPostal(int postal) {
		this.postal = postal;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "ContactDetails [address_Id=" + address_Id + ", customer_Id=" + customer_Id + ", address1=" + address1
				+ ", address2=" + address2 + ", city=" + city + ", state=" + state + ", postal=" + postal + ", country="
				+ country + ", phone=" + phone + ", email=" + email + "]";
	}
	
}