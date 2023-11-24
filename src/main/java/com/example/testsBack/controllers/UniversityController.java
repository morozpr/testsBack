package com.example.testsBack.controllers;

import com.example.testsBack.dtos.UniversityDto;
import com.example.testsBack.entities.TestResultUserAnswer;
import com.example.testsBack.entities.University;
import com.example.testsBack.exceptions.BadRequest;
import com.example.testsBack.mappers.UniversityMapper;
import com.example.testsBack.services.TestResultUserAnswerService;
import com.example.testsBack.services.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/universities")
public class UniversityController {
    @Autowired
    private UniversityService universityService;
    @Autowired
    private UniversityMapper universityMapper;

    @PostMapping("/new")
    public ResponseEntity postObject(@RequestBody University university) {
        try {
            return ResponseEntity.ok(universityMapper.toDto(universityService.postObject(university)));
        } catch (BadRequest e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/")
    public ResponseEntity getAllObjects() { return ResponseEntity.ok(universityService.getAllObject().stream().map(universityMapper::toDto).collect(Collectors.toList())); }

    @GetMapping("/{id}")
    public ResponseEntity getOneObject(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(universityMapper.toDto(universityService.getObject(id)));
        } catch (BadRequest e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity putObject(@PathVariable Long id,@RequestBody UniversityDto university) {
        try {
            return ResponseEntity.ok(universityMapper.toDto(universityService.editObject(universityMapper.toEntity(university), id)));
        } catch (BadRequest e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteObject(@PathVariable Long id) {
        try {
            universityService.deleteObject(id);
            return ResponseEntity.ok("Object deleted");
        } catch (BadRequest e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
