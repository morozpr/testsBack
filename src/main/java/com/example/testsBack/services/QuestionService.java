package com.example.testsBack.services;


import com.example.testsBack.entities.Question;
import com.example.testsBack.exceptions.BadRequest;
import com.example.testsBack.repositories.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public Question addObject(Question question) throws BadRequest {
        List<Question> check = questionRepository.findByQuestionText(question.getQuestionText());
        if (check != null) {
            throw new BadRequest("Object already exist");
        }
        return questionRepository.save(question);
    }

    public Question getObject(Long id) throws BadRequest {
        if (questionRepository.findById(id) == null) {
            throw new BadRequest("Object not found");
        }
        return questionRepository.findById(id).get();
    }

    public Iterable<Question> getAllObjects() {
        return questionRepository.findAll();
    }

    public Question editObject(Long id, Question question) throws BadRequest {
        if (questionRepository.findById(id) == null) {
            throw new BadRequest("Object not found");
        }
        return questionRepository.save(question);
    }

    public void deleteObject(Long id) throws BadRequest {
        if (questionRepository.findById(id) == null) {
            throw new BadRequest("Object not found");
        }
        questionRepository.deleteById(id);
    }
}
