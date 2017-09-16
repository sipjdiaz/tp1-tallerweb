package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Farmacia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idFarmacia")
	private Long id;
	
	private String nombre;
	private String telefono;
	private String diaDeTurno;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idDireccion")
	private Direccion direccion;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idPunto")
	private Punto punto;
	
	public Farmacia(String nombre, String telefono, String diaDeTurno, Direccion direccion, Punto punto)
	{
		this.nombre = nombre;
		this.telefono = telefono;
		this.diaDeTurno = diaDeTurno;
		this.direccion = direccion;
		this.punto = punto;
	}
	
	public Farmacia()
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

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDiaDeTurno() {
		return diaDeTurno;
	}

	public void setDiaDeTurno(String diaDeTurno) {
		this.diaDeTurno = diaDeTurno;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public Punto getPunto() {
		return punto;
	}

	public void setPunto(Punto punto) {
		this.punto = punto;
	}
	
}
