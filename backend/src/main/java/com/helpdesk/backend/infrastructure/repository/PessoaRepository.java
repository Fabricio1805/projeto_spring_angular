package com.helpdesk.backend.infrastructure.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.helpdesk.backend.domain.model.Pessoa;


public interface PessoaRepository extends JpaRepository<Pessoa, String> {
  Optional<Pessoa> findByCpf(String cpf);
  Optional<Pessoa> findByEmail(String email);
}
