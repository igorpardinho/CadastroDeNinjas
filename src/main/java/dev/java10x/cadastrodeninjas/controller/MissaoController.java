package dev.java10x.cadastrodeninjas.controller;

import dev.java10x.cadastrodeninjas.model.MissaoModel;
import dev.java10x.cadastrodeninjas.service.MissaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/missoes")
public class MissaoController {


    private final MissaoService missaoService;

    public MissaoController(MissaoService missaoService) {
        this.missaoService = missaoService;
    }


    @GetMapping
    public ResponseEntity<List<MissaoModel>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(missaoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MissaoModel> findById(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(missaoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<MissaoModel> save(@RequestBody MissaoModel missaoModel) {
        return ResponseEntity.status(HttpStatus.OK).body(missaoService.save(missaoModel));
    }

    @PutMapping
    public ResponseEntity<MissaoModel> update(@RequestBody MissaoModel missaoModel) {
        return ResponseEntity.status(HttpStatus.OK).body(missaoService.update(missaoModel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        missaoService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
