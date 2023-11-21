package com.helpdesk.backend.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.helpdesk.backend.domain.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, String> {

}
