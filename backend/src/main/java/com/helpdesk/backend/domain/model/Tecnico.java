package com.helpdesk.backend.domain.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.helpdesk.backend.domain.dtos.TecnicoDTO;
import com.helpdesk.backend.domain.enums.Perfil;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "tecnico")
public class Tecnico extends Pessoa {
  private static final long serialVersionUID = 1L;

  @JsonIgnore
  @OneToMany(mappedBy = "tecnico")
  private List<Chamado> chamados = new ArrayList<Chamado>();

  public Tecnico() {
    super();
    addPerfil(Perfil.CLIENTE);
  }

  public Tecnico(String id, String nome, String cpf, String email, String senha) {
    super(id, nome, cpf, email, senha);
    addPerfil(Perfil.CLIENTE);
  }

  public Tecnico(TecnicoDTO tecnico) {
    super();
    this.id = tecnico.getId();
    this.nome = tecnico.getNome();
    this.cpf = tecnico.getCpf();
    this.email = tecnico.getEmail();
    this.senha = tecnico.getSenha();
    this.perfis = tecnico.getPerfis().stream().map(x -> x.getCodigo()).collect(Collectors.toSet());
    this.dataCriacao = tecnico.getDataCriacao();
  } 
}
