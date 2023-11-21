package com.example.testsBack.services;

import com.example.testsBack.entities.TestResultUserAnswer;
import com.example.testsBack.exceptions.BadRequest;
import com.example.testsBack.repositories.TestResultUserAnswerRepository;
import org.springframework.stereotype.Service;

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

    public Iterable<TestResultUserAnswer> getAllObjects() {
        return testResultUserAnswerRepository.findAll();
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
