package net.alkemi.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="personaje")

public class personaje {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@JsonProperty("id")
	private int id;
	@JsonProperty("imagen")
	private String imagen;
	@JsonProperty("nombre")
	private String nombre;
	@JsonProperty("edad")
	private int edad;
	@JsonProperty("historia")
	private String historia;
	@JsonProperty("peso")
	private Double peso;
	
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="personaje_peliculaserie",joinColumns = @JoinColumn(name="idpersonaje",referencedColumnName = "id"),inverseJoinColumns = @JoinColumn(name="idpeliculaserie",referencedColumnName = "id"))
	@JsonProperty("personaje_seriepelicula")
	private List<peliculaserie> peliculaserie;


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


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getEdad() {
		return edad;
	}


	public void setEdad(int edad) {
		this.edad = edad;
	}


	public String getHistoria() {
		return historia;
	}


	public void setHistoria(String historia) {
		this.historia = historia;
	}


	public Double getPeso() {
		return peso;
	}


	public void setPeso(Double peso) {
		this.peso = peso;
	}


	public List<peliculaserie> getPeliculaserie() {
		return peliculaserie;
	}


	public void setPeliculaserie(List<peliculaserie> peliculaserie) {
		this.peliculaserie = peliculaserie;
	}


	@Override
	public String toString() {
		return "personaje [id=" + id + ", imagen=" + imagen + ", nombre=" + nombre + ", edad=" + edad + ", historia="
				+ historia + ", peso=" + peso + ", peliculaserie=" + peliculaserie + ", getId()=" + getId()
				+ ", getImagen()=" + getImagen() + ", getNombre()=" + getNombre() + ", getEdad()=" + getEdad()
				+ ", getHistoria()=" + getHistoria() + ", getPeso()=" + getPeso() + ", getPeliculaserie()="
				+ getPeliculaserie() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}


	
}
