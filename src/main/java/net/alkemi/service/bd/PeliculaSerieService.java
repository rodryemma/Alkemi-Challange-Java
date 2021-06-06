package net.alkemi.service.bd;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import net.alkemi.entity.peliculaserie;
import net.alkemi.repository.bd.PeliculaSerieRepository;
import net.alkemi.service.IPeliculaSerieService;

@Service
public class PeliculaSerieService implements IPeliculaSerieService {

	@Autowired
	PeliculaSerieRepository peliculaserieRepo;
	
	@Override
	public void guardar(peliculaserie peliculaserie) {
		peliculaserieRepo.save(peliculaserie);

	}

	@Override
	public List<peliculaserie> BuscarTodas() {
		return peliculaserieRepo.findAll();
	}

	@Override
	public peliculaserie buscarPorId(Integer idpeliculaserie) {
		Optional<peliculaserie> optional = peliculaserieRepo.findById(idpeliculaserie);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public void eliminar(Integer idpeliculaserie) {
		peliculaserieRepo.deleteById(idpeliculaserie);
	}

}
