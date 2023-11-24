package com.example.testsBack.controllers;

import com.example.testsBack.entities.QuestBase;
import com.example.testsBack.exceptions.BadRequest;
import com.example.testsBack.services.QuestBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/questBases")
public class QuestBaseController {
    @Autowired
    private QuestBaseService questBaseService;

    @PostMapping("/new")
    public ResponseEntity postObject(@RequestBody QuestBase questBase) {
        try {
            return ResponseEntity.ok(questBaseService.addObject(questBase));
        } catch (BadRequest e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getOneObject(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(questBaseService.getObject(id));
        } catch (BadRequest e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @GetMapping("/")
    public ResponseEntity getAllObjects() { return ResponseEntity.ok(questBaseService.getAllObjects()); }

    @PutMapping("/{id}")
    public ResponseEntity putObject(@PathVariable Long id, @RequestBody QuestBase questBase) {
        try {
            return ResponseEntity.ok(questBaseService.editObject(id, questBase));
        } catch (BadRequest e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteObject(@PathVariable Long id) {
        try {
            questBaseService.deleteObject(id);
            return ResponseEntity.ok("Object deleted");
        } catch (BadRequest e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
