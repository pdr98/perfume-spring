package br.com.edward.marte.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.edward.marte.domain.Carrinho;
import br.com.edward.marte.domain.Cliente;
import br.com.edward.marte.domain.ItemCompra;
import br.com.edward.marte.domain.Perfume;
import br.com.edward.marte.model.CarrinhoModel;
import br.com.edward.marte.service.CarrinhoService;
import br.com.edward.marte.service.ClienteService;
import br.com.edward.marte.service.PerfumeService;

@RestController
@RequestMapping("/carrinho")
public class CarrinhoController {

	
	@Autowired
	private CarrinhoService carrinhoService;
	@Autowired
	private PerfumeService perfumeService;
	@Autowired
	private ClienteService clienteService;
	
	
	@PostMapping("/cadastrar/{idCliente}")
	public void cadastrar(@PathVariable Long idCliente) {
		carrinhoService.cadastrar(idCliente);
	}
	
	@GetMapping("/listar")
	public List<CarrinhoModel> listar() {
		return carrinhoService.listar().stream().map(CarrinhoModel::new).collect(Collectors.toList());
	}
	
	@DeleteMapping("/apagar/{id}")
	public CarrinhoModel apagar(@PathVariable Long id) {
		return new CarrinhoModel(carrinhoService.apagar(id));
	}
	
	@PostMapping("/adicionar/{idCarrinho}/{idPerfume}/{qtd}")
	public Carrinho adicionar(@PathVariable Long idCarrinho,
							  @PathVariable Long idPerfume,
			                  @PathVariable Integer qtd) {
		
		Carrinho c = carrinhoService.consultar(idCarrinho);
		Perfume p = perfumeService.consultar(idPerfume);
		
		c.addPerfume(p, qtd);
		
		return c;
	}
	
	@DeleteMapping("apagar-item/{idCarrinho}/{idItemCompra")
	public Carrinho apagarItem(@PathVariable Long idCarrinho,
							   @PathVariable Long idItemCompra) {
		
		Carrinho c = carrinhoService.consultar(idCarrinho);
		
		for(ItemCompra i : c.getItens()) {
			if(idItemCompra.equals(i.getId())) {
				c.getItens().remove(i);
				return c;
			}
		}
		return null;
	}
	
	
}
