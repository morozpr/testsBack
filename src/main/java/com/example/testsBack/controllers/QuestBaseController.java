package com.example.testsBack.controllers;

import com.example.testsBack.dtos.QuestBaseDto;
import com.example.testsBack.entities.QuestBase;
import com.example.testsBack.exceptions.BadRequest;
import com.example.testsBack.mappers.QuestBaseMapper;
import com.example.testsBack.services.QuestBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/questBases")
public class QuestBaseController {
    @Autowired
    private QuestBaseService questBaseService;
    @Autowired
    private QuestBaseMapper questBaseMapper;

    @PostMapping("/new")
    public ResponseEntity postObject(@RequestBody QuestBaseDto questBase) {
        try {
            return ResponseEntity.ok(questBaseMapper.toDto(questBaseService.addObject(questBaseMapper.toEntity(questBase))));
        } catch (BadRequest e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getOneObject(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(questBaseMapper.toDto(questBaseService.getObject(id)));
        } catch (BadRequest e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @GetMapping("/")
    public ResponseEntity getAllObjects() { return ResponseEntity.ok(questBaseService.getAllObjects().stream().map(questBaseMapper::toDto).collect(Collectors.toList())); }

    @PutMapping("/{id}")
    public ResponseEntity putObject(@PathVariable Long id, @RequestBody QuestBaseDto questBase) {
        try {
            return ResponseEntity.ok(questBaseMapper.toDto(questBaseService.editObject(id, questBaseMapper.toEntity(questBase))));
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
