package br.com.edward.marte.model;

import java.math.BigDecimal;

public class ItemCarrinhoModel {

	private static long gerador = 0;
	
	private Long id;
	private PerfumeModel perfume;
	private Integer qtd;
	private BigDecimal valorTotal;

	public ItemCarrinhoModel(PerfumeModel p, Integer qtd) {
		this.id = ++gerador;
		this.perfume = p;
		this.qtd = qtd;
		this.valorTotal = p.getValor().multiply(BigDecimal.valueOf(qtd));
	}

	public Long getId() {
		return id;
	}

	public PerfumeModel getPerfume() {
		return perfume;
	}

	public Integer getQtd() {
		return qtd;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}
}
