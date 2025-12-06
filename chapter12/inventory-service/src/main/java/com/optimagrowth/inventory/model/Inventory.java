package com.optimagrowth.inventory.model;

import javax.persistence.*;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.ToString;


@ToString
@Entity
@Table(name="inventory")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Inventory extends RepresentationModel<Inventory> {

	@Id
	@Column(name = "inventory_id", nullable = false)
    private String inventoryId;
    private String name;

    @Enumerated(EnumType.STRING)
    private Category category;
    private String description;
    private Long stock;
    @Column(name="comment")
    private String comment;

    public String getInventoryId(){
        return inventoryId;
    }
    public void setInventoryId(String inventoryId){
        this.inventoryId = inventoryId;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public Category getCategory(){
        return category;
    }
    public void setCategory(Category category){
        this.category = category;
    }
    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public Long getStock() {return stock;}
    public void setStock(Long stock) { this.stock = stock;}

    public void setComment(String comment){
        this.comment = comment;
    }
    public String getComment(){
        return comment;
    }

    public Inventory withComment(String comment){
        this.setComment(comment);
        return this;
    }
}