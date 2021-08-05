package br.com.edward.marte.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.edward.marte.armazenamento.SalvaDados;
import br.com.edward.marte.model.EnumTipoPerfumeModel;
import br.com.edward.marte.model.PerfumeModel;

@RestController
@RequestMapping("/perfume")
public class PerfumeController {

	@GetMapping("/cadastrar")
	public PerfumeModel cadastrar(@RequestParam String nome,
	                              @RequestParam BigDecimal valor,
	                              @RequestParam EnumTipoPerfumeModel tipo) {
		PerfumeModel p = new PerfumeModel(nome, valor, tipo);
		SalvaDados.perfumes.add(p);
		return p;
	}
	
	@GetMapping("/alterar")
	public PerfumeModel alterar(@RequestParam Long id,
			                    @RequestParam String nome,
			                    @RequestParam BigDecimal valor,
			                    @RequestParam EnumTipoPerfumeModel tipo) {
		for (PerfumeModel p : SalvaDados.perfumes) {
			if (id.equals(p.getId())) {
				p.alterar(nome, valor, tipo);
				return p;
			}
		}
		return null;
	}
	
	@GetMapping("/apagar")
	public PerfumeModel apagar(@RequestParam Long id) {
		
		PerfumeModel perfume = null;
		for (PerfumeModel p : SalvaDados.perfumes) {
			if (id.equals(p.getId())) {
				perfume = p;
				break;
			}
		}
		
		if (Objects.nonNull(perfume)) {
			SalvaDados.perfumes.remove(perfume);
			return perfume;
		}
		return null;
	}
	
	@GetMapping("/listar")
	public List<PerfumeModel> listar() {
		return SalvaDados.perfumes;
	}
}
