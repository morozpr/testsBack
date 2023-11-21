package com.example.testsBack.controllers;

import com.example.testsBack.entities.UserAnswer;
import com.example.testsBack.exceptions.BadRequest;
import com.example.testsBack.services.UserAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userAnswers")
public class UserAnswerController {

    @Autowired
    private UserAnswerService userAnswerService;


    @PostMapping("/new")
    public ResponseEntity postObject(@RequestBody UserAnswer userAnswer) {
        try {
            return ResponseEntity.ok(userAnswerService.postObject(userAnswer));
        } catch (BadRequest e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/")
    public ResponseEntity getAllObject() {
        return ResponseEntity.ok(userAnswerService.getAllObjects());
    }

    @GetMapping("/{id}")
    public ResponseEntity getObject(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(userAnswerService.getObject(id));
        } catch (BadRequest e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity putObject(@PathVariable Long id, @RequestBody UserAnswer userAnswer) {
        try {
            return ResponseEntity.ok(userAnswerService.editObject(userAnswer, id));
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
