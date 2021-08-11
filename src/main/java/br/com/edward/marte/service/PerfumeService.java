package br.com.edward.marte.service;

import java.util.List;

import br.com.edward.marte.domain.Perfume;
import br.com.edward.marte.model.PerfumeModel;

public interface PerfumeService {

	Perfume cadastrar(PerfumeModel model);
	Perfume alterar(Long id, PerfumeModel model);
	Perfume apagar(Long id);
	List<Perfume> listar();
	Perfume consultar(Long id);
	
}
