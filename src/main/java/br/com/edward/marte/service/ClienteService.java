package br.com.edward.marte.service;

import java.util.List;
import java.util.Optional;

import br.com.edward.marte.domain.Cliente;
import br.com.edward.marte.model.ClienteModel;

public interface ClienteService {

	Cliente cadastrar(ClienteModel model);
	Cliente alterar(Long id, ClienteModel model);
	Cliente apagar(Long id);
	List<Cliente> listar();
	Cliente consultar(Long id);
	
}
