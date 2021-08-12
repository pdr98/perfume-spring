package br.com.edward.marte.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import br.com.edward.marte.domain.Carrinho;
import br.com.edward.marte.domain.Cliente;
import br.com.edward.marte.domain.ItemCompra;
import br.com.edward.marte.domain.Perfume;

public class CarrinhoModel {

	private Long id;
	private List<ItemCompra> itens;
	private Cliente cliente;
	private LocalDateTime data;
	
	public CarrinhoModel() { }
	
	
	public CarrinhoModel(Carrinho domain) {
		this.id = domain.getId();
		this.itens = domain.getItens();
		this.cliente = domain.getCliente();
		this.data = domain.getData();
	}
	
	public Long getId() {
		return id;
	}
	
	public List<ItemCompra> getItens() {
		return itens;
	}
	
	public void addPerfume(Perfume perfume, Integer qtd) {
		this.itens.add(new ItemCompra(perfume, qtd));
	}
	
	public BigDecimal getValorTotal() {
		BigDecimal soma = BigDecimal.ZERO;
		for(ItemCompra i : itens) {
			soma = i.getValorTotal().add(soma);
		}
		return soma;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public LocalDateTime getData() {
		return data;
	}
}
