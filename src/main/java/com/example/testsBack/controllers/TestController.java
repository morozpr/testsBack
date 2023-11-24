package com.example.testsBack.controllers;

import com.example.testsBack.dtos.TestDto;
import com.example.testsBack.entities.Test;
import com.example.testsBack.exceptions.BadRequest;
import com.example.testsBack.mappers.TestMapper;
import com.example.testsBack.services.TestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/test")
public class TestController {

    private final TestService testService;

    private final TestMapper testMapper;

    public TestController(TestService testService, TestMapper testMapper) {
        this.testService = testService;
        this.testMapper = testMapper;
    }

    @PostMapping("/new")
    public ResponseEntity addObject(@RequestBody Test test) {
        try {
            return ResponseEntity.ok(testMapper.toDto(testService.postObject(test)));
        } catch (BadRequest e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/")
    public ResponseEntity getAllObject() {
        return ResponseEntity.ok(testService.getAllObject().stream().map(testMapper::toDto).collect(Collectors.toSet()));
    }

    @GetMapping("/{id}")
    public ResponseEntity getObject(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(testMapper.toDto(testService.getObject(id)));
        } catch (BadRequest e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity editObject(@PathVariable Long id, @RequestBody TestDto test) {
        try {
            return ResponseEntity.ok(testMapper.toDto(testService.editObject(testMapper.toEntity(test), id)));
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
