package com.example.testsBack.controllers;

import com.example.testsBack.entities.TestResultUserAnswer;
import com.example.testsBack.exceptions.BadRequest;
import com.example.testsBack.services.TestResultUserAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/testResultUserAnswers")
public class TestResultUserAnswerController {
    @Autowired
    private TestResultUserAnswerService testResultUserAnswerService;

    @PostMapping("/new")
    public ResponseEntity postObject(@RequestBody TestResultUserAnswer testResultUserAnswer) {
        try {
            return ResponseEntity.ok(testResultUserAnswerService.postObject(testResultUserAnswer));
        } catch (BadRequest e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/")
    public ResponseEntity getAllObjects() { return ResponseEntity.ok(testResultUserAnswerService.getAllObjects()); }

    @GetMapping("/{id}")
    public ResponseEntity getOneObject(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(testResultUserAnswerService.getOneObject(id));
        } catch (BadRequest e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity putObject(@PathVariable Long id,@RequestBody TestResultUserAnswer testResultUserAnswer) {
        try {
            return ResponseEntity.ok(testResultUserAnswerService.editObject(id, testResultUserAnswer));
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
