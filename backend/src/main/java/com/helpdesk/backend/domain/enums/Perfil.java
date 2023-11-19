package com.helpdesk.backend.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Perfil {
  ADMIN(0, "ROLE_ADMIN"), CLIENTE(1, "ROLE_CLIENTE"), TECNICO(2, "ROLE_TECNICO");

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

    throw new IllegalArgumentException("Perfil inválido");
  }
}
