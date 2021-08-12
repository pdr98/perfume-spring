package br.com.edward.marte.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Carrinho {
 
	private static Long contador = 0L;
	
	private List<ItemCompra> itens;	
	private Long id;
	
	
	public Carrinho() {
		this.id = ++contador;
		this.itens = new ArrayList<>();
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
			return soma;
		}
		return null;
	}
}
