package com.example.testsBack.services;

import com.example.testsBack.entities.UserAnswer;
import com.example.testsBack.exceptions.BadRequest;
import com.example.testsBack.repositories.UniversityRepository;
import com.example.testsBack.repositories.UserAnswerRepository;
import org.springframework.stereotype.Service;

@Service
public class UserAnswerService {

    private final UserAnswerRepository userAnswerRepository;

    public UserAnswerService(UserAnswerRepository userAnswerRepository) {
        this.userAnswerRepository = userAnswerRepository;
    }

    public UserAnswer postObject(UserAnswer userAnswer) throws BadRequest {
        if (userAnswer == null) {
            throw new BadRequest("Bad Request");
        }
        return userAnswerRepository.save(userAnswer);
    }

    public UserAnswer getObject(Long id) throws BadRequest {
        if (userAnswerRepository.findById(id) == null) {
            throw new BadRequest("Bad Request");
        }
        return userAnswerRepository.findById(id).get();
    }

    public Iterable<UserAnswer> getAllObjects() {
        return userAnswerRepository.findAll();
    }

    public UserAnswer editObject(UserAnswer userAnswer, Long id) throws BadRequest {
        if (userAnswerRepository.findById(id) == null) {
            throw new BadRequest("Bad Request");
        }
        userAnswer.setId(id);
        return userAnswerRepository.save(userAnswer);
    }

    public void deleteObject(Long id) throws BadRequest {
        if (userAnswerRepository.findById(id) == null) {
            throw new BadRequest("Bad Request");
        }
        userAnswerRepository.deleteById(id);
    }
}
