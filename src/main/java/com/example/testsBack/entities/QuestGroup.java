package com.example.testsBack.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "\"questGroup\"")
public class QuestGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"QuestGroupID\"", nullable = false)
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "\"QuestBaseID\"", nullable = false)
    private QuestBase questBaseID;

    @NotNull
    @Column(name = "\"QuestGroupName\"", nullable = false, length = Integer.MAX_VALUE)
    private String questGroupName;

    @OneToMany(mappedBy = "questGroupID")
    private Set<Question> questions = new LinkedHashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public QuestBase getQuestBaseID() {
        return questBaseID;
    }

    public void setQuestBaseID(QuestBase questBaseID) {
        this.questBaseID = questBaseID;
    }

    public String getQuestGroupName() {
        return questGroupName;
    }

    public void setQuestGroupName(String questGroupName) {
        this.questGroupName = questGroupName;
    }

    public Set<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }

}