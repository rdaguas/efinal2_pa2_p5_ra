package com.uce.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uce.edu.repository.modelo.Estudiante;
import com.uce.edu.service.IEstudianteService;

@Controller
@RequestMapping(value = "/estudiantes")
public class EstudianteController {

	@Autowired
	private IEstudianteService estudianteService;

	@GetMapping(value = "/vistaRegistro")
	public String vistaRegistro(Estudiante estudiante) {
		return "vistaInsertarEstudiante";
	}

	@PostMapping(value = "/crear")
	public String crear(Estudiante estudiante) {
		this.estudianteService.guardar(estudiante);
		return "redirect:/estudiantes/vistaRegistro";
	}
}
