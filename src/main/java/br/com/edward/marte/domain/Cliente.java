package br.com.edward.marte.domain;


import lombok.Getter;

@Getter
public class Cliente {

	private static Long contador;
	
	private Long id;
	private String nome;
	private String documento;
	
	public Cliente(String nome, String documento) {
		this.id = ++contador;
		this.nome = nome;
		this.documento = documento;
	}
	
	public void alterar(String nome, String documento) {
		this.nome = nome;
		this.documento = documento;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getDocumento() {
		return documento;
	}
	
	public Long getId() {
		return id;
	}

}
