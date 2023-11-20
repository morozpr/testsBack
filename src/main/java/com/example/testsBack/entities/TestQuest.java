package com.example.testsBack.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "\"TestQuests\"")
public class TestQuest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"TestQuestsID\"", nullable = false)
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "\"QuestionID\"", nullable = false)
    private Question questionID;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "\"TestID\"", nullable = false)
    private Test testID;

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

    public Test getTestID() {
        return testID;
    }

    public void setTestID(Test testID) {
        this.testID = testID;
    }

}