package net.alkemi.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "peliculaserie")
public class peliculaserie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String imagen; 
	private String titulo;
	private Date fechaCreacion;
	private int calificacion;
	
	
	@ManyToMany(mappedBy = "peliculaserie")
	@JsonIgnore
    private List<personaje> personaje;
	
	@ManyToOne
	@JoinColumn(name = "idgenero")
	
	private genero genero;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getImagen() {
		return imagen;
	}


	public void setImagen(String imagen) {
		this.imagen = imagen;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public Date getFechaCreacion() {
		return fechaCreacion;
	}


	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}


	public int getCalificacion() {
		return calificacion;
	}


	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}



	public genero getGenero() {
		return genero;
	}


	public void setGenero(genero genero) {
		this.genero = genero;
	}

	
	
	
	public List<personaje> getPersonaje() {
		return personaje;
	}


	public void setPersonaje(List<personaje> personaje) {
		this.personaje = personaje;
	}


	@Override
	public String toString() {
		return "peliculaserie [id=" + id + ", imagen=" + imagen + ", titulo=" + titulo + ", fechaCreacion="
				+ fechaCreacion + ", calificacion=" + calificacion + ", personaje=" + personaje + ", genero=" + genero
				+ ", getId()=" + getId() + ", getImagen()=" + getImagen() + ", getTitulo()=" + getTitulo()
				+ ", getFechaCreacion()=" + getFechaCreacion() + ", getCalificacion()=" + getCalificacion()
				+ ", getGenero()=" + getGenero() + ", getPersonaje()=" + getPersonaje() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}


	




	


	
	
	
	
	
	
}
