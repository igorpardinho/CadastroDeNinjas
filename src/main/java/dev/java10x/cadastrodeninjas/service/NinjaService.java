package dev.java10x.cadastrodeninjas.service;

import dev.java10x.cadastrodeninjas.dto.NinjaDTO;
import dev.java10x.cadastrodeninjas.mapper.NinjaMapper;
import dev.java10x.cadastrodeninjas.model.NinjaModel;
import dev.java10x.cadastrodeninjas.repository.NinjaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class NinjaService {

    private final NinjaRepository ninjaRepository;
    private final NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }


    public Page<NinjaDTO> findAll(Pageable pageable) {
        return ninjaRepository.findAll(pageable).map(ninjaMapper::map);

    }


    public NinjaDTO findById(Long id) {
        Optional<NinjaModel> ninja = ninjaRepository.findById(id);

        return ninja.map(ninjaMapper::map).orElse(null);

    }

    public NinjaDTO save(NinjaDTO ninjaDTO) {
        NinjaModel ninja = ninjaMapper.map(ninjaDTO);
        return ninjaMapper.map(ninjaRepository.save(ninja));
    }

    public NinjaDTO update(Long id, NinjaDTO ninjaDTO) {
        Optional<NinjaModel> ninjaModel = ninjaRepository.findById(id);
        if (ninjaModel.isPresent()) {
            NinjaModel ninjaUpdate = ninjaMapper.map(ninjaDTO);
            ninjaUpdate.setId(id);
            return ninjaMapper.map(ninjaRepository.save(ninjaUpdate));
        }
        return null;
    }

    public void delete(Long id) {
        findById(id);
        ninjaRepository.deleteById(id);
    }
}
