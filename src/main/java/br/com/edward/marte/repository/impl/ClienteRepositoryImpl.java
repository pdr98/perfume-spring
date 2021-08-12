package br.com.edward.marte.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import br.com.edward.marte.domain.Cliente;
import br.com.edward.marte.repository.ClienteRepository;

@Repository
public class ClienteRepositoryImpl implements ClienteRepository {
	
	private final static List<Cliente> CLIENTE = new ArrayList<Cliente>();
	
	
	@Override
	public Cliente cadastrar(Cliente domain) {
		CLIENTE.add(domain);
		return domain;
	}

	@Override
	public Cliente apagar(Cliente domain) {
		CLIENTE.remove(domain);
		return domain;
	}

	@Override
	public List<Cliente> listar() {
		return CLIENTE;
	}

	@Override
	public Optional<Cliente> consultar(Long id) {
		for(Cliente c : CLIENTE) {
			if(id.equals(c.getId())) {
				return Optional.of(c);
			}
		}
		return null;
	}
	
}
