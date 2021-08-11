package br.com.edward.marte.domain;

import java.math.BigDecimal;

import br.com.edward.marte.enuns.EnumTipoPerfume;

public class Perfume {
	
	private static long gerador = 0;
	
	private Long id;
	private String nome;
	private BigDecimal valor;
	private EnumTipoPerfume tipo;
	
	public Perfume(String nome, BigDecimal valor, EnumTipoPerfume tipo) {
		this.id = ++gerador;
		this.nome = nome;
		this.valor = valor;
		this.tipo = tipo;
	}
	
	public void alterar(String nome, BigDecimal valor, EnumTipoPerfume tipo) {
		this.nome = nome;
		this.valor = valor;
		this.tipo = tipo;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public EnumTipoPerfume getTipo() {
		return tipo;
	}
}
