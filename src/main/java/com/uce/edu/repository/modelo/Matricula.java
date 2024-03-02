package com.uce.edu.repository.modelo;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "matricula")
public class Matricula {
	
	@Id
    @SequenceGenerator(name = "seq_matricula", sequenceName = "seq_matricula", allocationSize = 1)
    @GeneratedValue(generator = "seq_matricula", strategy = GenerationType.SEQUENCE)
    @Column(name = "matr_id")
    private Integer id;
    @Column(name = "matr_fecha_de_matricula")
    private LocalDate fechaDeMatricula;
    @Column(name = "matr_nombre_hilo")
    private String nombreHilo;

    @ManyToOne
    @JoinColumn(name = "matr_id_materia")
    private Materia materia;

    @ManyToOne
    @JoinColumn(name = "matr_id_estudiante")
    private Estudiante estudiante;

    //set y get
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	@Override
	public String toString() {
		return "Matricula [id=" + id + ", fechaDeMatricula=" + fechaDeMatricula + ", nombreHilo=" + nombreHilo + "]";
	}

    

    
    

}
