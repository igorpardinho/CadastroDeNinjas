package dev.java10x.cadastrodeninjas.mapper;

import dev.java10x.cadastrodeninjas.dto.MissaoDTO;
import dev.java10x.cadastrodeninjas.model.MissaoModel;
import org.springframework.stereotype.Component;

@Component
public class MissaoMapper {

    public MissaoModel map(MissaoDTO missaoDTO) {
        MissaoModel missaoModel = new MissaoModel();
        missaoModel.setId(missaoDTO.getId());
        missaoModel.setName(missaoDTO.getName());
        missaoModel.setDescription(missaoDTO.getDescription());
        missaoModel.setDifficult(missaoDTO.getDifficult());
        missaoModel.setNinjas(missaoDTO.getNinjas());
        return missaoModel;
    }

    public MissaoDTO map(MissaoModel missaoModel) {
        MissaoDTO missaoDTO = new MissaoDTO();
        missaoDTO.setId(missaoModel.getId());
        missaoDTO.setName(missaoModel.getName());
        missaoDTO.setDescription(missaoModel.getDescription());
        missaoDTO.setDifficult(missaoModel.getDifficult());
        missaoDTO.setNinjas(missaoModel.getNinjas());
        return missaoDTO;
    }
}
