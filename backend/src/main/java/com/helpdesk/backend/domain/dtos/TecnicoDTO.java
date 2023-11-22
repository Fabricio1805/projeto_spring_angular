package com.helpdesk.backend.domain.dtos;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.helpdesk.backend.domain.enums.Perfil;
import com.helpdesk.backend.domain.model.Tecnico;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TecnicoDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  protected String id;
  protected String nome;
  protected String cpf;
  protected String email;
  protected String senha;
  protected Set<Integer> perfis = new HashSet<>();
  protected LocalDateTime dataCriacao = LocalDateTime.now();

  public Set<Perfil> getPerfis() {
    return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
  }

  public void addPerfil(Perfil perfil) {
    this.perfis.add(perfil.getCodigo());
  }

  public TecnicoDTO() {
    super();
    addPerfil(Perfil.CLIENTE);
  }

  public TecnicoDTO(Tecnico tecnico) {
    super();
    this.id = tecnico.getId();
    this.nome = tecnico.getNome();
    this.cpf = tecnico.getCpf();
    this.email = tecnico.getEmail();
    this.senha = tecnico.getSenha();
    this.perfis = tecnico.getPerfis().stream().map(x -> x.getCodigo()).collect(Collectors.toSet());
    this.dataCriacao = tecnico.getDataCriacao();
    addPerfil(Perfil.CLIENTE);
  } 
}
