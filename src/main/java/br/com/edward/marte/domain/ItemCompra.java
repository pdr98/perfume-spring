package br.com.edward.marte.domain;

import java.math.BigDecimal;

public class ItemCompra {
	
	private static Long contador = 0L;
	
	private Long id;
	private Perfume perfume;
	private Integer qtd;
	private BigDecimal valorTotal;
	
	public ItemCompra(Perfume perfume, Integer qtd) {
		this.id = ++contador;
		this.perfume = perfume;
		this.qtd = qtd;
		this.valorTotal = perfume.getValor().multiply(BigDecimal.valueOf(qtd));
	}

	public static Long getContador() {
		return contador;
	}

	public Long getId() {
		return id;
	}

	public Perfume getPerfume() {
		return perfume;
	}

	public Integer getQtd() {
		return qtd;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}
	
}
