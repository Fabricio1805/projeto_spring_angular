package com.helpdesk.backend.domain.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.helpdesk.backend.domain.enums.Prioridade;
import com.helpdesk.backend.domain.enums.Status;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "chamado")
public class Chamado implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;

  private LocalDateTime dataAbertura = LocalDateTime.now();

  private LocalDateTime dataFechamento;

  private Prioridade prioridade;

  private Status status;

  private String titulo;

  private String observacies;

  @ManyToOne
  @JoinColumn(name = "tecnico_id")
  private Tecnico tecnico;

  @ManyToOne
  @JoinColumn(name = "cliente_id")
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
