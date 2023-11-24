package com.example.testsBack.services;

import com.example.testsBack.entities.QuestBase;
import com.example.testsBack.exceptions.BadRequest;
import com.example.testsBack.repositories.QuestBaseRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestBaseService {
    private final QuestBaseRepository questBaseRepository;

    QuestBaseService(QuestBaseRepository questBaseRepository) {
        this.questBaseRepository = questBaseRepository;
    }

    public QuestBase addObject(QuestBase questBase) throws BadRequest {
        if (questBase == null) {
            throw new BadRequest("Bad request");
        }
        return questBaseRepository.save(questBase);
    }

    public QuestBase getObject(Long id) throws BadRequest {
        if (questBaseRepository.findById(id) == null) {
            throw new BadRequest("Object not found");
        }

        return questBaseRepository.findById(id).get();
    }

    public List<QuestBase> getAllObjects() {
        List<QuestBase> objectsList = new ArrayList();
        questBaseRepository.findAll().iterator().forEachRemaining(objectsList::add);
        return objectsList;
    }

    public QuestBase editObject(Long id, QuestBase questBase) throws BadRequest {
        if (questBaseRepository.findById(id) == null) {
            throw new BadRequest("Object not found");
        }
        questBase.setId(id);
        return questBaseRepository.save(questBase);
    }

    public void deleteObject(Long id) throws BadRequest {
        if (questBaseRepository.findById(id) == null) {
            throw new BadRequest("Object not found");
        }
        questBaseRepository.deleteById(id);
    }
}
