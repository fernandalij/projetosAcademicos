package com.projetosAcademicos.domain.repository;

import com.projetosAcademicos.domain.Aluno;
import com.projetosAcademicos.domain.Professor;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Long>{
	List<Professor> findByMatricula(String matricula);
}
