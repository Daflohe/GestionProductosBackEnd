package com.gestion.productos.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "producto")
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "nombre", length = 50, nullable = false)
	private String nombre;

	@Column(name = "estado", length = 15, nullable = false)
	private String estado;

	@Column(name = "elaborado", length = 7, nullable = false)
	private String elaborado;

	public Producto() {

	}

	public Producto(int id, String nombre, String estado, String elaborado) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.estado = estado;
		this.elaborado = elaborado;
	}

	public long getId() {
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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getElaborado() {
		return elaborado;
	}

	public void setElaborado(String elaborado) {
		this.elaborado = elaborado;
	}

}
