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

    public NinjaModel update(NinjaModel ninja) {
        Optional<NinjaModel> optionalNinjaModel = ninjaRepository.findById(ninja.getId());

        if (optionalNinjaModel.isEmpty()) {
            return null;
        }
        NinjaModel ninjaModel = optionalNinjaModel.get();
        ninjaModel.setName(ninja.getName());
        ninjaModel.setEmail(ninja.getEmail());
        ninjaModel.setIdade(ninja.getIdade());
        return ninjaRepository.save(ninjaModel);
    }

    public void delete(Long id) {
        findById(id);
        ninjaRepository.deleteById(id);
    }
}
