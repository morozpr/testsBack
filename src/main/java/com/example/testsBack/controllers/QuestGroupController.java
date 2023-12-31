package com.example.testsBack.controllers;

import com.example.testsBack.dtos.QuestGroupDto;
import com.example.testsBack.entities.QuestGroup;
import com.example.testsBack.exceptions.BadRequest;
import com.example.testsBack.mappers.QuestGroupMapper;
import com.example.testsBack.services.QuestGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/questGroups")
public class QuestGroupController {
    @Autowired
    private QuestGroupService questGroupService;
    @Autowired
    private QuestGroupMapper questGroupMapper;


    @PostMapping("/new")
    public ResponseEntity postObject(@RequestBody QuestGroup questGroup) {
        try {
            return ResponseEntity.ok(questGroupMapper.toDto(questGroupService.postObject(questGroup)));
        } catch (BadRequest e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/")
    public ResponseEntity getAllObjects() {
        return ResponseEntity.ok(questGroupService.getAllObjects());
    }

    @GetMapping("/{id}")
    public  ResponseEntity getObject(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(questGroupMapper.toDto(questGroupService.getObject(id)));
        } catch (BadRequest e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity putObject(@PathVariable Long id, @RequestBody QuestGroupDto questGroup) {
       try {
           return ResponseEntity.ok(questGroupMapper.toDto(questGroupService.editObject(questGroupMapper.toEntity(questGroup), id)));
       } catch (BadRequest e) {
           return ResponseEntity.badRequest().body(e.getMessage());
       }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteObject(@PathVariable Long id) {
        try {
            questGroupService.deleteObject(id);
            return ResponseEntity.ok("Object deleted");
        } catch (BadRequest e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
