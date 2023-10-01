package com.fiap.idwall.most_wanted.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

<<<<<<< HEAD:src/main/java/com/fiap/idwall/most_wanted/controllers/ControllerFBI.java
import com.fiap.idwall.most_wanted.models.WantedFBI;
import com.fiap.idwall.most_wanted.services.WebServices;

@RestController
@RequestMapping("/fbi")
public class ControllerFBI {
=======
import com.fiap.idwall.most_wanted.models.Wanted;
import com.fiap.idwall.most_wanted.services.WebService;

@RestController
@RequestMapping("/fbi")
public class WantedController {
>>>>>>> 85963ef00ccf0e96ebfa20cc00fdfbe21f7a3282:src/main/java/com/fiap/idwall/most_wanted/controllers/WantedController.java

    @Autowired
    WebService services;

    @GetMapping()
    public ResponseEntity<List<WantedFBI>> findTerrorists() throws IOException {
        String complementUrl = "/terrorism";
        List<WantedFBI> wanted = services.WebServiceFbi(complementUrl);
        return ResponseEntity.ok().body(wanted);
    }

}
