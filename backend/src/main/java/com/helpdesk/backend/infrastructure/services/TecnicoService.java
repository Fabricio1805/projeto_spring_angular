package com.helpdesk.backend.infrastructure.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.helpdesk.backend.application.exceptions.DataIntegrityViolationException;
import com.helpdesk.backend.application.exceptions.NotFoundException;
import com.helpdesk.backend.domain.dtos.TecnicoDTO;
import com.helpdesk.backend.domain.model.Pessoa;
import com.helpdesk.backend.domain.model.Tecnico;
import com.helpdesk.backend.infrastructure.repository.PessoaRepository;
import com.helpdesk.backend.infrastructure.repository.TecnicoRepository;

@Service
public class TecnicoService {
  @Autowired
  private TecnicoRepository tecnicoRepository;

  @Autowired
  private PessoaRepository pessoaRepository;

  public Tecnico findById(String id) {
    Optional<Tecnico> tecnico = tecnicoRepository.findById(id);
    return tecnico.orElseThrow(() -> new NotFoundException("Tecnico não encontrado com o id: " + id));
  }
  
  public List<Tecnico> findAll() {
    return tecnicoRepository.findAll();
  }

  public Tecnico create(TecnicoDTO tecnicoDto) {

    validateCpfExisting(tecnicoDto.getCpf());
    validateEmailExisting(tecnicoDto.getEmail());
    Tecnico tecnico = new Tecnico(tecnicoDto);
    return tecnicoRepository.save(tecnico);
  }
  
  public Tecnico update(String id, TecnicoDTO tecnicoDTO) {
    tecnicoDTO.setId(id);
    Tecnico tecnico = findById(id);
    validateCpfExisting(tecnicoDTO.getCpf());
    validateEmailExisting(tecnicoDTO.getEmail());
    tecnico = new Tecnico(tecnicoDTO);

    return tecnicoRepository.save(tecnico);
  }
  

  private void validateCpfExisting(String cpf) {
    Optional<Pessoa> pessoa = pessoaRepository.findByCpf(cpf);
    if (pessoa.isPresent()) {
      throw new DataIntegrityViolationException("CPF já cadastrado no sistema!");
    }
  }

  private void validateEmailExisting(String email) {
    Optional<Pessoa> pessoa = pessoaRepository.findByEmail(email);
    if (pessoa.isPresent()) {
      throw new DataIntegrityViolationException("EMAIL já cadastrado no sistema!");
    }
  }
}
