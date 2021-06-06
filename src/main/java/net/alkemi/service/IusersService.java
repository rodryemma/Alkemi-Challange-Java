package net.alkemi.service;

import java.util.List;

import net.alkemi.entity.personaje;
import net.alkemi.entity.users;

public interface IusersService {
	List<users> BuscarTodas();
	users buscarPorId(String username);
	void guardar(users users);
}
