package com.helpdesk.backend.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.helpdesk.backend.domain.model.Chamado;

public interface ChamadoRepository extends JpaRepository<Chamado, String> {

}
