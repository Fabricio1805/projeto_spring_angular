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
@Entity(name = "tecnico")
public class Tecnico extends Pessoa {
  private static final long serialVersionUID = 1L;

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
}
