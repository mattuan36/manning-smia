package com.optimagrowth.customer.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.ToString;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;


@ToString
@Entity
@Table(name="customers")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Customer extends RepresentationModel<Customer> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String address;
	@Column(name="comment")
	private String comment;

	public Long getId(){
		return id;
	}
	public void setId(Long id){
		this.id = id;
	}
	public String getFirstName(){
		return firstName;
	}
	public void setFirstName(String firstName){
		this.firstName = firstName;
	}
	public String getLastName(){
		return lastName;
	}
	public void setLastName(String lastName){
		this.lastName = lastName;
	}
	public String getEmail(){
		return email;
	}
	public void setEmail(String email){
		this.email = email;
	}
	public String getAddress(){
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public void setComment(String comment){
		this.comment = comment;
	}
	public String getComment(){
		return comment;
	}

	public Customer withComment(String comment){
		this.setComment(comment);
		return this;
	}
}