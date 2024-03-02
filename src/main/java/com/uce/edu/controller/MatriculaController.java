package com.uce.edu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uce.edu.repository.modelo.dto.MatriculaDTO;
import com.uce.edu.service.IMatriculaService;
import com.uce.edu.service.to.MatriculaTO;

@Controller
@RequestMapping(value = "/matriculas")
public class MatriculaController {

	@Autowired
	private IMatriculaService matriculaService;

	@GetMapping(value = "/vistaListaReporte")
	public String vistaReporte(MatriculaDTO matriculaDTO, Model modelo) {
		List<MatriculaDTO> matriculas = this.matriculaService.reporteFinal();
		modelo.addAttribute("lista", matriculas);
		return "vistaListaMatriculas";
	}

	@GetMapping(value = "/vistaMatricula")
	public String vistaMatricula(MatriculaTO matriculaTO) {
		return "vistaInsertarMatriculas";
	}

	@PostMapping(value = "/matricular")
	public String matricular(MatriculaTO matriculaTO) {
		this.matriculaService.matriEnParalelo(matriculaTO);
		return "redirect:/matriculas/vistaMatricula";
	}

}
