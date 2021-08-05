package br.com.edward.marte.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.edward.marte.armazenamento.SalvaDados;
import br.com.edward.marte.model.PessoaFisicaModel;

@RestController
@RequestMapping("/pf")
public class PessoaFisicaController {

    @GetMapping("/valida-cpf")
    public Boolean validaCpf(@RequestParam(value = "cpf") String cpf) {
        return new PessoaFisicaModel("", cpf).isDocumentoValido();
    }

    @GetMapping("/cadastrar")
    public PessoaFisicaModel cadastrar(@RequestParam String nome,
    		                           @RequestParam(value = "cpf") String documento) {
        
    	PessoaFisicaModel pessoa = new PessoaFisicaModel(nome, documento);
    	SalvaDados.pessoasFisicas.add(pessoa);
    	return pessoa;
    }
    
    @GetMapping("/alterar")
    public PessoaFisicaModel alterar(@RequestParam Long id,
    		                         @RequestParam String nome,
    		                         @RequestParam String cpf) {
    	
    	for (PessoaFisicaModel pessoa : SalvaDados.pessoasFisicas) {
			if (id.equals(pessoa.getId())) {
				pessoa.alterar(nome, cpf);
				return pessoa;
			}
		}
    	return null;
    }
    
    @GetMapping("/listar")
    public List<PessoaFisicaModel> listar() {
    	return SalvaDados.pessoasFisicas;
    }
}
