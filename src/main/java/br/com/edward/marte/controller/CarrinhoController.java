package br.com.edward.marte.controller;

import java.util.Objects;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.edward.marte.armazenamento.SalvaDados;
import br.com.edward.marte.model.CarrinhoModel;
import br.com.edward.marte.model.PerfumeModel;

@RestController
@RequestMapping("/carrinho")
public class CarrinhoController {

	@GetMapping("/add-perfume")
	public CarrinhoModel addPerfume(@RequestParam Long id,
			                        @RequestParam Integer qtd) {
		
		PerfumeModel perfume = SalvaDados.perfumes.stream()
				.filter(p -> id.equals(p.getId()))
				.findFirst()
				.orElse(null);
		if (Objects.isNull(perfume)) {
			return null;
		}
		
		CarrinhoModel carrinho = SalvaDados.carrinho;
		carrinho.addPerfume(perfume, qtd);
		return carrinho;
	}
	
	@GetMapping("/finalizar")
	public CarrinhoModel finalizar() {
		
		CarrinhoModel carrinho = SalvaDados.carrinho;
		carrinho.finalizar();
		SalvaDados.carrinho = new CarrinhoModel();
		return carrinho;
	}
	
	@GetMapping("/ver")
	public CarrinhoModel ver() {
		return SalvaDados.carrinho;
	}
}
