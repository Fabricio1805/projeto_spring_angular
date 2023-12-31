package com.helpdesk.backend.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.helpdesk.backend.domain.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, String> {

}
