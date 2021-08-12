package br.com.edward.marte.repository;

import java.util.List;
import java.util.Optional;

import br.com.edward.marte.domain.Carrinho;

public interface CarrinhoRepository {

	Carrinho adicionar(Carrinho domain);
	Carrinho apagar(Carrinho domain);
	List<Carrinho> listar();
	Optional<Carrinho> consultar(Long id);
	
}
