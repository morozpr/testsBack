package com.example.testsBack.services;

import com.example.testsBack.entities.University;
import com.example.testsBack.entities.User;
import com.example.testsBack.exceptions.BadRequest;
import com.example.testsBack.repositories.UniversityRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UniversityService {
    private final UniversityRepository universityRepository;

    public UniversityService(UniversityRepository universityRepository) {
        this.universityRepository = universityRepository;
    }

    public University postObject(University university) throws BadRequest {
        if (universityRepository.existsByUniversityName(university.getUniversityName()) == true) {
            throw new BadRequest("Bad Request");
        } return universityRepository.save(university);
    }

    public University getObject(Long id) throws BadRequest {
        if (universityRepository.findById(id) == null) {
            throw new BadRequest("Bad Request");
        }
        return universityRepository.findById(id).get();
    }

    public List<University> getAllObject() {
        List objectsList = new ArrayList();
        universityRepository.findAll().iterator().forEachRemaining(objectsList::add);
        return objectsList;
    }

    public University editObject(University university, Long id) throws BadRequest {
        if (universityRepository.findById(id) == null) {
            throw new BadRequest("Bad Request");
        }
        university.setId(id);
        return universityRepository.save(university);
    }

    public void deleteObject(Long id) throws BadRequest {
        if (universityRepository.findById(id) == null) {
            throw new BadRequest("Bad Request");
        }
        universityRepository.deleteById(id);
    }
}
