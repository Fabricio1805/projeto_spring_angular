package com.helpdesk.backend.domain.entities;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.helpdesk.backend.domain.enums.Perfil;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public abstract class Pessoa {
  protected String id;

  protected String nome;
  protected String cpf;
  protected String email;
  protected String senha;
  protected Set<Integer> perfis = new HashSet<>();
  protected LocalDateTime dataCriacao = LocalDateTime.now();

  public Pessoa() {
    super();
    addPerfis(Perfil.CLIENTE);
  }

  public Pessoa(String id, String nome, String cpf, String email, String senha) {
    super();
    this.id = id;
    this.nome = nome;
    this.cpf = cpf;
    this.email = email;
    this.senha = senha;
    addPerfis(Perfil.CLIENTE);
  }

  public Set<Perfil> getPerfis() {
    return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
  }

  public void addPerfis(Perfil perfil) {
    this.perfis.add(perfil.getCodigo());
  }
}
