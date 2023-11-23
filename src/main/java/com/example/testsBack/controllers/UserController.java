package com.example.testsBack.controllers;

import com.example.testsBack.dtos.UserDto;
import com.example.testsBack.entities.User;
import com.example.testsBack.exceptions.BadRequest;
import com.example.testsBack.mappers.UserMapper;
import com.example.testsBack.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @PostMapping("/new")
    public ResponseEntity putObject(@RequestBody UserDto userDto) {
        try {
            User user = userMapper.toEntity(userDto);
            return ResponseEntity.ok(userService.addObject(user));
        } catch (BadRequest e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/")
    public ResponseEntity getAllObjects() {

        return ResponseEntity.ok(userService.getAllObjects().stream().map(userMapper::toDto).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity getOneObject(@PathVariable Long id) {
        try {
            User user = userService.getObject(id);

            return ResponseEntity.ok(userMapper.toDto(user));
        } catch (BadRequest e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity putObject(@PathVariable Long id, @RequestBody UserDto userDto) {
        try {
            User user = userMapper.toEntity(userDto);
            return ResponseEntity.ok(userService.editObject(user, id));
        } catch (BadRequest e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteObject(@PathVariable Long id) {
        try {
            userService.deleteObject(id);
            return ResponseEntity.ok("Object deleted");
        } catch (BadRequest e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
