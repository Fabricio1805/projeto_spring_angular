package com.helpdesk.backend.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Status {

  ABERTO(0, "ABEABERTO"), ANDAMENTO(1, "ANDAMENTO"), ENCERRADO(2, "ENCERRADO");

  private Integer codigo;
  private String descricao;

  public static Perfil toEnum(Integer cod) {
    if (cod == null) {
      return null;
    }

    for (Perfil p : Perfil.values()) {
      if (cod.equals(p.getCodigo())) {
        return p;
      }
    }

    throw new IllegalArgumentException("Status inválido");
  }

}
