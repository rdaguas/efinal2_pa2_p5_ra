package com.uce.edu.repository.modelo;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "materia")
public class Materia {

	@Id
    @SequenceGenerator(name = "seq_materia", sequenceName = "seq_materia", allocationSize = 1)
    @GeneratedValue(generator = "seq_materia", strategy = GenerationType.SEQUENCE)
    @Column(name = "mate_id")
    private Integer id;
    @Column(name = "mate_nombre")
    private String nombre;
    @Column(name = "mate_codigo")
    private String codigo;
    @Column(name = "mate_numero_de_creditos")
    private Integer numeroDeCreditos;
    @Column(name = "mate_cedula_profesor")
    private String cedulaDeProfesor;

    @OneToMany(mappedBy = "materia", fetch = FetchType.LAZY)
    private List<Matricula> matriculas;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Integer getNumeroDeCreditos() {
		return numeroDeCreditos;
	}

	public void setNumeroDeCreditos(Integer numeroDeCreditos) {
		this.numeroDeCreditos = numeroDeCreditos;
	}

	public String getCedulaDeProfesor() {
		return cedulaDeProfesor;
	}

	public void setCedulaDeProfesor(String cedulaDeProfesor) {
		this.cedulaDeProfesor = cedulaDeProfesor;
	}

	public List<Matricula> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(List<Matricula> matriculas) {
		this.matriculas = matriculas;
	}

	@Override
	public String toString() {
		return "Materia [id=" + id + ", nombre=" + nombre + ", codigo=" + codigo + ", numeroDeCreditos="
				+ numeroDeCreditos + ", cedulaDeProfesor=" + cedulaDeProfesor + "]";
	}
    
    
}
