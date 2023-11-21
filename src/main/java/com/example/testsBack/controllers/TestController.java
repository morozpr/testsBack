package com.example.testsBack.controllers;

import com.example.testsBack.entities.Test;
import com.example.testsBack.exceptions.BadRequest;
import com.example.testsBack.services.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private TestService testService;

    @PostMapping("/new")
    public ResponseEntity addObject(@RequestBody Test test) {
        try {
            return ResponseEntity.ok(testService.postObject(test));
        } catch (BadRequest e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/")
    public ResponseEntity getAllObject() {
        return ResponseEntity.ok(testService.getAllObject());
    }

    @GetMapping("/{id}")
    public ResponseEntity getObject(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(testService.getObject(id));
        } catch (BadRequest e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity editObject(@PathVariable Long id, @RequestBody Test test) {
        try {
            return ResponseEntity.ok(testService.editObject(test, id));
        } catch (BadRequest e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteObject(@PathVariable Long id) {
        try {
            testService.deleteObject(id);
            return ResponseEntity.ok("Object deleted");
        } catch (BadRequest e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
