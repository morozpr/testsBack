package com.example.testsBack.services;

import com.example.testsBack.entities.QuestGroup;
import com.example.testsBack.exceptions.BadRequest;
import com.example.testsBack.repositories.QuestGroupRepository;
import org.springframework.stereotype.Service;

@Service
public class QuestGroupService {

    private final QuestGroupRepository questGroupRepository;

    public QuestGroupService(QuestGroupRepository questGroupRepository) {
        this.questGroupRepository = questGroupRepository;
    }

    public QuestGroup postObject(QuestGroup questGroup) throws BadRequest {
        if (questGroupRepository.existsByQuestGroupName(questGroup.getQuestGroupName()) == true) {
            throw new BadRequest("Bad Request");
        } return questGroupRepository.save(questGroup);
    }

    public QuestGroup getObject(Long id) throws BadRequest {
        if (questGroupRepository.findById(id) == null) {
            throw new BadRequest("Bad Request");
        } return questGroupRepository.findById(id).get();
    }

    public Iterable<QuestGroup> getAllObjects() {
        return questGroupRepository.findAll();
    }

    public QuestGroup editObject(QuestGroup questGroup, Long id) throws BadRequest {
        if (questGroupRepository.findById(id) == null) {
            throw new BadRequest("Bad Request");
        }
        questGroup.setId(id);
        return questGroupRepository.save(questGroup);
    }

    public void deleteObject(Long id) throws BadRequest {
        if (questGroupRepository.findById(id) == null) {
            throw new BadRequest("Bad Request");
        }
        questGroupRepository.deleteById(id);
    }
}
