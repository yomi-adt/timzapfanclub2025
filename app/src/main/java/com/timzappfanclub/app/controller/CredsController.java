package com.timzappfanclub.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.timzappfanclub.app.backend.PasswordManager;
import com.timzappfanclub.app.dto.CredsDto;
import com.timzappfanclub.app.service.CredsService;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/pass")
public class CredsController {


    private CredsService service;

    // POST login
    // @PostMapping("/login/{master}")
    // public ResponseEntity<> login(){
    //     return null;
    // }

    // POST pass
    @PostMapping
    public ResponseEntity<CredsDto> addPass(@RequestBody CredsDto c){
        PasswordManager hashing = new PasswordManager(c.getHashed_pass());
        CredsDto hashed = c;
        hashed.setHashed_pass(hashing.getHashed_pass());
        hashed.setSalt(hashing.getSalt().toString());

        CredsDto saved = service.createCreds(c);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    // Get all
    @GetMapping
    public ResponseEntity<List<CredsDto>> getAllCreds(){
        List<CredsDto> creds = service.getAllCreds();
        return ResponseEntity.ok(creds);
    }


}
