package com.uce.edu.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Matricula;
import com.uce.edu.repository.modelo.dto.MatriculaDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Transactional
@Repository
public class MatriculaRepositoryImpl implements IMatriculaRepository {

	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public List<MatriculaDTO> seleccionarTodosEficiente() {
		// TODO Auto-generated method stub
		TypedQuery<MatriculaDTO> myQuery = this.entityManager.createQuery("SELECT new com.uce.edu.repository.modelo.dto.MatriculaDTO(m.estudiante.cedula,m.materia.codigo,m.fechaDeMatricula,m.nombreHilo)From Matricula m", MatriculaDTO.class);

		return myQuery.getResultList();
	}

	@Override
	public void insertar(Matricula matricula) {
		// TODO Auto-generated method stub
		this.entityManager.persist(matricula);
	}

}
