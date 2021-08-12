package br.com.edward.marte.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.edward.marte.domain.Carrinho;
import br.com.edward.marte.domain.Cliente;
import br.com.edward.marte.domain.ItemCompra;
import br.com.edward.marte.domain.Perfume;
import br.com.edward.marte.exceptions.PerfumeNaoExisteException;
import br.com.edward.marte.model.CarrinhoModel;
import br.com.edward.marte.repository.CarrinhoRepository;
import br.com.edward.marte.repository.ClienteRepository;
import br.com.edward.marte.service.CarrinhoService;
import br.com.edward.marte.service.ClienteService;

@Service
public class CarrinhoServiceImpl implements CarrinhoService {

	@Autowired
	private CarrinhoRepository carrinhoRepository;
	@Autowired
	private ClienteService clienteService;
	
	
	@Override
	public Carrinho cadastrar(Long id) {
		Carrinho c = new Carrinho(clienteService.consultar(id));
		return carrinhoRepository.cadastrar(c);
	}


	@Override
	public List<Carrinho> listar() {
		return this.carrinhoRepository.listar();
	}

	@Override
	public Carrinho apagar(Long id) {
		return this.carrinhoRepository.apagar(this.consultar(id));
	}

	@Override
	public Carrinho adicionarItem(Long id, Perfume perfume, Integer qtd) {
		Carrinho c = this.consultar(id);
		c.addPerfume(perfume, qtd);
		return c;
	}


	@Override
	public Carrinho consultar(Long id) {
		return this.carrinhoRepository.consultar(id)
				.orElseThrow(() -> new PerfumeNaoExisteException(id));
	}

}
