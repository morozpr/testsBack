package com.example.testsBack.services;

import com.example.testsBack.entities.Discipline;
import com.example.testsBack.entities.User;
import com.example.testsBack.exceptions.BadRequest;
import com.example.testsBack.repositories.DisciplineRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DisciplineService {
    private final DisciplineRepository disciplineRepository;

    DisciplineService(DisciplineRepository disciplineRepository) {
        this.disciplineRepository = disciplineRepository;
    }

    public Discipline addObject(Discipline discipline) throws BadRequest {
        if (disciplineRepository.existsByDisciplineName(discipline.getDisciplineName()) == true) {
            throw new BadRequest("Object already exist");
        }
        return disciplineRepository.save(discipline);
    }

    public Discipline getOneObject(Long id) throws BadRequest {
        if (disciplineRepository.findById(id) == null) {
            throw new BadRequest("Object not found");
        }
        return disciplineRepository.findById(id).get();
    }

    public List<Discipline> getAllObjects() {
        List<Discipline> objectsList = new ArrayList();
        disciplineRepository.findAll().iterator().forEachRemaining(objectsList::add);
        return objectsList;
    }

    public Discipline editObject(Long id, Discipline discipline) throws BadRequest {
        if (disciplineRepository.findById(id) == null) {
            throw new BadRequest("Object not found");
        }
        discipline.setId(id);
        return disciplineRepository.save(discipline);
    }

    public void deleteObject(Long id) throws BadRequest {
        if (disciplineRepository.findById(id) == null) {
            throw new BadRequest("Object not found");
        }
        disciplineRepository.deleteById(id);
    }
}
