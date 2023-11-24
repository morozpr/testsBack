package com.example.testsBack.controllers;

import com.example.testsBack.dtos.UserAnswerDto;
import com.example.testsBack.entities.UserAnswer;
import com.example.testsBack.exceptions.BadRequest;
import com.example.testsBack.mappers.UserAnswerMapper;
import com.example.testsBack.services.UserAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/userAnswers")
public class UserAnswerController {

    @Autowired
    private UserAnswerService userAnswerService;

    @Autowired
    private UserAnswerMapper userAnswerMapper;


    @PostMapping("/new")
    public ResponseEntity postObject(@RequestBody UserAnswer userAnswer) {
        try {
            return ResponseEntity.ok(userAnswerMapper.toDto(userAnswerService.postObject(userAnswer)));
        } catch (BadRequest e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/")
    public ResponseEntity getAllObject() {
        return ResponseEntity.ok(userAnswerService.getAllObjects().stream().map(userAnswerMapper::toDto).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity getObject(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(userAnswerMapper.toDto(userAnswerService.getObject(id)));
        } catch (BadRequest e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity putObject(@PathVariable Long id, @RequestBody UserAnswerDto userAnswer) {
        try {
            return ResponseEntity.ok(userAnswerMapper.toDto(userAnswerService.editObject(userAnswerMapper.toEntity(userAnswer), id)));
        } catch (BadRequest e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteObject(@PathVariable Long id) {
        try {
            userAnswerService.deleteObject(id);
            return ResponseEntity.ok("Object deleted");
        } catch (BadRequest e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
