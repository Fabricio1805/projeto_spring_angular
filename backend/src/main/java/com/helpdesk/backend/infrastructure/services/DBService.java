package com.helpdesk.backend.infrastructure.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helpdesk.backend.domain.enums.Perfil;
import com.helpdesk.backend.domain.enums.Prioridade;
import com.helpdesk.backend.domain.enums.Status;
import com.helpdesk.backend.domain.model.Chamado;
import com.helpdesk.backend.domain.model.Cliente;
import com.helpdesk.backend.domain.model.Tecnico;
import com.helpdesk.backend.infrastructure.repository.ChamadoRepository;
import com.helpdesk.backend.infrastructure.repository.ClienteRepository;
import com.helpdesk.backend.infrastructure.repository.TecnicoRepository;

@Service
public class DBService {

  @Autowired
	private TecnicoRepository tecnicoRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private ChamadoRepository chamadoRepository;

  
  public void instanciaDB() {
    Tecnico tec1 = new Tecnico(null, "fabricio souza", "440989029073", "tecnico@teste.com", "1234");
		tec1.addPerfil(Perfil.ADMIN);

		Cliente cli1 = new Cliente(null, "fabricio souza", "44013029073", "cliente@teste.com", "1234");

		Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "chamado 01", "primeiro chamado", tec1, cli1);

		tecnicoRepository.saveAll(Arrays.asList(tec1));
		clienteRepository.saveAll(Arrays.asList(cli1));
		chamadoRepository.saveAll(Arrays.asList(c1));
  }
}
