package br.com.edward.marte.service;

import java.util.List;

import br.com.edward.marte.domain.Carrinho;
import br.com.edward.marte.domain.Cliente;
import br.com.edward.marte.domain.ItemCompra;
import br.com.edward.marte.domain.Perfume;
import br.com.edward.marte.model.CarrinhoModel;

public interface CarrinhoService {
	
	Carrinho cadastrar(Long id);
	List<Carrinho> listar();
	Carrinho apagar(Long id);
	Carrinho adicionarItem(Long id, Perfume perfume, Integer qtd);
	Carrinho consultar(Long id);

}
