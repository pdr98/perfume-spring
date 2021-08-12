package br.com.edward.marte.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Carrinho {
 
	private static Long contador = 0L;
	
	private List<ItemCompra> itens;	
	private Long id;
	private Cliente cliente;
	private LocalDateTime data;
	
	public Carrinho(Cliente cliente) {
		this.id = ++contador;
		this.itens = new ArrayList<>();
		this.cliente = cliente;
		this.data = LocalDateTime.now();
	}

	public Cliente getCliente() {
		return cliente;
	}


	public LocalDateTime getData() {
		return data;
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
}
