package br.com.edward.marte.repository;

import java.util.List;
import java.util.Optional;

import br.com.edward.marte.domain.Perfume;

public interface PerfumeRepository {
	
	Perfume cadastrar(Perfume domain);
	Perfume apagar(Perfume domain);
	List<Perfume> listar();
	Optional<Perfume> consultar(Long id);
}
