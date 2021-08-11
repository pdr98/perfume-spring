package br.com.edward.marte.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.edward.marte.domain.Cliente;
import lombok.Getter;

@Getter
public class ClienteModel {
	
	private Long id;
	
	@NotNull
	@NotBlank
	private String nome;
	
	@NotNull
	@NotBlank
	private String documento;
	
	public ClienteModel() { }
	
	public ClienteModel(Cliente domain) {
		this.id = domain.getId();
		this.nome = domain.getNome();
		this.documento = domain.getDocumento();
	}
	
}
