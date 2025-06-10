package com.senai.monitoraai.repositories;

import com.senai.monitoraai.entities.EmprestimoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmprestimoRepository extends JpaRepository<EmprestimoEntity, Long> {

    boolean existsByEquipamentoIdAndDataDevolucaoIsNull(Long equipamentoId);

    boolean existsByEquipamentoIdAndDataDevolucaoIsNotNull(Long equipamentoId);
}
