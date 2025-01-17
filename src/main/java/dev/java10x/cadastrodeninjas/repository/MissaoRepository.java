package dev.java10x.cadastrodeninjas.repository;

import dev.java10x.cadastrodeninjas.model.MissaoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissaoRepository extends JpaRepository<MissaoModel,Long> {
}
