package com.fiap.idwall.most_wanted.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.idwall.most_wanted.models.WantedFBI;
import com.fiap.idwall.most_wanted.services.WebService;

@RestController
@RequestMapping("/fbi")
public class ControllerFBI {

    @Autowired
    WebService services;

    @PostMapping()
    public ResponseEntity<WantedFBI> includePerson() throws IOException, InterruptedException {
        List<String> list = new ArrayList<>();
        list.add("/fugitives");
        list.add("/terrorism");
        list.add("/seeking-information");
        list.add("/law-enforcement-assistance");
        list.add("/indian-country");
        list.add("/ecap");
        list.add("/vicap");
        list.add("/vicap/homicides-and-sexual-assaults");
        list.add("/vicap/missing-persons");
        list.add("/vicap/unidentified-persons");
        list.add("/bank-robbers");

        services.InsertPersonOnBase(list);

        return ResponseEntity.ok().body(null);
    }

    @GetMapping()
    public ResponseEntity<List<WantedFBI>> findTerrorists() throws IOException, InterruptedException {
        String complementUrl = "/fugitives";
        List<WantedFBI> wanted = services.WebServiceFbi(complementUrl);
        return ResponseEntity.ok().body(wanted);
    }

}
