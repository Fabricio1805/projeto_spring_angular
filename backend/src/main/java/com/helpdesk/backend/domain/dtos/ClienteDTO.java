package com.helpdesk.backend.domain.dtos;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.helpdesk.backend.domain.enums.Perfil;
import com.helpdesk.backend.domain.model.Cliente;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  protected String id;
  
  @NotNull(message = "o campo NOME é requerido")
  protected String nome;
  
  @NotNull(message = "o campo CPF é requerido")
  protected String cpf;
  
  @NotNull(message = "o campo E-MAIL é requerido")
  protected String email;
  
  @NotNull(message = "o campo SENHA é requerido")
  protected String senha;
  protected Set<Integer> perfis = new HashSet<>();
  protected LocalDateTime dataCriacao = LocalDateTime.now();

  public Set<Perfil> getPerfis() {
    return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
  }

  public void addPerfil(Perfil perfil) {
    this.perfis.add(perfil.getCodigo());
  }

  public ClienteDTO() {
    super();
    addPerfil(Perfil.CLIENTE);
  }

  public ClienteDTO(Cliente cliente) {
    super();
    this.id = cliente.getId();
    this.nome = cliente.getNome();
    this.cpf = cliente.getCpf();
    this.email = cliente.getEmail();
    this.senha = cliente.getSenha();
    this.perfis = cliente.getPerfis().stream().map(x -> x.getCodigo()).collect(Collectors.toSet());
    this.dataCriacao = cliente.getDataCriacao();
    addPerfil(Perfil.CLIENTE);
  }
  
}
