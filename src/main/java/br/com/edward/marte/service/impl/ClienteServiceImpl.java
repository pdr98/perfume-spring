package br.com.edward.marte.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.edward.marte.domain.Cliente;
import br.com.edward.marte.exceptions.PerfumeNaoExisteException;
import br.com.edward.marte.model.ClienteModel;
import br.com.edward.marte.repository.ClienteRepository;
import br.com.edward.marte.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public Cliente cadastrar(ClienteModel model) {
		return clienteRepository.cadastrar(new Cliente(model.getNome(), model.getDocumento()));
	}

	@Override
	public Cliente alterar(Long id, ClienteModel model) {
		Cliente c = this.consultar(id);
		
		c.alterar(model.getNome(), model.getDocumento());
		
		return c;
	}

	@Override
	public Cliente apagar(Long id) {
		return this.clienteRepository.apagar(this.consultar(id));
	}

	@Override
	public List<Cliente> listar() {
		return this.clienteRepository.listar();
	}

	@Override
	public Cliente consultar(final Long id) {
		return this.clienteRepository.consultar(id).orElseThrow(() -> new PerfumeNaoExisteException(id));
	}
	
	
}
