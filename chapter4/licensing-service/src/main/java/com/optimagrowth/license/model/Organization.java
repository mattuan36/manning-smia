package com.optimagrowth.license.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter @Setter @ToString
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

}

