package com.example.testsBack.controllers;

import com.example.testsBack.dtos.AnswerDto;
import com.example.testsBack.entities.Answer;
import com.example.testsBack.exceptions.BadRequest;
import com.example.testsBack.mappers.AnswerMapper;
import com.example.testsBack.services.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("api/answers")
public class AnswerController {
    @Autowired
    private AnswerService answerService;
    @Autowired
    private AnswerMapper answerMapper;


    @PostMapping("/new")
    public ResponseEntity postObject(@RequestBody Answer answer) {
        try {
            return ResponseEntity.ok(answerMapper.toDto(answerService.addObject(answer)));
        } catch (BadRequest e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/")
    public ResponseEntity getAllObjects() {
        return ResponseEntity.ok(answerService.getAllObjects().stream().map(answerMapper::toDto).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity getOneObject(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(answerMapper.toDto(answerService.getOneObject(id)));
        } catch (BadRequest e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity putObject(@PathVariable Long id, @RequestBody AnswerDto answer) {
        try {
            return  ResponseEntity.ok(answerMapper.toDto(answerService.editObject(id, answerMapper.toEntity(answer))));
        } catch (BadRequest e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteObject(@PathVariable Long id) {
        try {
            answerService.deleteObject(id);
            return ResponseEntity.ok("Object deleted");
        } catch (BadRequest e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
