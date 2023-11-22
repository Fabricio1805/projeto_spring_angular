package com.helpdesk.backend.domain.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.helpdesk.backend.domain.dtos.ClienteDTO;
import com.helpdesk.backend.domain.dtos.TecnicoDTO;
import com.helpdesk.backend.domain.enums.Perfil;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "cliente")
public class Cliente extends Pessoa {

  private static final long serialVersionUID = 1L;

  @JsonIgnore
  @OneToMany(mappedBy = "cliente")
  private List<Chamado> chamados = new ArrayList<Chamado>();

  public Cliente() {
    super();
    addPerfil(Perfil.CLIENTE);

  }

  public Cliente(String id, String nome, String cpf, String email, String senha) {
    super(id, nome, cpf, email, senha);
    addPerfil(Perfil.CLIENTE);
  }

  public Cliente(ClienteDTO cliente) {
    super();
    this.id = cliente.getId();
    this.nome = cliente.getNome();
    this.cpf = cliente.getCpf();
    this.email = cliente.getEmail();
    this.senha = cliente.getSenha();
    this.perfis = cliente.getPerfis().stream().map(x -> x.getCodigo()).collect(Collectors.toSet());
    this.dataCriacao = cliente.getDataCriacao();
  } 
}
