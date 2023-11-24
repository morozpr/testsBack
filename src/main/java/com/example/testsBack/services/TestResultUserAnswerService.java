package com.example.testsBack.services;

import com.example.testsBack.entities.TestResult;
import com.example.testsBack.entities.TestResultUserAnswer;
import com.example.testsBack.exceptions.BadRequest;
import com.example.testsBack.repositories.TestResultUserAnswerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TestResultUserAnswerService {
    private final TestResultUserAnswerRepository testResultUserAnswerRepository;

    TestResultUserAnswerService(TestResultUserAnswerRepository testResultUserAnswerRepository) {
        this.testResultUserAnswerRepository = testResultUserAnswerRepository;
    }

    public TestResultUserAnswer postObject(TestResultUserAnswer testResultUserAnswer) throws BadRequest {
        if (testResultUserAnswer == null) {
            throw new BadRequest("Bad request body");
        }
        return testResultUserAnswerRepository.save(testResultUserAnswer);
    }

    public TestResultUserAnswer getOneObject(Long id) throws BadRequest {
        if (testResultUserAnswerRepository.findById(id) == null) {
            throw new BadRequest("Object not found");
        }
        return testResultUserAnswerRepository.findById(id).get();
    }

    public List<TestResultUserAnswer> getAllObjects() {
        List<TestResultUserAnswer> objectsList = new ArrayList();
        testResultUserAnswerRepository.findAll().iterator().forEachRemaining(objectsList::add);
        return objectsList;
    }

    public TestResultUserAnswer editObject(Long id, TestResultUserAnswer testResultUserAnswer) throws BadRequest {
        if (testResultUserAnswerRepository.findById(id) == null) {
            throw new BadRequest("Object not found");
        }
        testResultUserAnswer.setId(id);
        return testResultUserAnswerRepository.save(testResultUserAnswer);
    }

    public void deleteObject(Long id) throws BadRequest {
        if (testResultUserAnswerRepository.findById(id) == null) {
            throw new BadRequest("Object not found");
        }
        testResultUserAnswerRepository.deleteById(id);
    }
}
