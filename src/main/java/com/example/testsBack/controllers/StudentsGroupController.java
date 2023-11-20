package com.example.testsBack.controllers;

import com.example.testsBack.entities.StudentsGroup;
import com.example.testsBack.exceptions.BadRequest;
import com.example.testsBack.repositories.TestRepository;
import com.example.testsBack.services.StudentsGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sGroup")
public class StudentsGroupController {
    @Autowired
    private StudentsGroupService studentsGroupService;
    @Autowired
    private TestRepository testRepository;

    @PostMapping("/new")
    public ResponseEntity addObject(@RequestBody StudentsGroup studentsGroup) {
        try {
            return ResponseEntity.ok(studentsGroupService.postObject(studentsGroup));

        } catch (BadRequest e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/")
    public ResponseEntity getAllObjects() {
        return ResponseEntity.ok(studentsGroupService.getAllObjects());
    }

    @GetMapping("/{id}")
    public ResponseEntity getOneObject(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(studentsGroupService.getObject(id));
        } catch (BadRequest e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity putObject(@PathVariable Long id, @RequestBody StudentsGroup studentsGroup) {
        try {
            return ResponseEntity.ok(studentsGroupService.editObject(studentsGroup, id));
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
