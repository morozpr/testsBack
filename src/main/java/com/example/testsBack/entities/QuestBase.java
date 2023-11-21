package com.example.testsBack.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "\"QuestBaseService\"")
public class QuestBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"QuestBaseID\"", nullable = false)
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "\"DisciplineID\"", nullable = false)
    private Discipline disciplineID;

    @NotNull
    @Column(name = "\"QuestBaseName\"", nullable = false, length = Integer.MAX_VALUE)
    private String questBaseName;

    @OneToMany(mappedBy = "questBaseID")
    private Set<QuestGroup> questGroups = new LinkedHashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Discipline getDisciplineID() {
        return disciplineID;
    }

    public void setDisciplineID(Discipline disciplineID) {
        this.disciplineID = disciplineID;
    }

    public String getQuestBaseName() {
        return questBaseName;
    }

    public void setQuestBaseName(String questBaseName) {
        this.questBaseName = questBaseName;
    }

    public Set<QuestGroup> getQuestGroups() {
        return questGroups;
    }

    public void setQuestGroups(Set<QuestGroup> questGroups) {
        this.questGroups = questGroups;
    }

}