package dev.java10x.cadastrodeninjas.service;

import dev.java10x.cadastrodeninjas.model.MissaoModel;
import dev.java10x.cadastrodeninjas.repository.MissaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissaoService {

    private final MissaoRepository missaoRepository;

    public MissaoService(MissaoRepository missaoRepository) {
        this.missaoRepository = missaoRepository;
    }

    public List<MissaoModel> findAll() {
        return missaoRepository.findAll();
    }

    public MissaoModel findById(Long id) {
        Optional<MissaoModel> missao = missaoRepository.findById(id);
        return missao.orElse(null);
    }

    public MissaoModel update(MissaoModel missao) {
        Optional<MissaoModel> missaoOptional = missaoRepository.findById(missao.getId());

        if (missaoOptional.isEmpty()) {
            return null;
        }
        MissaoModel missaoModel = missaoOptional.get();
        missaoModel.setNome(missao.getNome());
        missaoModel.setDescription(missao.getDescription());
        missaoModel.setDifficult(missao.getDifficult());
        return missaoRepository.save(missaoModel);

    }

    public void delete(Long id) {
        findById(id);
        missaoRepository.deleteById(id);
    }


}
