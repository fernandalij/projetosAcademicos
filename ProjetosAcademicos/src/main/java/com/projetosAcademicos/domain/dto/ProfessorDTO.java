package com.projetosAcademicos.domain.dto;

import com.projetosAcademicos.domain.Endereco;
import lombok.Data;

@Data
public class ProfessorDTO {

    private Long id;
    private String matricula;
    private String nome;
    private String curso;
    private Endereco endereco;

    public ProfessorDTO(Long id, String matricula, String nome, String curso, Endereco endereco) {
        this.id = id;
        this.matricula = matricula;
        this.nome = nome;
        this.curso = curso;
        this.endereco = endereco;
    }
}
