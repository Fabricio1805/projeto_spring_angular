package com.helpdesk.backend.application.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.helpdesk.backend.domain.dtos.ClienteDTO;
import com.helpdesk.backend.domain.model.Cliente;
import com.helpdesk.backend.infrastructure.services.ClienteService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
  @Autowired
  private ClienteService clienteService;

  @PostMapping
  public ResponseEntity<ClienteDTO> create(@RequestBody ClienteDTO clienteDto) {
    Cliente cliente = clienteService.create(clienteDto);
    return ResponseEntity.status(HttpStatus.CREATED).body(new ClienteDTO(cliente));
  }

   @GetMapping("/{id}")
  public ResponseEntity<ClienteDTO> findById(@PathVariable("id") String id) {
    Cliente cliente = clienteService.findById(id);
    return ResponseEntity.ok().body(new ClienteDTO(cliente));
  }

  @GetMapping
  public ResponseEntity<List<ClienteDTO>> findAll() {
    List<Cliente> clientes = clienteService.findAll();
    List<ClienteDTO> clienteDtos = clientes.stream().map(client -> new ClienteDTO(client)).collect(Collectors.toList());
    return ResponseEntity.ok().body(clienteDtos);
  }

   @PutMapping("/{id}")
  public ResponseEntity<Void> update(@PathVariable("id") String id, @Valid @RequestBody ClienteDTO clienteDto) {
    clienteService.update(id, clienteDto);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable("id") String id) {
    clienteService.delete(id);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }
}
