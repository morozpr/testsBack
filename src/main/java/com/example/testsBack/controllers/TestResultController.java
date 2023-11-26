package com.example.testsBack.controllers;

import com.example.testsBack.dtos.TestResultDto;
import com.example.testsBack.entities.TestResult;
import com.example.testsBack.exceptions.BadRequest;
import com.example.testsBack.mappers.TestResultMapper;
import com.example.testsBack.services.TestResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("api/testResults")
public class TestResultController {
    @Autowired
    private TestResultService testResultService;
    @Autowired
    private TestResultMapper testResultMapper;

    @PostMapping("/new")
    public ResponseEntity postObject(@RequestBody TestResultDto testResult) {
        try {
            return ResponseEntity.ok(testResultMapper.toDto(testResultService.addObject(testResultMapper.toEntity(testResult))));
        } catch (BadRequest e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getOneObject(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(testResultMapper.toDto(testResultService.getOneObject(id)));
        } catch (BadRequest e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/")
    public ResponseEntity getAllObjects() { return ResponseEntity.ok(testResultService.getAllObjects().stream().map(testResultMapper::toDto).collect(Collectors.toList())); }

    @PutMapping("/{id}")
    public ResponseEntity putObject(@PathVariable Long id, @RequestBody TestResultDto testResult) {
        try {
            return ResponseEntity.ok(testResultMapper.toDto(testResultService.editObject(id, testResultMapper.toEntity(testResult))));
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
