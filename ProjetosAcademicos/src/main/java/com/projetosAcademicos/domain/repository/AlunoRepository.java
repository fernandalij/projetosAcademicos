package com.projetosAcademicos.domain.repository;

import java.util.List;

import com.projetosAcademicos.domain.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long>{

	List<Aluno> findByMatricula(String matricula);
	

}
