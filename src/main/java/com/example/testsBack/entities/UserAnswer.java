package com.example.testsBack.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "\"UserAnswer\"")
public class UserAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"UserAnswerID\"", nullable = false)
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "\"QuestionID\"", nullable = false)
    private Question questionID;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "\"AnswerID\"", nullable = false)
    private Answer answerID;

    @Column(name = "\"UserAnswer\"", length = Integer.MAX_VALUE)
    private String userAnswer;

    @Column(name = "\"Timestamp\"")
    private Instant timestamp;

    @NotNull
    @Column(name = "\"IsSkipped\"", nullable = false)
    private Boolean isSkipped = false;

    @NotNull
    @Column(name = "\"IsCorrect\"", nullable = false)
    private Boolean isCorrect = false;

    @OneToMany(mappedBy = "userAnswerID")
    private Set<TestResultUserAnswer> testResultUserAnswers = new LinkedHashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Question getQuestionID() {
        return questionID;
    }

    public void setQuestionID(Question questionID) {
        this.questionID = questionID;
    }

    public Answer getAnswerID() {
        return answerID;
    }

    public void setAnswerID(Answer answerID) {
        this.answerID = answerID;
    }

    public String getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(String userAnswer) {
        this.userAnswer = userAnswer;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public Boolean getIsSkipped() {
        return isSkipped;
    }

    public void setIsSkipped(Boolean isSkipped) {
        this.isSkipped = isSkipped;
    }

    public Boolean getIsCorrect() {
        return isCorrect;
    }

    public void setIsCorrect(Boolean isCorrect) {
        this.isCorrect = isCorrect;
    }

    public Set<TestResultUserAnswer> getTestResultUserAnswers() {
        return testResultUserAnswers;
    }

    public void setTestResultUserAnswers(Set<TestResultUserAnswer> testResultUserAnswers) {
        this.testResultUserAnswers = testResultUserAnswers;
    }

}