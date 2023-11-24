package com.example.testsBack.services;

import com.example.testsBack.entities.TestQuest;
import com.example.testsBack.exceptions.BadRequest;
import com.example.testsBack.repositories.TestQuestRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TestQuestService {
    private final TestQuestRepository testQuestRepository;

    TestQuestService(TestQuestRepository testQuestRepository) {
        this.testQuestRepository = testQuestRepository;
    }

    public TestQuest postObject(TestQuest testQuest) throws BadRequest {
        if (testQuest == null) {
            throw new BadRequest("Bad request");
        }
        return testQuestRepository.save(testQuest);
    }

    public TestQuest getOneObject(Long id) throws BadRequest {
        if (testQuestRepository.findById(id) == null) {
            throw new BadRequest("Object not found");
        }
        return testQuestRepository.findById(id).get();
    }

    public List<TestQuest> getAllObjects() {
        List<TestQuest> objectsList = new ArrayList();
        testQuestRepository.findAll().iterator().forEachRemaining(objectsList::add);
        return objectsList;
    }

    public TestQuest putObject(Long id, TestQuest testQuest) throws BadRequest {
        if (testQuestRepository.findById(id) == null) {
            throw new BadRequest("Object not found");
        }
        testQuest.setId(id);
        return testQuestRepository.save(testQuest);
    }

    public void deleteObject(Long id) throws BadRequest {
        if (testQuestRepository.findById(id) == null) {
            throw new BadRequest("Object not found");
        }
        testQuestRepository.deleteById(id);
    }
}
