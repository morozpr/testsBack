package com.example.testsBack.controllers;

import com.example.testsBack.dtos.StudentsGroupDto;
import com.example.testsBack.entities.StudentsGroup;
import com.example.testsBack.exceptions.BadRequest;
import com.example.testsBack.mappers.StudentsGroupMapper;
import com.example.testsBack.services.StudentsGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("api/sGroup")
public class StudentsGroupController {
    @Autowired
    private StudentsGroupService studentsGroupService;
    @Autowired
    private StudentsGroupMapper studentsGroupMapper;

    @PostMapping("/new")
    public ResponseEntity addObject(@RequestBody StudentsGroupDto studentsGroup) {
        try {
            return ResponseEntity.ok(studentsGroupMapper.toDto(studentsGroupService.postObject(studentsGroupMapper.toEntity(studentsGroup))));

        } catch (BadRequest e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/")
    public ResponseEntity getAllObjects() {
        return ResponseEntity.ok(studentsGroupService.getAllObjects().stream().map(studentsGroupMapper::toDto).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity getOneObject(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(studentsGroupMapper.toDto(studentsGroupService.getObject(id)));
        } catch (BadRequest e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity putObject(@PathVariable Long id, @RequestBody StudentsGroupDto studentsGroup) {
        try {
            return ResponseEntity.ok(studentsGroupMapper.toDto(studentsGroupService.editObject(studentsGroupMapper.toEntity(studentsGroup), id)));
        } catch (BadRequest e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity deleteObject(@PathVariable Long id) {
        try {
            studentsGroupService.deleteObject(id);
            return ResponseEntity.ok("Object deleted");
        } catch (BadRequest e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
