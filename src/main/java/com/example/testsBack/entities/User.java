package com.example.testsBack.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "\"user\"")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"UserID\"", nullable = false)
    private Long id;

    @NotNull
    @Column(name = "\"FullName\"", nullable = false, length = Integer.MAX_VALUE)
    private String fullName;

    @Column(name = "\"Email\"", length = Integer.MAX_VALUE)
    private String email;

    @Column(name = "\"Password\"", length = Integer.MAX_VALUE)
    private String password;

    @Column(name = "\"PasswordSalt\"", length = Integer.MAX_VALUE)
    private String passwordSalt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "\"UniversityID\"")
    private University universityID;

    @Column(name = "\"TelegramLogin\"", length = Integer.MAX_VALUE)
    private String telegramLogin;

    @Column(name = "\"TelegramID\"", length = Integer.MAX_VALUE)
    private String telegramID;

    @Column(name = "\"PhoneNumber\"", length = Integer.MAX_VALUE)
    private String phoneNumber;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "\"RoleID\"", nullable = false)
    private Role roleID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "\"StudentsGroupID\"")
    private StudentsGroup studentsGroupID;

    @OneToMany(mappedBy = "userID")
    private Set<TestResult> testResults = new LinkedHashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordSalt() {
        return passwordSalt;
    }

    public void setPasswordSalt(String passwordSalt) {
        this.passwordSalt = passwordSalt;
    }

    public University getUniversityID() {
        return universityID;
    }

    public void setUniversityID(University universityID) {
        this.universityID = universityID;
    }

    public String getTelegramLogin() {
        return telegramLogin;
    }

    public void setTelegramLogin(String telegramLogin) {
        this.telegramLogin = telegramLogin;
    }

    public String getTelegramID() {
        return telegramID;
    }

    public void setTelegramID(String telegramID) {
        this.telegramID = telegramID;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Role getRoleID() {
        return roleID;
    }

    public void setRoleID(Role roleID) {
        this.roleID = roleID;
    }

    public StudentsGroup getStudentsGroupID() {
        return studentsGroupID;
    }

    public void setStudentsGroupID(StudentsGroup studentsGroupID) {
        this.studentsGroupID = studentsGroupID;
    }

    public Set<TestResult> getTestResults() {
        return testResults;
    }

    public void setTestResults(Set<TestResult> testResults) {
        this.testResults = testResults;
    }

}