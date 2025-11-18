package com.optimagrowth.orders.model;

import lombok.ToString;

import javax.persistence.*;

@ToString
@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String items;

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getItems(){
        return items;
    }
    public void setItems(String items){
        this.items = items;
    }
}
