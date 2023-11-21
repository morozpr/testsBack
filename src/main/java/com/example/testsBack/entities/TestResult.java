package com.example.testsBack.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "\"testResult\"")
public class TestResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"TestResultID\"", nullable = false)
    private Long id;

    @Column(name = "\"CorrectPercent\"", length = Integer.MAX_VALUE)
    private String correctPercent;

    @Column(name = "\"SkippedPercent\"", length = Integer.MAX_VALUE)
    private String skippedPercent;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "\"TestID\"", nullable = false)
    private Test testID;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "\"UserID\"", nullable = false)
    private User userID;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "\"TestResultUserAnswerID\"", nullable = false)
    private TestResultUserAnswer testResultUserAnswerID;

    @OneToMany(mappedBy = "testResultID")
    private Set<TestResultUserAnswer> testResultUserAnswers = new LinkedHashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCorrectPercent() {
        return correctPercent;
    }

    public void setCorrectPercent(String correctPercent) {
        this.correctPercent = correctPercent;
    }

    public String getSkippedPercent() {
        return skippedPercent;
    }

    public void setSkippedPercent(String skippedPercent) {
        this.skippedPercent = skippedPercent;
    }

    public Test getTestID() {
        return testID;
    }

    public void setTestID(Test testID) {
        this.testID = testID;
    }

    public User getUserID() {
        return userID;
    }

    public void setUserID(User userID) {
        this.userID = userID;
    }

    public TestResultUserAnswer getTestResultUserAnswerID() {
        return testResultUserAnswerID;
    }

    public void setTestResultUserAnswerID(TestResultUserAnswer testResultUserAnswerID) {
        this.testResultUserAnswerID = testResultUserAnswerID;
    }

    public Set<TestResultUserAnswer> getTestResultUserAnswers() {
        return testResultUserAnswers;
    }

    public void setTestResultUserAnswers(Set<TestResultUserAnswer> testResultUserAnswers) {
        this.testResultUserAnswers = testResultUserAnswers;
    }

}