package dev.java10x.cadastrodeninjas.service;

import dev.java10x.cadastrodeninjas.model.NinjaModel;
import dev.java10x.cadastrodeninjas.repository.NinjaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    private final NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }


    private List<NinjaModel> findAll() {
        return ninjaRepository.findAll();
    }


    private NinjaModel findById(Long id) {
        Optional<NinjaModel> ninja = ninjaRepository.findById(id);

        return ninja.orElse(null);
    }

    private NinjaModel save(NinjaModel ninja) {
        return ninjaRepository.save(ninja);
    }

    private void delete(Long id) {
        findById(id);
        ninjaRepository.deleteById(id);
    }
}
