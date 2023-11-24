package com.example.testsBack.services;

import com.example.testsBack.entities.QuestType;
import com.example.testsBack.exceptions.BadRequest;
import com.example.testsBack.repositories.QuestTypeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestTypeService {
    private final QuestTypeRepository questTypeRepository;

    QuestTypeService(QuestTypeRepository questTypeRepository) {
        this.questTypeRepository = questTypeRepository;
    }

    public QuestType addObject(QuestType questType) throws BadRequest {
        if (questTypeRepository.existsByQuestTypeName(questType.getQuestTypeName()) == true) {
            throw new BadRequest("Already exist");
        }
        return questTypeRepository.save(questType);
    }

    public QuestType getOneObject(Long id) throws BadRequest {
        if (questTypeRepository.findById(id) == null) {
            throw new BadRequest("Object not found");
        }
        return questTypeRepository.findById(id).get();
    }

    public List<QuestType> getAllObjects() {
        List<QuestType> objectsList = new ArrayList();
        questTypeRepository.findAll().iterator().forEachRemaining(objectsList::add);
        return objectsList;
    }

    public QuestType editObject(Long id, QuestType questType) throws BadRequest {
        if(questTypeRepository.findById(id) == null) {
            throw new BadRequest("Object not found");
        }
        questType.setId(id);
        return questTypeRepository.save(questType);
    }

    public void deleteObject(Long id) throws BadRequest {
        if (questTypeRepository.findById(id) == null) {
            throw new BadRequest("Object not found");
        }
        questTypeRepository.deleteById(id);
    }
}
