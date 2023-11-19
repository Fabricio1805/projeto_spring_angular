package com.helpdesk.backend.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Prioridade {

  BAIXA(0, "BAIXA"), MEDIA(1, "MEDIA"), ALTA(2, "ALTA");

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

    throw new IllegalArgumentException("Prioridade inválida");
  }

}
