package com.helpdesk.backend.infrastructure.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.helpdesk.backend.application.exception.NotFoundException;
import com.helpdesk.backend.domain.dtos.TecnicoDTO;
import com.helpdesk.backend.domain.model.Tecnico;
import com.helpdesk.backend.infrastructure.repository.TecnicoRepository;

@Service
public class TecnicoService {
  @Autowired
  private TecnicoRepository tecnicoRepository;

  public Tecnico findById(String id) {
    Optional<Tecnico> tecnico = tecnicoRepository.findById(id);
    return tecnico.orElseThrow(() -> new NotFoundException("Tecnico não encontrado com o id: " + id));
  }
  
  public List<Tecnico> findAll() {
    return tecnicoRepository.findAll();
  }

  public Tecnico create(TecnicoDTO tecnicoDto) {
    Tecnico tecnico = new Tecnico(tecnicoDto);
    return tecnicoRepository.save(tecnico);
  }
}
