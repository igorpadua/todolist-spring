package com.zgacelera.todolistspring.model.entity

import groovy.transform.Canonical
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
@Canonical
class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id
    String nome
    String descricao
    @Column(name = "data_termino")
    Date dataTermino
    Short prioridade
    String categoria
    String status
}
