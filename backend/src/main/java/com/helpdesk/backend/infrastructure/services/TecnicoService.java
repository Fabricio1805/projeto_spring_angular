package com.helpdesk.backend.infrastructure.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helpdesk.backend.domain.model.Tecnico;
import com.helpdesk.backend.infrastructure.repository.TecnicoRepository;

@Service
public class TecnicoService {
  @Autowired
  private TecnicoRepository tecnicoRepository;


  public Optional<Tecnico> findById(String id) {
    return this.tecnicoRepository.findById(id);
  }
}
