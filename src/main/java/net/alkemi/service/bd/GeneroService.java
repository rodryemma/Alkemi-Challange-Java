package net.alkemi.service.bd;
import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import net.alkemi.entity.genero;
import net.alkemi.repository.bd.GeneroRepository;
import net.alkemi.service.IGeneroService;

@Service
public class GeneroService implements IGeneroService {

	@Autowired
	GeneroRepository generoRepo;
	
	
	@Override
	public void guardar(genero genero) {
		generoRepo.save(genero);
	}

	@Override
	public List<genero> BuscarTodas() {
		return generoRepo.findAll();
	}

	@Override
	public genero buscarPorId(Integer idgenero) {
		Optional<genero> optional = generoRepo.findById(idgenero);
		if(optional.isPresent()) {
			return optional.get();
		}
		
		return null;
	}

	@Override
	public void eliminar(Integer idgenero) {
		generoRepo.deleteById(idgenero);		
	}

}
