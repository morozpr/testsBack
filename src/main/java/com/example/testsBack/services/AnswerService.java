package com.example.testsBack.services;


import com.example.testsBack.entities.Answer;
import com.example.testsBack.exceptions.BadRequest;
import com.example.testsBack.repositories.AnswerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerService {

    private final AnswerRepository answerRepository;

    AnswerService(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    public Answer addObject(Answer answer) throws BadRequest {
        if (answer == null) {
            throw new BadRequest("Bad Request");
        }
        return answerRepository.save(answer);
    }

    public Answer getObject(Long id) throws BadRequest {
        if (answerRepository.findById(id) == null) {
            throw new BadRequest("Object not found");
        }
        return answerRepository.findById(id).get();
    }

    public Iterable<Answer> getAllObjects() {
        return answerRepository.findAll();
    }

    public Answer editObject(Long id, Answer answer) throws BadRequest {
        if (answerRepository.findById(id) == null) {
            throw new BadRequest("Object not found");
        }
        answer.setId(id);
        return answerRepository.save(answer);
    }

    public void deleteObject(Long id) throws BadRequest {
        if (answerRepository.findById(id) == null) {
            throw new BadRequest("Object not found");
        }
        answerRepository.deleteById(id);
    }
}
