package com.example.testsBack.controllers;

import com.example.testsBack.dtos.QuestionDto;
import com.example.testsBack.entities.Question;
import com.example.testsBack.exceptions.BadRequest;
import com.example.testsBack.mappers.QuestionMapper;
import com.example.testsBack.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("api/questions")
public class QuestionController {
    @Autowired
    private QuestionService questionService;
    @Autowired
    private QuestionMapper questionMapper;

    @PostMapping("/new")
    public ResponseEntity postObject(@RequestBody QuestionDto question) {
        try {
            return ResponseEntity.ok(questionMapper.toDto(questionService.addObject(questionMapper.toEntity(question))));
        } catch (BadRequest e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getOneObject(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(questionMapper.toDto(questionService.getObject(id)));
        } catch (BadRequest e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/")
    public ResponseEntity getAllObjects() { return ResponseEntity.ok(questionService.getAllObjects().stream().map(questionMapper::toDto).collect(Collectors.toList())); }

    @PutMapping("/{id}")
    public ResponseEntity putObject(@PathVariable Long id, @RequestBody QuestionDto question) {
        try {
            return ResponseEntity.ok(questionMapper.toDto(questionService.editObject(id, questionMapper.toEntity(question))));
        } catch (BadRequest e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteObject(@PathVariable Long id) {
        try {
            questionService.deleteObject(id);
            return ResponseEntity.ok("Object deleted");
        } catch (BadRequest e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
