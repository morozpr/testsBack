package com.example.testsBack.controllers;

import com.example.testsBack.entities.TestQuest;
import com.example.testsBack.exceptions.BadRequest;
import com.example.testsBack.services.TestQuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/testQuests")
public class TestQuestController {
    @Autowired
    private TestQuestService testQuestService;

    @PostMapping("/new")
    public ResponseEntity postObject(@RequestBody TestQuest testQuest) {
        try {
            return ResponseEntity.ok(testQuestService.postObject(testQuest));
        } catch (BadRequest e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getOneObject(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(testQuestService.getOneObject(id));
        } catch (BadRequest e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/")
    public ResponseEntity getAllObjects() { return ResponseEntity.ok(testQuestService.getAllObjects()); }

    @PutMapping("/{id}")
    public ResponseEntity putObject(@PathVariable Long id, @RequestBody TestQuest testQuest) {
        try {
            return ResponseEntity.ok(testQuestService.putObject(id, testQuest));
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
