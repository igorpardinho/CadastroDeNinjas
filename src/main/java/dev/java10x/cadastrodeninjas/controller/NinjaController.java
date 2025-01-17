package dev.java10x.cadastrodeninjas.controller;


import dev.java10x.cadastrodeninjas.model.NinjaModel;
import dev.java10x.cadastrodeninjas.service.NinjaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping
    public ResponseEntity<List<NinjaModel>> findAll() {

        return ResponseEntity.status(HttpStatus.OK).body(ninjaService.findAll());

    }

}
