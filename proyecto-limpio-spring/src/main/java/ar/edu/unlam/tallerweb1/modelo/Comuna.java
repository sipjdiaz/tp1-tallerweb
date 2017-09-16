package ar.edu.unlam.tallerweb1.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Comuna {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idComuna")
	private Long id;
	
	private String nombre;
	
	@OneToMany(mappedBy = "comuna", cascade = CascadeType.ALL)
	private List<Barrio> barrio = new ArrayList<Barrio>();

	public Comuna(String nombre, List<Barrio> barrio) 
	{
		this.nombre = nombre;
		this.barrio = barrio;
	}
	
	public Comuna()
	{
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Barrio> getBarrio() {
		return barrio;
	}

	public void setBarrio(List<Barrio> barrio) {
		this.barrio = barrio;
	}
	

}
