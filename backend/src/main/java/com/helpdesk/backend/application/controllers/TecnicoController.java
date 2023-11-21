package com.helpdesk.backend.application.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.helpdesk.backend.domain.model.Tecnico;
import com.helpdesk.backend.infrastructure.services.TecnicoService;

@RestController
@RequestMapping("/tecnicos")
public class TecnicoController {

  @Autowired
  private TecnicoService tecnicoService;
  
  @GetMapping("/{id}")
  public ResponseEntity<Tecnico> findById(@PathVariable("id") String id) {
    return tecnicoService.findById(id)
      .map(tecnico -> ResponseEntity.ok(tecnico))
        .orElseGet(() -> ResponseEntity.notFound().build());
  }
}
