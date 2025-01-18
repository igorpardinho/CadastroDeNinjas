package dev.java10x.cadastrodeninjas.service;

import dev.java10x.cadastrodeninjas.dto.MissaoDTO;
import dev.java10x.cadastrodeninjas.mapper.MissaoMapper;
import dev.java10x.cadastrodeninjas.model.MissaoModel;
import dev.java10x.cadastrodeninjas.repository.MissaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissaoService {

    private final MissaoRepository missaoRepository;
    private final MissaoMapper missaoMapper;

    public MissaoService(MissaoRepository missaoRepository, MissaoMapper missaoMapper) {
        this.missaoRepository = missaoRepository;
        this.missaoMapper = missaoMapper;
    }

    public List<MissaoDTO> findAll() {
        return missaoRepository.findAll().stream().map(missaoMapper::map).toList();
    }

    public MissaoDTO findById(Long id) {
        Optional<MissaoModel> missao = missaoRepository.findById(id);
        return missao.map(missaoMapper::map).orElse(null);
    }

    public MissaoDTO save(MissaoDTO missaoDTO) {
        MissaoModel missaoModel = missaoMapper.map(missaoDTO);
        return missaoMapper.map(missaoRepository.save(missaoModel));
    }

    public MissaoModel update(Long id, MissaoModel missao) {
        if (missaoRepository.existsById(id)) {
            missao.setId(id);
            return missaoRepository.save(missao);
        }
        return null;
    }

    public void delete(Long id) {
        findById(id);
        missaoRepository.deleteById(id);
    }


}
