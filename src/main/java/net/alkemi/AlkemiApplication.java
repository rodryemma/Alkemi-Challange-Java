package net.alkemi;

import java.util.Date;


import java.util.LinkedList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import net.alkemi.entity.genero;
import net.alkemi.entity.peliculaserie;
import net.alkemi.entity.personaje;
import net.alkemi.entity.users;

import net.alkemi.repository.bd.GeneroRepository;
import net.alkemi.repository.bd.PeliculaSerieRepository;
import net.alkemi.repository.bd.PersonajeRepository;
import net.alkemi.repository.bd.UsersRepository;
import net.alkemi.service.IGeneroService;
import net.alkemi.service.IPeliculaSerieService;
import net.alkemi.service.IPersonajeService;
import net.alkemi.service.IusersService;



@SpringBootApplication
public class AlkemiApplication implements CommandLineRunner{

	@Autowired
	private IGeneroService generoSer;
	
	@Autowired
	private IPeliculaSerieService pelserSer;
	
	@Autowired
	private IPersonajeService personSer;
	
	@Autowired
	private PersonajeRepository persoRepo;
	
	@Autowired
	private UsersRepository userRepo;
	
	@Autowired
	private IusersService iUserServ;
	

	public static void main(String[] args) {
		SpringApplication.run(AlkemiApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		
		//guardarpelserie();
		buscarpelserie();
		//guardargenero();
		buscargenero();
		buscarPersonaje();
		//personajeNombre();
		personajeNombreImagen();
		//userMostrar();
		usersFUll();
		//cargarUser();
		
	}
	
	private void cargarUser() {
		users u = new users();
		//u=iUserServ.buscarPorId("root");
		u.setUsername("jink");
		u.setPassword("{noop}15039022");
		u.setEnabled(1);
		iUserServ.guardar(u);
	}
	
	
	private void usersFUll() {
		List<users> lista = iUserServ.BuscarTodas(); 
		
		for(users u : lista) {
			System.out.println("Nombre: "+u.getUsername()+" Contraseña: "+u.getPassword()+" Alta: "+u.getEnabled());
		}
	}
	 
	private void personajeNombreImagen() {
		List<personaje> lista = persoRepo.getnombreimagen();
		for(personaje p : lista) {
			System.out.println(" nombre: "+p.getNombre());
		}
	}
	
	private void personajeNombre() {
		List<personaje> lista=persoRepo.findBynombre("Hulk");
		System.out.println("Prueba con Query:");
		for(personaje p : lista) {
			System.out.println(p.getId()+" nombre: "+p.getNombre());
		}
	}
	
	private void guardargenero() {
		genero gen = new genero();
		gen.setImagen("documento/drama.jpg");
		gen.setNombre("drama");
		generoSer.guardar(gen);
		
	}
	
	private void buscargenero() {
		List<genero> lista = generoSer.BuscarTodas();
		System.out.println("--------Lista de Genero Completa-------");
		for(genero g: lista) {
			System.out.println("Id: "+g.getId()+" Nombre: "+g.getNombre()+" Imagen: "+g.getImagen());
		}
	}
	
	private void guardarpelserie() {
		peliculaserie pelser = new peliculaserie();
		
		genero gen1 = new genero();
		gen1.setId(1);
		
		pelser.setCalificacion(4);
		pelser.setFechaCreacion(new Date());
		pelser.setImagen("documento/img/peli2");
		pelser.setTitulo("Piratas del caribe");
		pelser.setGenero(gen1);
		
		pelserSer.guardar(pelser);
		
	}
	
	private void buscarpelserie() {
		List<peliculaserie> lista = pelserSer.BuscarTodas();
		System.out.println("--------Lista de Series o Pleiculas Completa-------");
		for(peliculaserie ps: lista) {
			System.out.println("Imagen: "+ps.getImagen()+" titulo: "+ps.getTitulo()+" fechaCreacion: "+ps.getFechaCreacion()+" calificacion: "+ps.getCalificacion()+" :idgenero: "+ps.getGenero().getId());
		}
	}
	
	private void buscarPersonaje() {
		List<personaje> lista = personSer.BuscarTodas();
		System.out.println("--------Lista de Personajes Completa-------");
		for(personaje per : lista) {
			System.out.println("Id: "+per.getId());
		}
	}
}
