package com.fiap.idwall.most_wanted.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.idwall.most_wanted.models.WantedInterpol;
import com.fiap.idwall.most_wanted.services.WebServiceInterpol;

@RestController
@RequestMapping("/interpol")
public class ControllerInterpol {

    @Autowired
    WebServiceInterpol services;

    @PostMapping
    public ResponseEntity<WantedInterpol> includePerson() throws IOException, InterruptedException {
        services.InsertPersonOnBase();
        return ResponseEntity.ok().body(null);
    }

    @GetMapping()
    public ResponseEntity<List<WantedInterpol>> findAll() throws IOException, InterruptedException {
        List<WantedInterpol> wanted = services.getAll();
        return ResponseEntity.ok().body(wanted);
    }

}
