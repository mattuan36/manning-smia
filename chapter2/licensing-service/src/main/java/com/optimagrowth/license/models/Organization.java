package com.optimagrowth.license.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Organization {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @Enumerated(EnumType.STRING)
    private Category category;

    private String establishedDate;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person president;

    @ManyToMany(mappedBy = "organization")
    @JsonIgnore
    private List<Person> members;

    private int memSize;

    public Organization() {}

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
    public String getEstablishedDate(){
        return establishedDate;
    }
    public void setEstablishedDate(String establishedDate){
        this.establishedDate = establishedDate;
    }

    public Person getPresident() {
        return president;
    }

    public void setPresident(Person president) {
        this.president = president;
    }

    public List<Person> getMembers() {
        return members;
    }
    public void setMembers(List<Person> members) {
        this.members = members;
        this.memSize = members.size();
    }

    @Override
    public String toString() {
        return "Organization [id = " + id + ", name = " + name + ", category = " + category +
                ", establishedDate = " + establishedDate + ", # of members = " + memSize + "]";
    }

}

