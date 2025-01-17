package dev.java10x.cadastrodeninjas.repository;

import dev.java10x.cadastrodeninjas.model.NinjaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NinjaRepository extends JpaRepository<NinjaModel,Long> {
}
