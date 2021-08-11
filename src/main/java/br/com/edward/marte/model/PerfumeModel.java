package br.com.edward.marte.model;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.edward.marte.domain.Perfume;
import br.com.edward.marte.enuns.EnumTipoPerfume;
import lombok.Getter;

@Getter
public class PerfumeModel {

	private Long id;
	
	@NotBlank
	@NotNull
	private String nome;
	
	@NotNull
	private BigDecimal valor;
	
	@NotNull
	private EnumTipoPerfume tipo;
	
	public PerfumeModel() { }

	public PerfumeModel(Perfume domain) {
		this.id = domain.getId();
		this.nome = domain.getNome();
		this.valor = domain.getValor();
		this.tipo = domain.getTipo();
	}
}
