/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.sgpp.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 *
 * @author CristianoSilva
 */
@Entity
@DiscriminatorValue(value="aluno")
public class Aluno extends Pessoa implements Serializable{
    private static final Long serialVersionUID = 5953225846505938118L;
    
    @Column(nullable=false)
    private Boolean bolsista;
    
    @ManyToOne
    private Bolsa bolsa;
    
    @ManyToOne
    private Curso curso;
    
    @ManyToMany(mappedBy = "voluntarios")
    private Collection<Projeto> projeto_voluntario;
    
    @ManyToMany(mappedBy = "bolsistas")
    private Collection<Projeto> projeto_bolsista;

    public Aluno() {
        super();
    }

    public Aluno(Boolean bolsista, Bolsa bolsa, Curso curso, Collection<Projeto> projeto_voluntario, Collection<Projeto> projeto_bolsista, Long idPessoa, Pessoa alteradoPor, Boolean ativo, Long cpf, Date dataCadastro, Date dataNascimento, Date dataUltimaAlteracao, Collection<Declaracao> destinatarioDeclaracoes, String email, Instituicao instituicao, String nome, Sexo sexo, String telefoneFixo, String telefoneCelular) {
        super(idPessoa, alteradoPor, ativo, cpf, dataCadastro, dataNascimento, dataUltimaAlteracao, destinatarioDeclaracoes, email, instituicao, nome, sexo, telefoneFixo, telefoneCelular);
        this.bolsista = bolsista;
        this.bolsa = bolsa;
        this.curso = curso;
        this.projeto_voluntario = projeto_voluntario;
        this.projeto_bolsista = projeto_bolsista;
    }

    public Boolean getBolsista() {
        return bolsista;
    }

    public void setBolsista(Boolean bolsista) {
        this.bolsista = bolsista;
    }

    public Bolsa getBolsa() {
        return bolsa;
    }

    public void setBolsa(Bolsa bolsa) {
        this.bolsa = bolsa;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Collection<Projeto> getProjeto_voluntario() {
        return projeto_voluntario;
    }

    public void setProjeto_voluntario(Collection<Projeto> projeto_voluntario) {
        this.projeto_voluntario = projeto_voluntario;
    }

    public Collection<Projeto> getProjeto_bolsista() {
        return projeto_bolsista;
    }

    public void setProjeto_bolsista(Collection<Projeto> projeto_bolsista) {
        this.projeto_bolsista = projeto_bolsista;
    }

}
