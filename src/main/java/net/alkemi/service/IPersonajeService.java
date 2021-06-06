package net.alkemi.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import net.alkemi.entity.personaje;

public interface IPersonajeService {

	void guardar(personaje personaje);
	List<personaje> BuscarTodas();
	personaje buscarPorId(Integer idpersonaje);
	void eliminar (Integer idpersonaje);
	
}
