package com.helpdesk.backend.domain.model;

import java.util.ArrayList;
import java.util.List;

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
}
