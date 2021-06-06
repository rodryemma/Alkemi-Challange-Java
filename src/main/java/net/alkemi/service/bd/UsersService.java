package net.alkemi.service.bd;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import net.alkemi.entity.users;
import net.alkemi.repository.bd.UsersRepository;
import net.alkemi.service.IusersService;
@Service
public class UsersService implements IusersService {

	@Autowired	
	UsersRepository userRespo;

	@Override
	public List<users> BuscarTodas() {
		return userRespo.findAll();
	}

	@Override
	public users buscarPorId(String username) {
		Optional<users> optional = userRespo.findById(username);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public void guardar(users users) {
		userRespo.save(users);
		
	}
	
	

}
