package dev.java10x.cadastrodeninjas.controller;


import dev.java10x.cadastrodeninjas.dto.NinjaDTO;
import dev.java10x.cadastrodeninjas.service.NinjaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private final NinjaService ninjaService;


    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping
    public ResponseEntity<Page<NinjaDTO>> findAll(Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(ninjaService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<NinjaDTO> findById(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(ninjaService.findById(id));
    }

    @PostMapping
    public ResponseEntity<NinjaDTO> save(@RequestBody NinjaDTO ninja) {

        return ResponseEntity.status(HttpStatus.CREATED).body(ninjaService.save(ninja));
    }

    @PutMapping("/{id}")
    public ResponseEntity<NinjaDTO> update(@PathVariable("id") Long id, @RequestBody NinjaDTO ninja) {
        return ResponseEntity.status(HttpStatus.OK).body(ninjaService.update(id, ninja));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        ninjaService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
