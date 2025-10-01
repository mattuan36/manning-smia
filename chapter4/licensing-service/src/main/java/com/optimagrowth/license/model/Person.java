package com.optimagrowth.license.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter @Setter @ToString
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String major;
    private String dept;
    private String dateOfBirth;
    private String phone;
    private String email;

    @OneToMany
    @JsonIgnore
    private List<Organization> presidentOrganizations;

    @ManyToMany
    @JsonIgnore
    private List<Organization> organization;
}
