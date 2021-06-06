package net.alkemi.service;

import java.util.List;

import net.alkemi.entity.peliculaserie;

public interface IPeliculaSerieService {

	void guardar(peliculaserie peliculaserie);
	List<peliculaserie> BuscarTodas();
	peliculaserie buscarPorId(Integer idpeliculaserie);
	void eliminar (Integer idpeliculaserie);
}
