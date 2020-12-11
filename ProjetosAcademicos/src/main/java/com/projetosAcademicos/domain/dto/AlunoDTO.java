package com.projetosAcademicos.domain.dto;

import com.projetosAcademicos.domain.Aluno;
import com.projetosAcademicos.domain.Endereco;

import lombok.Data;

@Data
public class AlunoDTO {
	
	private Long id;
	private String nome;
	private String matricula;
	private String cpf;
	private String curso;
	private Endereco endereco;
	
	public AlunoDTO(Aluno c) {
		this.id = c.getId();
		this.matricula = c.getMatricula();
		this.nome = c.getNome();
		this.cpf = c.getCpf();
		this.curso = c.getCurso();
		this.endereco = c.getEndereco();
	}
}
