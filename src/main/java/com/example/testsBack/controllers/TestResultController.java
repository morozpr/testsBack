package com.example.testsBack.controllers;

import com.example.testsBack.entities.TestResult;
import com.example.testsBack.exceptions.BadRequest;
import com.example.testsBack.services.TestResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/testResults")
public class TestResultController {
    @Autowired
    private TestResultService testResultService;

    @PostMapping("/new")
    public ResponseEntity postObject(@RequestBody TestResult testResult) {
        try {
            return ResponseEntity.ok(testResultService.addObject(testResult));
        } catch (BadRequest e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getOneObject(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(testResultService.getOneObject(id));
        } catch (BadRequest e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/")
    public ResponseEntity getAllObjects() { return ResponseEntity.ok(testResultService.getAllObjects()); }

    @PutMapping("/{id}")
    public ResponseEntity putObject(@PathVariable Long id, @RequestBody TestResult testResult) {
        try {
            return ResponseEntity.ok(testResultService.editObject(id, testResult));
        } catch (BadRequest e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteObject(@PathVariable Long id) {
        try {
            testResultService.deleteObject(id);
            return ResponseEntity.ok("Object deleted");
        } catch (BadRequest e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
