package net.alkemi.service.bd;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import net.alkemi.entity.personaje;
import net.alkemi.repository.bd.PersonajeRepository;
import net.alkemi.service.IPersonajeService;


@Service
public class PersonajeService implements IPersonajeService {

	@Autowired
	PersonajeRepository personajeRepo;
	
	
	@Override
	public void guardar(personaje personaje) {
		personajeRepo.save(personaje);	
	}

	@Override
	public List<personaje> BuscarTodas() {
		return personajeRepo.findAll();
	}

	@Override
	public personaje buscarPorId(Integer idpersonaje) {
		Optional<personaje> optional = personajeRepo.findById(idpersonaje);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public void eliminar(Integer idpersonaje) {
		personajeRepo.deleteById(idpersonaje);
	}

	
	
}
