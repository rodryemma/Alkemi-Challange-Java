package net.alkemi.service;

import java.util.List;


import net.alkemi.entity.genero;

public interface IGeneroService {

	void guardar(genero genero);
	List<genero> BuscarTodas();
	genero buscarPorId(Integer idgenero);
	void eliminar (Integer idgenero);
}
