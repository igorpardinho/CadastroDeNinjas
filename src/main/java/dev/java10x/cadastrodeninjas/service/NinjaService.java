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


    public List<NinjaModel> findAll() {
        return ninjaRepository.findAll();
    }


    public NinjaModel findById(Long id) {
        Optional<NinjaModel> ninja = ninjaRepository.findById(id);

        return ninja.orElse(null);
    }

    public NinjaModel save(NinjaModel ninja) {
        return ninjaRepository.save(ninja);
    }

    public NinjaModel update(Long id, NinjaModel ninja) {
        if (ninjaRepository.existsById(id)) {
            ninja.setId(id);
            return ninjaRepository.save(ninja);
        }
        return null;
    }

    public void delete(Long id) {
        findById(id);
        ninjaRepository.deleteById(id);
    }
}
