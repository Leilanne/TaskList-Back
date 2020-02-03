package com.supero.tasklist.models;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

@Entity @Data
@Table(name ="task")
public class Task implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private long id;

    @NotNull
    @Column(name = "task_titulo")
    private String titulo;

    @Column(name = "task_status_concluido")
    private boolean status;

    @Column(name = "task_descricao")
    private String descricao;

    @Column(name = "task_data_criacao")
    private LocalDate dataCriacao;

    @Column(name = "task_data_edicao")
    private LocalDate dataEdicao;

    @Column(name = "task_data_remocao")
    private LocalDate dataRemocao;

    @Column(name = "task_data_conclusao")
    private LocalDate dataConclusao;

    public Task() {
    }

    public Task(String titulo, boolean status, String descricao, LocalDate dataCriacao, LocalDate dataEdicao, LocalDate dataRemocao, LocalDate dataConclusao) {
        this.titulo = titulo;
        this.status = status;
        this.descricao = descricao;
        this.dataCriacao = dataCriacao;
        this.dataEdicao = dataEdicao;
        this.dataRemocao = dataRemocao;
        this.dataConclusao = dataConclusao;
    }
}
