package net.alkemi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import net.alkemi.entity.users;
import net.alkemi.service.IusersService;

@RestController
@RequestMapping("/api")
public class userController {

	@Autowired
	IusersService iUserSer;

	//Pedido de todos los usuarios
	@GetMapping("/users/full")
	public List<users>  buscarUsers(){
		List<users> lista = iUserSer.BuscarTodas(); 
		return lista;
	}
	
	//Pedido por id de usuario
	@GetMapping("/users/select/{users}")
	public users buscarPorId(@PathVariable("users") String us) {
		users u = iUserSer.buscarPorId(us);
		return u;
	}
	
	//Registrar usuario
	
	@PostMapping(value ="/register")
	
	public users guardarusuario(@RequestBody users us) {
		iUserSer.guardar(us);
		return us;
	}
	
	
}
