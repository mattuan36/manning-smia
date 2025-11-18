package com.optimagrowth.orders.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.ToString;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;


@ToString
@Entity
@Table(name="orders")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Orders extends RepresentationModel<Orders> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String ordersNumber;

	@Enumerated(EnumType.STRING)
	private OrdersStatus ordersStatus;
	private String customerName;
	private String ordersDate;
	private Long cartId;
	@Column(name="comment")
	private String comment;

	public Long getId(){
		return id;
	}
	public void setId(Long id){
		this.id = id;
	}
	public String getOrdersNumberordersNumber(){
		return ordersNumber;
	}
	public void setOrdersNumber(String ordersNumber){
		this.ordersNumber = ordersNumber;
	}
	public OrdersStatus getOrdersStatus(){
		return ordersStatus;
	}
	public void setOrdersStatus(OrdersStatus ordersStatus){
		this.ordersStatus = ordersStatus;
	}
	public String getCustomerName(){
		return customerName;
	}
	public void setCustomerName(String customerName){
		this.customerName = customerName;
	}
	public String getOrdersDate(){
		return ordersDate;
	}
	public void setOrdersDate(String ordersDate) {
		this.ordersDate = ordersDate;
	}
	public Long getCartId() {return cartId;}
	public void setCartId(Long cartId) {this.cartId = cartId;}

	public void setComment(String comment){
		this.comment = comment;
	}
	public String getComment(){
		return comment;
	}

	public Orders withComment(String comment){
		this.setComment(comment);
		return this;
	}
}