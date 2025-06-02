package com.senai.monitoraai.repositories;

import com.senai.monitoraai.entities.EquipamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipamentoRepository extends JpaRepository<EquipamentoEntity, Long> {
}
