package com.example.testsBack.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "\"TestResultUserAnswerService\"")
public class TestResultUserAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"TestResultUserAnswerID\"", nullable = false)
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "\"UserAnswerID\"", nullable = false)
    private UserAnswer userAnswerID;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "\"TestResultID\"", nullable = false)
    private TestResult testResultID;

    @OneToMany(mappedBy = "testResultUserAnswerID")
    private Set<TestResult> testResults = new LinkedHashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserAnswer getUserAnswerID() {
        return userAnswerID;
    }

    public void setUserAnswerID(UserAnswer userAnswerID) {
        this.userAnswerID = userAnswerID;
    }

    public TestResult getTestResultID() {
        return testResultID;
    }

    public void setTestResultID(TestResult testResultID) {
        this.testResultID = testResultID;
    }

    public Set<TestResult> getTestResults() {
        return testResults;
    }

    public void setTestResults(Set<TestResult> testResults) {
        this.testResults = testResults;
    }

}