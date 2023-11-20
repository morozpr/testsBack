package com.example.testsBack.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "\"Test\"")
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"TestID\"", nullable = false)
    private Long id;

    @NotNull
    @Column(name = "\"Name\"", nullable = false, length = Integer.MAX_VALUE)
    private String name;

    @Column(name = "\"Description\"", length = Integer.MAX_VALUE)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "\"DisciplineID\"")
    private Discipline disciplineID;

    @Column(name = "\"Link\"", length = Integer.MAX_VALUE)
    private String link;

    @NotNull
    @Column(name = "\"IsShuffleQuestions\"", nullable = false)
    private Boolean isShuffleQuestions = false;

    @OneToMany(mappedBy = "testID")
    private Set<TestQuest> testQuests = new LinkedHashSet<>();

    @OneToMany(mappedBy = "testID")
    private Set<TestResult> testResults = new LinkedHashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Discipline getDisciplineID() {
        return disciplineID;
    }

    public void setDisciplineID(Discipline disciplineID) {
        this.disciplineID = disciplineID;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Boolean getIsShuffleQuestions() {
        return isShuffleQuestions;
    }

    public void setIsShuffleQuestions(Boolean isShuffleQuestions) {
        this.isShuffleQuestions = isShuffleQuestions;
    }

    public Set<TestQuest> getTestQuests() {
        return testQuests;
    }

    public void setTestQuests(Set<TestQuest> testQuests) {
        this.testQuests = testQuests;
    }

    public Set<TestResult> getTestResults() {
        return testResults;
    }

    public void setTestResults(Set<TestResult> testResults) {
        this.testResults = testResults;
    }

}