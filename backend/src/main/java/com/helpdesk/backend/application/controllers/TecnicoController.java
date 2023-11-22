package com.helpdesk.backend.application.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.helpdesk.backend.domain.dtos.TecnicoDTO;
import com.helpdesk.backend.domain.model.Tecnico;
import com.helpdesk.backend.infrastructure.services.TecnicoService;

import jakarta.validation.Valid;

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

  @GetMapping
  public ResponseEntity<List<TecnicoDTO>> findAll() {
    List<Tecnico> tecnicos = tecnicoService.findAll();
    List<TecnicoDTO> tecnicoDTOs = tecnicos.stream().map(tec -> new TecnicoDTO(tec)).collect(Collectors.toList());
    return ResponseEntity.ok().body(tecnicoDTOs);
  }

  @PostMapping
  public ResponseEntity<TecnicoDTO> create(@Valid @RequestBody TecnicoDTO tecnicoDto) {
    Tecnico tecnico = tecnicoService.create(tecnicoDto);
    return ResponseEntity.status(HttpStatus.CREATED).body(new TecnicoDTO(tecnico));
  }

  @PutMapping("/{id}")
  public ResponseEntity<TecnicoDTO> update(@PathVariable("id") String id, @Valid @RequestBody TecnicoDTO tecnicoDto) {
    Tecnico tecnico = tecnicoService.update(id, tecnicoDto);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new TecnicoDTO(tecnico));
  }
}
