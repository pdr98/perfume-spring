package br.com.edward.marte.repository;

import java.util.List;
import java.util.Optional;

import br.com.edward.marte.domain.Cliente;

public interface ClienteRepository {

	Cliente cadastrar(Cliente domain);
	Cliente apagar(Cliente domain);
	List<Cliente> listar();
	Optional<Cliente> consultar(Long id);
	
}
