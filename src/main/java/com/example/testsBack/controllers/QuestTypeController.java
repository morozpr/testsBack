package com.example.testsBack.controllers;

import com.example.testsBack.dtos.QuestTypeDto;
import com.example.testsBack.entities.QuestType;
import com.example.testsBack.exceptions.BadRequest;
import com.example.testsBack.mappers.QuestTypeMapper;
import com.example.testsBack.services.QuestTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/questTypes")
public class QuestTypeController {
    @Autowired
    private QuestTypeService questTypeService;
    @Autowired
    private QuestTypeMapper questTypeMapper;

    @PostMapping("/new")
    public ResponseEntity postObject(@RequestBody QuestTypeDto questType) {
        try {
            return ResponseEntity.ok(questTypeMapper.toDto(questTypeService.addObject(questTypeMapper.toEntity(questType))));
        } catch (BadRequest e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getOneObject(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(questTypeMapper.toDto(questTypeService.getOneObject(id)));
        } catch (BadRequest e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/")
    public ResponseEntity getAllObjects() {
        return ResponseEntity.ok(questTypeService.getAllObjects().stream().map(questTypeMapper::toDto).collect(Collectors.toList()));
    }

    @PutMapping("/{id}")
    public ResponseEntity putObject(@PathVariable Long id, @RequestBody QuestTypeDto questType) {
        try {
            return ResponseEntity.ok(questTypeMapper.toDto(questTypeService.editObject(id, questTypeMapper.toEntity(questType))));
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
