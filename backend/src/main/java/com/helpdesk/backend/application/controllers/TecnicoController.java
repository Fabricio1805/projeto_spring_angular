package com.helpdesk.backend.application.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.helpdesk.backend.domain.dtos.TecnicoDTO;
import com.helpdesk.backend.domain.model.Tecnico;
import com.helpdesk.backend.infrastructure.services.TecnicoService;

@RestController
@RequestMapping("/tecnicos")
public class TecnicoController {

  @Autowired
  private TecnicoService tecnicoService;
  
  @GetMapping("/{id}")
  public ResponseEntity<TecnicoDTO> findById(@PathVariable("id") String id) {
    Tecnico tecnico = tecnicoService.findById(id);
    return ResponseEntity.ok().body(new TecnicoDTO(tecnico));
  }
}
