package com.senai.monitoraai.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "emprestimo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmprestimoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "colaborador_id", referencedColumnName = "id")
    private ColaboradorEntity colaborador;

    @ManyToOne
    @JoinColumn(name = "equipamento_id", referencedColumnName = "id")
    private EquipamentoEntity equipamento;

    @Column(name = "data_emprestimo", nullable = false)
    private LocalDate dataEmprestimo;

    @Column(name = "data_devolucao")
    private LocalDate dataDevolucao;

    @Column(name = "observacao")
    private String observacao;

    @Column(name = "devolvido", nullable = false)
    private Boolean devolvido;
}
