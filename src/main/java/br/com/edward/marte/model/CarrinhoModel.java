package br.com.edward.marte.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CarrinhoModel {
	
	private static long gerador = 0;
	
	private Long id;
	private List<ItemCarrinhoModel> itens;
	private EnumStatusCarrinhoModel status;

	public CarrinhoModel() {
		this.id = ++gerador;
		this.itens = new ArrayList<>();
		this.status = EnumStatusCarrinhoModel.ANDAMENTO;
	}
	
	public void addPerfume(PerfumeModel p, Integer qtd) {
		if (EnumStatusCarrinhoModel.FINALIZADO.equals(this.status)) {
			throw new RuntimeException("Carrinho finalizado");
		}
		this.itens.add(new ItemCarrinhoModel(p, qtd));
	}
	
	public void finalizar() {
		this.status = EnumStatusCarrinhoModel.FINALIZADO;
	}

	public Long getId() {
		return id;
	}

	public List<ItemCarrinhoModel> getItens() {
		return itens;
	}

	public BigDecimal getValorTotal() {
		BigDecimal soma = BigDecimal.ZERO;
		for (ItemCarrinhoModel i : itens) {
			soma = soma.add(i.getValorTotal());
		}
		return soma;
	}


	public EnumStatusCarrinhoModel getStatus() {
		return status;
	}
}
