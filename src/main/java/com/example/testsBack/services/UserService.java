package com.example.testsBack.services;

import com.example.testsBack.entities.User;
import com.example.testsBack.exceptions.BadRequest;
import com.example.testsBack.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User addObject(User user) throws BadRequest {
        List<User> check = userRepository.findByEmail(user.getEmail());
        if (check != null) {
            throw new BadRequest("Object already exist");
        }
        return userRepository.save(user);
    }

    public User getObject(Long id) throws BadRequest {
        if (userRepository.findById(id) == null) {
            throw new BadRequest("Object not found");
        }
        return userRepository.findById(id).get();
    }

    public Iterable<User> getAllObjects() { return userRepository.findAll(); }

    public User editObject(User user, Long id) throws BadRequest {
        if (userRepository.findById(id) == null) {
            throw new BadRequest("Object not found");
        }
        return userRepository.save(user);
    }

    public void deleteObject(Long id) throws BadRequest {
        if (userRepository.findById(id) == null) {
            throw new BadRequest("Object not found");
        }
        userRepository.deleteById(id);
    }
}
