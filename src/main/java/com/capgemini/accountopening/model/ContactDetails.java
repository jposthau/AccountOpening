package com.capgemini.accountopening.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

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
	private Long customerId;
	
	@Column(name="address1")
	@Size(min=1, message="Field cannot be empty")
	private String address1;
	
	@Column(name="address2")
	private String address2;
	
	@Column(name="city")
	@Size(min=1, message="Field cannot be empty")
	private String city;
	
	@Column(name="state")
	@Size(min=1, message="Field cannot be empty")
	private String state;
	
	@Column(name="postal")
	@Size(min=5, max=5, message="Invalid postal code")
	private String postal;
	
	@Column(name="country")
	@Size(min=1, message="Field cannot be empty")
	private String country;
	
	@Column(name="phone")
	@Size(min=1, message="Field cannot be empty")
	private String phone;
	
	@Column(name="email")
	@Email
	@Size(min=1, message="Field cannot be empty")
	private String email;

	public Long getAddressId() {
		return address_Id;
	}

	public void setAddressId(Long address_Id) {
		this.address_Id = address_Id;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
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

	public String getPostal() {
		return postal;
	}

	public void setPostal(String postal) {
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
		return "ContactDetails [address_Id=" + address_Id + ", customer_Id=" + customerId + ", address1=" + address1
				+ ", address2=" + address2 + ", city=" + city + ", state=" + state + ", postal=" + postal + ", country="
				+ country + ", phone=" + phone + ", email=" + email + "]";
	}
	
}
