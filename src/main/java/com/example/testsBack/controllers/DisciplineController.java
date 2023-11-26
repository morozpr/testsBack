package com.example.testsBack.controllers;

import com.example.testsBack.dtos.DisciplineDto;
import com.example.testsBack.entities.Discipline;
import com.example.testsBack.exceptions.BadRequest;
import com.example.testsBack.mappers.DisciplineMapper;
import com.example.testsBack.services.DisciplineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("api/disciplines")
public class DisciplineController {

    @Autowired
    private DisciplineService disciplineService;
    @Autowired
    private DisciplineMapper disciplineMapper;

    @PostMapping("/new")
    public ResponseEntity postObject(@RequestBody Discipline discipline) {
        try {
            return ResponseEntity.ok(disciplineMapper.toDto(disciplineService.addObject(discipline)));
        } catch (BadRequest e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/")
    public ResponseEntity getAllObjects() {
        return ResponseEntity.ok(disciplineService.getAllObjects().stream().map(disciplineMapper::toDto).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity getOneObject(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(disciplineMapper.toDto(disciplineService.getOneObject(id)));
        } catch (BadRequest e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity putObject(@PathVariable Long id, @RequestBody DisciplineDto discipline) {
        try {
            return ResponseEntity.ok(disciplineMapper.toDto(disciplineService.editObject(id, disciplineMapper.toEntity(discipline))));
        } catch (BadRequest e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteObject(@PathVariable Long id) {
        try {
            disciplineService.deleteObject(id);
            return ResponseEntity.ok("Object deleted");
        } catch (BadRequest e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
