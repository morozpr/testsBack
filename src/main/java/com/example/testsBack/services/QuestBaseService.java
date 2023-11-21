package com.example.testsBack.services;

import com.example.testsBack.entities.QuestBase;
import com.example.testsBack.exceptions.BadRequest;
import com.example.testsBack.repositories.QuestBaseRepository;
import org.springframework.stereotype.Service;

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

    public Iterable<QuestBase> getAllObjects() {
        return questBaseRepository.findAll();
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
