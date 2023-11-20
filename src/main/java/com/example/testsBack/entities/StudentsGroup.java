package com.example.testsBack.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "\"StudentsGroup\"")
public class StudentsGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"StudentsGroupID\"", nullable = false)
    private Long id;

    @NotNull
    @Column(name = "\"StudentsGroupName\"", nullable = false, length = Integer.MAX_VALUE)
    private String studentsGroupName;

    @OneToMany(mappedBy = "studentsGroupID")
    private Set<User> users = new LinkedHashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentsGroupName() {
        return studentsGroupName;
    }

    public void setStudentsGroupName(String studentsGroupName) {
        this.studentsGroupName = studentsGroupName;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

}