package com.helpdesk.backend.domain.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.helpdesk.backend.domain.enums.Perfil;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@Entity(name = "pessoa")
public abstract class Pessoa implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  protected String id;

  @Column(nullable = false)
  protected String nome;

  @Column(unique = true, nullable = false)
  protected String cpf;

  @Column(unique = true, nullable = false)
  protected String email;

  @Column(nullable = false)
  protected String senha;

  @ElementCollection(fetch = FetchType.EAGER)
  @CollectionTable(name = "perfis")
  protected Set<Integer> perfis = new HashSet<>();

  protected LocalDateTime dataCriacao = LocalDateTime.now();

  public Pessoa() {
    super();
    addPerfil(Perfil.CLIENTE);
  }

  public Pessoa(String id, String nome, String cpf, String email, String senha) {
    super();
    this.id = id;
    this.nome = nome;
    this.cpf = cpf;
    this.email = email;
    this.senha = senha;
    addPerfil(Perfil.CLIENTE);
  }

  public Set<Perfil> getPerfis() {
    return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
  }

  public void addPerfil(Perfil perfil) {
    this.perfis.add(perfil.getCodigo());
  }
}
