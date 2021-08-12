package br.com.edward.marte.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import br.com.edward.marte.domain.Carrinho;
import br.com.edward.marte.domain.Cliente;
import br.com.edward.marte.repository.CarrinhoRepository;

@Repository
public class CarrinhoRepositoryImpl implements CarrinhoRepository {
	
	public static List<Carrinho> CARRINHOS = new ArrayList<Carrinho>();
	
	@Override
	public Carrinho cadastrar(Carrinho domain) {
		CARRINHOS.add(domain);
		return domain;
	}

	@Override
	public Carrinho apagar(Carrinho domain) {
		CARRINHOS.remove(domain);
		return domain;
	}

	@Override
	public List<Carrinho> listar() {
		return CARRINHOS;
	}

	@Override
	public Optional<Carrinho> consultar(Long id) {
		return CARRINHOS.stream().filter(p -> id.equals(p.getId())).findFirst();
	}
	
}
