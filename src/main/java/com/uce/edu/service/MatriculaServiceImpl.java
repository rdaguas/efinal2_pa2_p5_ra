package com.uce.edu.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.uce.edu.repository.IEstudianteRepository;
import com.uce.edu.repository.IMateriaRepository;
import com.uce.edu.repository.IMatriculaRepository;
import com.uce.edu.repository.modelo.Estudiante;
import com.uce.edu.repository.modelo.Materia;
import com.uce.edu.repository.modelo.Matricula;
import com.uce.edu.repository.modelo.dto.MatriculaDTO;
import com.uce.edu.service.to.MatriculaTO;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class MatriculaServiceImpl implements IMatriculaService {

	@Autowired
	private IMatriculaRepository matriculaRepository;

	@Autowired
	private IEstudianteRepository estudianteRepository;

	@Autowired
	private IMateriaRepository materiaRepository;

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public List<MatriculaDTO> reporteFinal() {
		return this.matriculaRepository.seleccionarTodosEficiente();
	}

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void matriEnParalelo(MatriculaTO matriculaTO) {
		System.out.println(TransactionSynchronizationManager.isActualTransactionActive());

		Matricula mat1 = new Matricula();
		mat1.setFechaDeMatricula(LocalDate.now());
		Materia mate1 = new Materia();
		mate1.setCodigo(matriculaTO.getCodigoMateria1());
		mat1.setMateria(mate1);

		Matricula mat2 = new Matricula();
		mat2.setFechaDeMatricula(LocalDate.now());
		Materia mate2 = new Materia();
		mate2.setCodigo(matriculaTO.getCodigoMateria2());
		mat2.setMateria(mate2);

		Matricula mat3 = new Matricula();
		mat3.setFechaDeMatricula(LocalDate.now());
		Materia mate3 = new Materia();
		mate3.setCodigo(matriculaTO.getCodigoMateria3());
		mat3.setMateria(mate3);

		Matricula mat4 = new Matricula();
		Materia mate4 = new Materia();
		mate4.setCodigo(matriculaTO.getCodigoMateria4());
		mat4.setMateria(mate4);

		List<Matricula> matriculas = new ArrayList<>();

		matriculas.add(mat1);
		matriculas.add(mat2);
		matriculas.add(mat3);
		matriculas.add(mat4);

		matriculas.parallelStream().forEach(matricula -> {
			String hilo = Thread.currentThread().getName();
			matricula.setNombreHilo(hilo);
			this.matriConCedulaCodigo(matriculaTO.getCedulaEstudiante(), matricula.getMateria().getCodigo(), matricula);

		});
	}

	@Override
	public void matriConCedulaCodigo(String cedula, String codigo, Matricula matricula) {
		System.out.println(codigo + TransactionSynchronizationManager.isActualTransactionActive());

		Estudiante estudiante = this.estudianteRepository.seleccionarPorCedula(cedula);
		Materia materia = this.materiaRepository.seleccionarPorCodigo(codigo);

		matricula.setEstudiante(estudiante);
		matricula.setMateria(materia);
		matricula.setFechaDeMatricula(LocalDate.now());
		this.matriculaRepository.insertar(matricula);

	}

}
