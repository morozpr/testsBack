package com.example.testsBack.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "\"Question\"")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"QuestionID\"", nullable = false)
    private Long id;

    @NotNull
    @Column(name = "\"QuestionText\"", nullable = false, length = Integer.MAX_VALUE)
    private String questionText;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "\"QuestGroupID\"", nullable = false)
    private QuestGroup questGroupID;

    @Column(name = "\"CorrectComment\"", length = Integer.MAX_VALUE)
    private String correctComment;

    @Column(name = "\"IncorrectComment\"", length = Integer.MAX_VALUE)
    private String incorrectComment;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "\"QuestTypeID\"", nullable = false)
    private QuestType questTypeID;

    @NotNull
    @Column(name = "\"Score\"", nullable = false)
    private Float score;

    @NotNull
    @Column(name = "\"IsShuffleAnswers\"", nullable = false)
    private Boolean isShuffleAnswers = false;

    @NotNull
    @Column(name = "\"IsCount\"", nullable = false)
    private Boolean isCount = false;

    @OneToMany(mappedBy = "questionID")
    private Set<Answer> answers = new LinkedHashSet<>();

    @OneToMany(mappedBy = "questionID")
    private Set<TestQuest> testQuests = new LinkedHashSet<>();

    @OneToMany(mappedBy = "questionID")
    private Set<UserAnswer> userAnswers = new LinkedHashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public QuestGroup getQuestGroupID() {
        return questGroupID;
    }

    public void setQuestGroupID(QuestGroup questGroupID) {
        this.questGroupID = questGroupID;
    }

    public String getCorrectComment() {
        return correctComment;
    }

    public void setCorrectComment(String correctComment) {
        this.correctComment = correctComment;
    }

    public String getIncorrectComment() {
        return incorrectComment;
    }

    public void setIncorrectComment(String incorrectComment) {
        this.incorrectComment = incorrectComment;
    }

    public QuestType getQuestTypeID() {
        return questTypeID;
    }

    public void setQuestTypeID(QuestType questTypeID) {
        this.questTypeID = questTypeID;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    public Boolean getIsShuffleAnswers() {
        return isShuffleAnswers;
    }

    public void setIsShuffleAnswers(Boolean isShuffleAnswers) {
        this.isShuffleAnswers = isShuffleAnswers;
    }

    public Boolean getIsCount() {
        return isCount;
    }

    public void setIsCount(Boolean isCount) {
        this.isCount = isCount;
    }

    public Set<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(Set<Answer> answers) {
        this.answers = answers;
    }

    public Set<TestQuest> getTestQuests() {
        return testQuests;
    }

    public void setTestQuests(Set<TestQuest> testQuests) {
        this.testQuests = testQuests;
    }

    public Set<UserAnswer> getUserAnswers() {
        return userAnswers;
    }

    public void setUserAnswers(Set<UserAnswer> userAnswers) {
        this.userAnswers = userAnswers;
    }

}