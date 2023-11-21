package com.example.testsBack.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "\"discipline\"")
public class Discipline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"DisciplineID\"", nullable = false)
    private Long id;

    @NotNull
    @Column(name = "\"DisciplineName\"", nullable = false, length = Integer.MAX_VALUE)
    private String disciplineName;

    @OneToMany(mappedBy = "disciplineID")
    private Set<QuestBase> questBases = new LinkedHashSet<>();

    @OneToMany(mappedBy = "disciplineID")
    private Set<Test> tests = new LinkedHashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDisciplineName() {
        return disciplineName;
    }

    public void setDisciplineName(String disciplineName) {
        this.disciplineName = disciplineName;
    }

    public Set<QuestBase> getQuestBases() {
        return questBases;
    }

    public void setQuestBases(Set<QuestBase> questBases) {
        this.questBases = questBases;
    }

    public Set<Test> getTests() {
        return tests;
    }

    public void setTests(Set<Test> tests) {
        this.tests = tests;
    }

}