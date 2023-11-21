package com.example.testsBack.controllers;

import com.example.testsBack.entities.Answer;
import com.example.testsBack.exceptions.BadRequest;
import com.example.testsBack.services.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/answers")
public class AnswerController {
    @Autowired
    private AnswerService answerService;

    public ResponseEntity postObject(@RequestBody Answer answer) {
        try {
            return ResponseEntity.ok(answerService.addObject(answer));
        } catch (BadRequest e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/")
    public ResponseEntity getAllObjects() {
        return ResponseEntity.ok(answerService.getAllObjects());
    }

    @GetMapping("/{id}")
    public ResponseEntity getOneObject(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(answerService.getOneObject(id));
        } catch (BadRequest e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity putObject(@PathVariable Long id, @PathVariable Answer answer) {
        try {
            return  ResponseEntity.ok(answerService.editObject(id, answer));
        } catch (BadRequest e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity deleteObject(@PathVariable Long id) {
        try {
            answerService.deleteObject(id);
            return ResponseEntity.ok("Object deleted");
        } catch (BadRequest e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
