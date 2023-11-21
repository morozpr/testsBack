package com.example.testsBack.services;

import com.example.testsBack.entities.TestResult;
import com.example.testsBack.exceptions.BadRequest;
import com.example.testsBack.repositories.TestResultRepository;
import org.springframework.stereotype.Service;

@Service
public class TestResultService {
    private final TestResultRepository testResultRepository;

    TestResultService(TestResultRepository testResultRepository) {
        this.testResultRepository = testResultRepository;
    }

    public TestResult addObject(TestResult testResult) throws BadRequest {
        if (testResult == null) {
            throw new BadRequest("Bad request");
        }
        return testResultRepository.save(testResult);
    }

    public TestResult getOneObject(Long id) throws BadRequest {
        if (testResultRepository.findById(id) == null) {
            throw new BadRequest("Object not found");
        }
        return testResultRepository.findById(id).get();
    }

    public Iterable<TestResult> getAllObjects() {
        return testResultRepository.findAll();
    }

    public TestResult editObject(Long id, TestResult testResult) throws BadRequest {
        if (testResultRepository.findById(id) == null) {
            throw new BadRequest("Object not found");
        }
        testResult.setId(id);
        return testResultRepository.save(testResult);
    }

    public void deleteObject(Long id) throws BadRequest {
        if (testResultRepository.findById(id) == null) {
            throw new BadRequest("Object not found");
        }
        testResultRepository.deleteById(id);
    }
}
