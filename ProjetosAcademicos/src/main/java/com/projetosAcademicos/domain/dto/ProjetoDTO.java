package com.projetosAcademicos.domain.dto;

import com.projetosAcademicos.domain.Aluno;
import com.projetosAcademicos.domain.Professor;
import lombok.Data;

@Data
public class ProjetoDTO {

    private Long id;
    private String titulo;
    private Professor professorResponsavel;
    private Aluno aluno;
    private String areaProjeto;
    private String resumo;
    private String palavraChave1;
    private String palavraChave2;
    private String palavraChave3;
    private String urlDocumento;

    public ProjetoDTO(Long id, String titulo, Professor professorResponsavel, Aluno aluno, String areaProjeto, String resumo, String palavraChave1, String palavraChave2, String palavraChave3, String urlDocumento) {
        this.id = id;
        this.titulo = titulo;
        this.professorResponsavel = professorResponsavel;
        this.aluno = aluno;
        this.areaProjeto = areaProjeto;
        this.resumo = resumo;
        this.palavraChave1 = palavraChave1;
        this.palavraChave2 = palavraChave2;
        this.palavraChave3 = palavraChave3;
        this.urlDocumento = urlDocumento;
    }
}
