package net.alkemi.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "genero" )
public class genero {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombre;
	private String imagen;
	
	@OneToMany(mappedBy="genero")
	@JsonIgnore
	private List<peliculaserie> peliculaserie;

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	public List<peliculaserie> getPeliculaserie() {
		return peliculaserie;
	}

	public void setPeliculaserie(List<peliculaserie> peliculaserie) {
		this.peliculaserie = peliculaserie;
	}

	@Override
	public String toString() {
		return "genero [id=" + id + ", nombre=" + nombre + ", imagen=" + imagen + ", peliculaserie=" + peliculaserie
				+ ", getId()=" + getId() + ", getNombre()=" + getNombre() + ", getImagen()=" + getImagen()
				+ ", getPeliculaserie()=" + getPeliculaserie() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}


	

}
