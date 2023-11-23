package com.example.testsBack.services;

import com.example.testsBack.entities.Test;
import com.example.testsBack.entities.User;
import com.example.testsBack.exceptions.BadRequest;
import com.example.testsBack.repositories.TestRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TestService {
    private final TestRepository testRepository;

    public TestService(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    public Test postObject(Test test) throws BadRequest {
        if (testRepository.existsByName(test.getName()) == true) {
            throw new BadRequest("Bad Request");
        } return testRepository.save(test);
    }

    public Test getObject(Long id) throws BadRequest {
        if (testRepository.findById(id) == null) {
            throw new BadRequest("Object not found");
        } return testRepository.findById(id).get();
    }

    public List getAllObject() {
        List<Test> objectsList = new ArrayList();
        testRepository.findAll().iterator().forEachRemaining(objectsList::add);
        return objectsList;
    }

    public Test editObject(Test test, Long id) throws BadRequest {
        if (testRepository.findById(id) == null) {
            throw new BadRequest("Bad Request");
        }
        test.setId(id);
        return  testRepository.save(test);
    }

    public void deleteObject(Long id) throws BadRequest {
        if (testRepository.findById(id) == null) {
            throw new BadRequest("Bad Request");
        }
        testRepository.deleteById(id);
    }
}
