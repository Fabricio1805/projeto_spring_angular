package com.helpdesk.backend.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.helpdesk.backend.domain.model.Tecnico;

public interface TecnicoRepository extends JpaRepository<Tecnico, String> {

}
