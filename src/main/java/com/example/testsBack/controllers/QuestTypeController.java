package com.example.testsBack.controllers;

import com.example.testsBack.entities.QuestType;
import com.example.testsBack.exceptions.BadRequest;
import com.example.testsBack.services.QuestTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/questTypes")
public class QuestTypeController {
    @Autowired
    private QuestTypeService questTypeService;

    @PostMapping("/new")
    public ResponseEntity postObject(@RequestBody QuestType questType) {
        try {
            return ResponseEntity.ok(questTypeService.addObject(questType));
        } catch (BadRequest e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getOneObject(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(questTypeService.getOneObject(id));
        } catch (BadRequest e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/")
    public ResponseEntity getAllObjects() {
        return ResponseEntity.ok(questTypeService.getAllObjects());
    }

    @PutMapping("/{id}")
    public ResponseEntity putObject(@PathVariable Long id, @RequestBody QuestType questType) {
        try {
            return ResponseEntity.ok(questTypeService.editObject(id, questType));
        } catch (BadRequest e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteObject(@PathVariable Long id) {
        try {
            questTypeService.deleteObject(id);
            return ResponseEntity.ok("Object deleted");
        } catch (BadRequest e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
