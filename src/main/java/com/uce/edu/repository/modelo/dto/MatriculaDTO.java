package com.uce.edu.repository.modelo.dto;

import java.time.LocalDate;

public class MatriculaDTO {
	
	private String cedula;
	private String codigo;
	private LocalDate fechaDeMatricula;
	private String nombreHilo;

	public MatriculaDTO() {
		super();
	}

	
	public MatriculaDTO(String cedula, String codigo, LocalDate fechaDeMatricula, String nombreHilo) {
		super();
		this.cedula = cedula;
		this.codigo = codigo;
		this.fechaDeMatricula = fechaDeMatricula;
		this.nombreHilo = nombreHilo;
	}


	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public LocalDate getFechaDeMatricula() {
		return fechaDeMatricula;
	}

	public void setFechaDeMatricula(LocalDate fechaDeMatricula) {
		this.fechaDeMatricula = fechaDeMatricula;
	}

	public String getNombreHilo() {
		return nombreHilo;
	}

	public void setNombreHilo(String nombreHilo) {
		this.nombreHilo = nombreHilo;
	}

	@Override
	public String toString() {
		return "MatriculaDTO [cedula=" + cedula + ", codigo=" + codigo + ", fechaDeMatricula=" + fechaDeMatricula
				+ ", nombreHilo=" + nombreHilo + "]";
	}

	

}
