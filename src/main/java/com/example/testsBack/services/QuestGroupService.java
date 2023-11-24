package com.example.testsBack.services;

import com.example.testsBack.entities.QuestGroup;
import com.example.testsBack.exceptions.BadRequest;
import com.example.testsBack.repositories.QuestGroupRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public List<QuestGroup> getAllObjects() {
        List<QuestGroup> objectsList = new ArrayList();
        questGroupRepository.findAll().iterator().forEachRemaining(objectsList::add);
        return objectsList;
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
