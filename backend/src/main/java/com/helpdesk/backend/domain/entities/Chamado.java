package com.helpdesk.backend.domain.entities;

import java.time.LocalDateTime;

import com.helpdesk.backend.domain.enums.Prioridade;
import com.helpdesk.backend.domain.enums.Status;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Chamado {
  private String id;
  private LocalDateTime dataAbertura = LocalDateTime.now();
  private LocalDateTime dataFechamento;
  private Prioridade prioridade;
  private Status status;
  private String titulo;
  private String observacies;
  private Tecnico tecnico;
  private Cliente cliente;

  public Chamado() {
    super();
  }

  public Chamado(String id, Prioridade prioridade, Status status, String titulo, String observacies, Tecnico tecnico,
      Cliente cliente) {
    this.id = id;
    this.prioridade = prioridade;
    this.status = status;
    this.titulo = titulo;
    this.observacies = observacies;
    this.tecnico = tecnico;
    this.cliente = cliente;
  }

}
