package com.projetosAcademicos.domain;

import com.projetosAcademicos.domain.Professor;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "projeto")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Projeto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo")
    private String titulo;

    @NotNull()
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "fk_aluno_id", foreignKey = @ForeignKey(name = "fk_aluno"), referencedColumnName = "id")
    private Aluno aluno;

    @NotNull()
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "fk_professor_id", foreignKey = @ForeignKey(name = "fk_professor"), referencedColumnName = "id")
    private Professor professorResponsavel;

    @Column(name = "area_projeto")
    private String areaProjeto;

    @Column(name = "resumo")
    private String resumo;

    @Column(name = "palavra_chave1")
    private String palavraChave1;

    @Column(name = "palavra_chave2")
    private String palavraChave2;

    @Column(name = "palvra_chave3")
    private String palavraChave3;

    @Column(name = "url_documento")
    private String urlDocumento;


}
