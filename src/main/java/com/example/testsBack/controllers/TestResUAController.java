package com.example.testsBack.controllers;

import com.example.testsBack.dtos.TestResultUserAnswerDto;
import com.example.testsBack.entities.TestResultUserAnswer;
import com.example.testsBack.exceptions.BadRequest;
import com.example.testsBack.mappers.TestResultUserAnswerMapper;
import com.example.testsBack.services.TestResultUserAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/testResultUserAnswer")
public class TestResUAController {
    @Autowired
    private TestResultUserAnswerService testResultUserAnswerService;
    @Autowired
    private TestResultUserAnswerMapper testResultUserAnswerMapper;

    @PostMapping("/new")
    public ResponseEntity postObject(@RequestBody TestResultUserAnswer testResultUserAnswer) {
        try {
            return ResponseEntity.ok(testResultUserAnswerMapper.toDto(testResultUserAnswerService.postObject(testResultUserAnswer)));
        } catch (BadRequest e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/")
    public ResponseEntity getAllObjects() {
        return ResponseEntity.ok(testResultUserAnswerService.getAllObjects().stream().map(testResultUserAnswerMapper::toDto).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity getOneObject(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(testResultUserAnswerMapper.toDto(testResultUserAnswerService.getOneObject(id)));
        } catch (BadRequest e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity editObject(@PathVariable Long id, @RequestBody TestResultUserAnswerDto testResultUserAnswer) {
        try {
            return ResponseEntity.ok(testResultUserAnswerMapper.toDto(testResultUserAnswerService.editObject(id, testResultUserAnswerMapper.toEntity(testResultUserAnswer))));
        } catch (BadRequest e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteObject(@PathVariable Long id) {
        try {
            testResultUserAnswerService.deleteObject(id);
            return ResponseEntity.ok("Object deleted");
        } catch (BadRequest e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


}
