package com.project.ElectricityBillingSystem.Entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity                  // @Entity-->class & it can be mapped to a table
@Table(name="address")  // @Table--> actual database table that you will access through program
                                    // specifies the name of DB table
public class AddressEntity {

@Id                    // it's a primary key of an entity
	private int id;
	
  //Validations // @NotNull--> A method should not return null,,
	@NotNull(message = "doorNo is mandatory")
	private String doorNo;

	@NotNull(message = "street is mandatory")
	@Size(min=3, max=10, message="Min 3 and max 10 charecters are allowed")
	private String street;

	@NotNull(message = "city is mandatory")
	@Size(min=3, max=10, message="Min 3 and max 10 charecters are allowed")
	private String city;
	
	@NotNull(message = "state is mandatory")
	@Size(min=3, max=10, message="Min 3 and max 10 charecters are allowed") 
	// string has a value,,whose length bounded by min & max
	private String state;
	
	@NotNull(message = "pincode is mandatory")
		private int pincode;
	
	// Mapping with Customer
	    // one to one-->single entity is associated with a single instance of other
	@OneToOne(mappedBy = "addressEntity")
	private CustomerEntity customerEntity;


	// default constructor-->
		// used to initialize any uninitialised instance variables with default values
	public AddressEntity() {
		super();
	}
	// parameterized constructor
		// it accepts parameters,which you can initialize the instance variables
	public AddressEntity(int id, String d_no, String street, String city, String state, int pincode) {
		// super()-->it refers to super or parent class objects-
				// -when we want to inherit some parameters from super class
		super();
		// this. --> keyword, refers to current obj in a method/constructor
		this.id = id;
		this.doorNo = d_no;
		this.street = street;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}
	
	// Getters & Setters
		// used to retrieving & updating the values of the variables
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDno() {
		return doorNo;
	}
	public void setDno(String dno) {
		this.doorNo = dno;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
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
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	
	// @override allows sub/child class to provide a specific implementation of a
		// method that is already -provided by 1 of its super/parent class
		// toString()--> To return a string representation of an object
	@Override
	public String toString() {
		return "AddressEntity [id=" + id + ", d_no=" + doorNo + ", street=" + street + ", city=" + city + ", state="
				+ state + ", pincode=" + pincode +"]";
	}
}
