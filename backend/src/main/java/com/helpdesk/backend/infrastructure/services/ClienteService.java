package com.helpdesk.backend.infrastructure.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helpdesk.backend.application.exceptions.DataIntegrityViolationException;
import com.helpdesk.backend.application.exceptions.NotFoundException;
import com.helpdesk.backend.domain.dtos.ClienteDTO;
import com.helpdesk.backend.domain.model.Cliente;
import com.helpdesk.backend.domain.model.Pessoa;
import com.helpdesk.backend.infrastructure.repository.ClienteRepository;
import com.helpdesk.backend.infrastructure.repository.PessoaRepository;

@Service
public class ClienteService {
  @Autowired
  private ClienteRepository clienteRepository;

  @Autowired
  private PessoaRepository pessoaRepository;

  public Cliente create(ClienteDTO clienteDto) {
    Cliente cliente = new Cliente(clienteDto);

    validateCpfExisting(cliente.getCpf());
    validateEmailExisting(cliente.getEmail());

    return clienteRepository.save(cliente);
  }

  public Cliente findById(String id) {
    Optional<Cliente> cliente = clienteRepository.findById(id);
    return cliente.orElseThrow(() -> new NotFoundException("Cliente não encontrado com o id: " + id));
  }

  public List<Cliente> findAll() {
    return clienteRepository.findAll();
  }

  public void update(String id, ClienteDTO clienteDto) {
    clienteDto.setId(id);
    Cliente cliente = findById(id);
    validateCpfExisting(clienteDto.getCpf());
    validateEmailExisting(clienteDto.getEmail());
    cliente = new Cliente(clienteDto);

    clienteRepository.save(cliente);
  }

  public void delete(String id) {
    Cliente cliente = findById(id);
    if (cliente.getChamados().size() > 0) {
      throw new DataIntegrityViolationException("Tecnico possui ordens de serviço e não pode ser deletado!");
    }
    clienteRepository.deleteById(id);
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
