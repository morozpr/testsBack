package com.example.testsBack.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "\"QuestTypeService\"")
public class QuestType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"QuestTypeID\"", nullable = false)
    private Long id;

    @NotNull
    @Column(name = "\"QuestTypeName\"", nullable = false, length = Integer.MAX_VALUE)
    private String questTypeName;

    @OneToMany(mappedBy = "questTypeID")
    private Set<Question> questions = new LinkedHashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestTypeName() {
        return questTypeName;
    }

    public void setQuestTypeName(String questTypeName) {
        this.questTypeName = questTypeName;
    }

    public Set<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }

}