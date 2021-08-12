package br.com.edward.marte.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.edward.marte.model.ClienteModel;
import br.com.edward.marte.model.PerfumeModel;
import br.com.edward.marte.repository.ClienteRepository;
import br.com.edward.marte.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@PostMapping("/cadastrar")
	public ClienteModel CadastrarCliente(@Valid @RequestBody ClienteModel model) {
		return new ClienteModel(clienteService.cadastrar(model));
	}
	
	@DeleteMapping("/apagar/{id}")
	public ClienteModel ApagarCliente(@PathVariable Long id, @RequestBody ClienteModel model) {
		return new ClienteModel(clienteService.apagar(id));
	}
	
	@PutMapping("/alterar/{id}")
	public ClienteModel AlterarCliente(@PathVariable Long id, @RequestBody ClienteModel model) {
		return new ClienteModel(clienteService.alterar(id, model));
	}
	
	@GetMapping("/listar")
	public List<ClienteModel> ListarCliente() {
		return clienteService.listar().stream().map(ClienteModel::new).collect(Collectors.toList());
	}
	
}
