package com.example.testsBack.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "\"University\"")
public class University {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"UniversityID\"", nullable = false)
    private Long id;

    @NotNull
    @Column(name = "\"UniversityName\"", nullable = false, length = Integer.MAX_VALUE)
    private String universityName;

    @OneToMany(mappedBy = "universityID")
    private Set<User> users = new LinkedHashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

}