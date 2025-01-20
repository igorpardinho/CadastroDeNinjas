package dev.java10x.cadastrodeninjas.service;

import dev.java10x.cadastrodeninjas.dto.MissaoDTO;
import dev.java10x.cadastrodeninjas.mapper.MissaoMapper;
import dev.java10x.cadastrodeninjas.model.MissaoModel;
import dev.java10x.cadastrodeninjas.repository.MissaoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class MissaoService {

    private final MissaoRepository missaoRepository;
    private final MissaoMapper missaoMapper;

    public MissaoService(MissaoRepository missaoRepository, MissaoMapper missaoMapper) {
        this.missaoRepository = missaoRepository;
        this.missaoMapper = missaoMapper;
    }

    public Page<MissaoDTO> findAll(Pageable pageable) {
        return missaoRepository.findAll(pageable).map(missaoMapper::map);
    }

    public MissaoDTO findById(Long id) {
        Optional<MissaoModel> missao = missaoRepository.findById(id);
        return missao.map(missaoMapper::map).orElse(null);
    }

    public MissaoDTO save(MissaoDTO missaoDTO) {
        MissaoModel missaoModel = missaoMapper.map(missaoDTO);
        return missaoMapper.map(missaoRepository.save(missaoModel));
    }

    public MissaoDTO update(Long id, MissaoDTO missaoDTO) {
        Optional<MissaoModel> missao = missaoRepository.findById(id);
        if (missao.isPresent()) {
            MissaoModel missaoUpdate = missaoMapper.map(missaoDTO);
            missaoUpdate.setId(id);
            return missaoMapper.map(missaoRepository.save(missaoUpdate));
        }
        return null;
    }

    public void delete(Long id) {
        findById(id);
        missaoRepository.deleteById(id);
    }


}
