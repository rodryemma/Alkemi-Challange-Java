package net.alkemi.repository.bd;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;

import net.alkemi.entity.personaje;
@Configuration
@EnableJpaRepositories
public interface PersonajeRepository extends JpaRepository<personaje, Integer>  {

	List<personaje> findBynombre(String nombre);

	@Query(value = "SELECT * FROM disney.personaje;", nativeQuery = true)
	List<personaje> getnombreimagen();
	
}