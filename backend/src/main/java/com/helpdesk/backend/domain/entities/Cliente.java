package com.helpdesk.backend.domain.entities;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cliente extends Pessoa {
  private List<Chamado> chamados = new ArrayList<Chamado>();

  public Cliente() {
    super();
  }

  public Cliente(String id, String nome, String cpf, String email, String senha) {
    super(id, nome, cpf, email, senha);
  }
}
