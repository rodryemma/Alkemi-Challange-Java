package net.alkemi.controller;

import java.util.ArrayList;

import java.util.List;

import javax.naming.Binding;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.NamedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.alkemi.entity.personaje;
import net.alkemi.repository.bd.PersonajeRepository;
import net.alkemi.service.IPersonajeService;
import net.alkemi.service.bd.PersonajeService;
import net.alkemi.util.Utileria;

@RestController
@RequestMapping("/api")
public class personajeController {

	@Autowired
	private IPersonajeService iperServ;
	
	@Autowired
	private PersonajeRepository perRepo;
	
	
	
	@GetMapping("/detalles")
	public List<personaje> Buscar(){
        List<personaje> lista = iperServ.BuscarTodas();
        return lista;
	}	
	
	@GetMapping("/characters")
	public List<personaje> personajeNombre(String nombre){
		List<personaje> lista=perRepo.findBynombre("Hulk");
	return lista;
	}
	
	
	
	
	@PostMapping("/save")
	public String guardar(personaje personaje, BindingResult result, RedirectAttributes attributes,
			@RequestParam("archivoImagen") MultipartFile multiPart) {

		if (result.hasErrors()) {
			for (ObjectError error : result.getAllErrors()) {
				System.out.println("Ocurrio un error: " + error.getDefaultMessage());
			}
			return "/personaje";
		}

		if (!multiPart.isEmpty()) {
			String ruta = "c:/Disney/img";
			String nombreImagen = Utileria.guardarArchivo(multiPart, ruta);
			if (nombreImagen != null) { 
				personaje.setImagen(nombreImagen);
			}
		}
		
		iperServ.guardar(personaje);
		attributes.addFlashAttribute("msg",	"Registro guardado");
		System.out.println("Personaje: "+personaje);
		return"redirect:/personaje/index";

	}

}
