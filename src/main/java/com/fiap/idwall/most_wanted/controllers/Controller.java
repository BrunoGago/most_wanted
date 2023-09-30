package com.fiap.idwall.most_wanted.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.idwall.most_wanted.models.Wanted;
import com.fiap.idwall.most_wanted.services.WebServices;

@RestController
@RequestMapping("/fbi")
public class Controller {

    @Autowired
    WebServices services;

    @GetMapping()
    public ResponseEntity<List<Wanted>> findWanted() throws IOException {
        String complementUrl = "/terrorism";
        List<Wanted> wanted = services.WebService(complementUrl);
        return ResponseEntity.ok().body(wanted);
    }

}
