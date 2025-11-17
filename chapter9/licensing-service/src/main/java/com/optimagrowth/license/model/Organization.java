package com.optimagrowth.license.model;

import org.springframework.hateoas.RepresentationModel;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class Organization extends RepresentationModel<Organization> {

	private String id;
    private String name;
    private String contactName;
    private String contactEmail;
    private String contactPhone;

    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return id;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

    public void setContactName(String contactName){
        this.contactName = contactName;
    }
    public String getContactName(){
        return contactName;
    }

    public void setContactEmail(String contactEmail){
        this.contactEmail = contactEmail;
    }
    public String getContactEmail(){
        return contactEmail;
    }

    public void setContactPhone(String contactPhone){
        this.contactPhone = contactPhone;
    }
    public String getContactPhone(){
        return contactPhone;
    }

}
