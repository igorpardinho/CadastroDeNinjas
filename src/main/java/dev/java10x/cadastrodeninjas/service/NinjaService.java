package dev.java10x.cadastrodeninjas.service;

import dev.java10x.cadastrodeninjas.dto.NinjaDTO;
import dev.java10x.cadastrodeninjas.mapper.NinjaMapper;
import dev.java10x.cadastrodeninjas.model.NinjaModel;
import dev.java10x.cadastrodeninjas.repository.NinjaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    private final NinjaRepository ninjaRepository;
    private final NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }


    public List<NinjaDTO> findAll() {
       return ninjaRepository.findAll().stream().map(ninjaMapper::map).toList();

    }


    public NinjaDTO findById(Long id) {
        Optional<NinjaModel> ninja = ninjaRepository.findById(id);

        return ninja.map(ninjaMapper::map).orElse(null);

    }

    public NinjaDTO save(NinjaDTO ninjaDTO) {
        NinjaModel ninja = ninjaMapper.map(ninjaDTO);
        return ninjaMapper.map(ninjaRepository.save(ninja));
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
