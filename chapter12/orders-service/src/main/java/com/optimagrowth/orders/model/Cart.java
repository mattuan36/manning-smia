package com.optimagrowth.orders.model;

import lombok.ToString;

import javax.persistence.*;

@ToString
@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @Column(name = "cart_id", nullable = false)
    private String cartId;

    private String items;

    public String getCartId(){
        return cartId;
    }
    public void setCartId(String cartId){
        this.cartId = cartId;
    }
    public String getItems(){
        return items;
    }
    public void setItems(String items){
        this.items = items;
    }
}
