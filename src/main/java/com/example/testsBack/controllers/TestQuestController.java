package com.example.testsBack.controllers;

import com.example.testsBack.dtos.TestQuestDto;
import com.example.testsBack.entities.TestQuest;
import com.example.testsBack.exceptions.BadRequest;
import com.example.testsBack.mappers.TestQuestMapper;
import com.example.testsBack.services.TestQuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("api/testQuests")
public class TestQuestController {
    @Autowired
    private TestQuestService testQuestService;
    @Autowired
    private TestQuestMapper testQuestMapper;

    @PostMapping("/new")
    public ResponseEntity postObject(@RequestBody TestQuestDto testQuest) {
        try {
            return ResponseEntity.ok(testQuestMapper.toDto(testQuestService.postObject(testQuestMapper.toEntity(testQuest))));
        } catch (BadRequest e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getOneObject(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(testQuestMapper.toDto(testQuestService.getOneObject(id)));
        } catch (BadRequest e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/")
    public ResponseEntity getAllObjects() { return ResponseEntity.ok(testQuestService.getAllObjects().stream().map(testQuestMapper::toDto).collect(Collectors.toList())); }

    @PutMapping("/{id}")
    public ResponseEntity putObject(@PathVariable Long id, @RequestBody TestQuestDto testQuest) {
        try {
            return ResponseEntity.ok(testQuestMapper.toDto(testQuestService.putObject(id, testQuestMapper.toEntity(testQuest))));
        } catch (BadRequest e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteObject(@PathVariable Long id) {
        try {
            testQuestService.deleteObject(id);
            return ResponseEntity.ok("Object deleted");
        } catch (BadRequest e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
