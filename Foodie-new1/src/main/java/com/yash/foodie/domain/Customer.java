package com.yash.foodie.domain;

import java.util.Collection;

/**
 * Model class of Employee which have attribute of employee and constructor and Getter and Setter
 * @author harshita.verma
 */

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
 
@Entity
/**
 * Table Create Through Hibernate No Need To Create Manually
 */
@Table(name = "customer") 
public class Customer implements UserDetails {
	/**
	 * id of customer
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * firstName of customer
	 */
	@NotBlank(message = "first name is required")
	@Size(min = 4, max = 255, message = "please use 4 to 255 characters for customer firstname")
	
	private String firstName;
	
	/**
	 * lastName of customer
	 */
	@NotBlank(message = "last name is required")
	@Size(min = 4, max = 255, message = "please use 4 to 255 characters for customer lastname")
	
	private String lastName;


	/**
	 * age of customer
	 */
//	@NotBlank(message = "customer age is required")
	
	private int age;


	/**
	 * gender of customer
	 */
	@NotBlank(message = "gender of customer is required")
	
	private String gender;
	
	/**
	 * mobileNumber of customer
	 */
	@NotBlank(message = "mobileNumber is required")
	
	private String mobileNumber;
	
	/**
	 * address of customer
	 */
	//@NotBlank(message = "address is required")
	@OneToOne
	@JoinColumn(name = "ano")
	@Cascade(CascadeType.ALL)
	@JsonIgnore
	private Address address;
	
	
	

	
	/**
	 * email of customer
	 */
	@NotBlank(message = "email is required")
	
	private String email;
	
	/**
	 * status of customer
	 */
	@ColumnDefault("1")
	private int status;

	@NotBlank(message = "password is required")
	private String password;
	
	private String role;
	
	/**
	 * Default Constructor
	 */
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	/**
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param age
	 * @param gender
	 * @param mobileNumber
	 * @param address
	 * @param email
	 * @param status
	 */
	public Customer(Long id,
			@NotBlank(message = "first name is required") @Size(min = 4, max = 255, message = "please use 4 to 255 characters for customer firstname") String firstName,
			@NotBlank(message = "last name is required") @Size(min = 4, max = 255, message = "please use 4 to 255 characters for customer lastname") String lastName,
			 int age,
			@NotBlank(message = "gender of customer is required") String gender,
			@NotBlank(message = "mobileNumber is required") String mobileNumber,
			@NotBlank(message = "address is required") Address address,
			@NotBlank(message = "email is required") String email,int status,
			@NotBlank(message = "password is required") String password) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.mobileNumber = mobileNumber;
		this.address = address;
		this.email = email;
		this.status = status;
		this.password = password;
	}

	

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}


	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}


	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}


	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}


	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}


	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}


	/**
	 * @return the mobileNumber
	 */
	public String getMobileNumber() {
		return mobileNumber;
	}


	/**
	 * @param mobileNumber the mobileNumber to set
	 */
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}


	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}


	/**
	 * @param address the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}


	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}


	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}


	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}


	/**
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age
				+ ", gender=" + gender + ", mobileNumber=" + mobileNumber + ", address=" + address + ", email=" + email
				+ ", status=" + status + ", password=" + password + "]";
	}


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	@JsonIgnore
	public String getUsername() {
		// TODO Auto-generated method stub
		return getEmail();
	}


	@Override
	@JsonIgnore
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	@JsonIgnore
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	@JsonIgnore
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	@JsonIgnore
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}


	

	
}
