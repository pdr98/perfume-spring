package br.com.edward.marte.model;

/**
 * http://www.cadcobol.com.br/calcula_cpf_cnpj_caepf.htm
 */
public abstract class PessoaModel {

	private static long gerador = 0;
	
	private Long id;
	private String nome;
    private String documento;

    public PessoaModel(String nome, String documento) {
    	this.id = ++gerador;
    	this.nome = nome;
        this.documento = documento;
    }
    
    public void alterar(String nome, String documento) {
    	this.nome = nome;
        this.documento = documento;
	}

    public abstract Boolean isDocumentoValido();

    public abstract String getNovoDocumento(); //bonus

    public abstract String getDocumentoFormatado(); //bonus bonus

    public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getDocumento() {
        return documento;
    }
}
