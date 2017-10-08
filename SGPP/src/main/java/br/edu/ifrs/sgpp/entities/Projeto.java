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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author CristianoSilva
 */
@Entity
public class Projeto implements Serializable{
    private static final Long serialVersionUID = 5953225846505938118L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable=false, unique=true)
    private Long idProjeto;
    
    @Column(nullable=false)
    private Boolean aipct;
    
    @OneToOne
    private Pessoa alteradoPor;
    
    @Column(nullable=false)
    private Integer ano;

    @Column(nullable=false)
    private Boolean ativo;
    
    @ManyToMany
    private Collection<Aluno> bolsistas;
    
    @OneToMany(mappedBy = "projeto")
    private Collection<Colaborador> colaboradores;
    
    @ManyToOne
    private Coordenador coordenador;
   
    @Column(nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCadastro;
    
    @Column(nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataInicio;
    
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataFim;
    
    @Column(nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataUltimaAlteracao;
    
    @OneToMany(mappedBy = "projeto")
    private Collection<Declaracao> declaracoes;
    
    @OneToMany(mappedBy = "projeto")
    private Collection<Documento> documentos;
    
    @ManyToOne
    private Edital edital;
    
    @Column(nullable=false, length=100)
    private String titulo;
    
    @ManyToMany
    private Collection<Aluno> voluntarios;

    public Projeto() {
    }

    public Projeto(Long idProjeto, Boolean aipct, Pessoa alteradoPor, Integer ano, Boolean ativo, Collection<Aluno> bolsistas, Collection<Colaborador> colaboradores, Coordenador coordenador, Date dataCadastro, Date dataInicio, Date dataFim, Date dataUltimaAlteracao, Collection<Declaracao> declaracoes, Collection<Documento> documentos, Edital edital, String titulo, Collection<Aluno> voluntarios) {
        this.idProjeto = idProjeto;
        this.aipct = aipct;
        this.alteradoPor = alteradoPor;
        this.ano = ano;
        this.ativo = ativo;
        this.bolsistas = bolsistas;
        this.colaboradores = colaboradores;
        this.coordenador = coordenador;
        this.dataCadastro = dataCadastro;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.dataUltimaAlteracao = dataUltimaAlteracao;
        this.declaracoes = declaracoes;
        this.documentos = documentos;
        this.edital = edital;
        this.titulo = titulo;
        this.voluntarios = voluntarios;
    }

    public Long getIdProjeto() {
        return idProjeto;
    }

    public void setIdProjeto(Long idProjeto) {
        this.idProjeto = idProjeto;
    }

    public Boolean getAipct() {
        return aipct;
    }

    public void setAipct(Boolean aipct) {
        this.aipct = aipct;
    }

    public Pessoa getAlteradoPor() {
        return alteradoPor;
    }

    public void setAlteradoPor(Pessoa alteradoPor) {
        this.alteradoPor = alteradoPor;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Collection<Aluno> getBolsistas() {
        return bolsistas;
    }

    public void setBolsistas(Collection<Aluno> bolsistas) {
        this.bolsistas = bolsistas;
    }

    public Collection<Colaborador> getColaboradores() {
        return colaboradores;
    }

    public void setColaboradores(Collection<Colaborador> colaboradores) {
        this.colaboradores = colaboradores;
    }

    public Coordenador getCoordenador() {
        return coordenador;
    }

    public void setCoordenador(Coordenador coordenador) {
        this.coordenador = coordenador;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public Date getDataUltimaAlteracao() {
        return dataUltimaAlteracao;
    }

    public void setDataUltimaAlteracao(Date dataUltimaAlteracao) {
        this.dataUltimaAlteracao = dataUltimaAlteracao;
    }

    public Collection<Declaracao> getDeclaracoes() {
        return declaracoes;
    }

    public void setDeclaracoes(Collection<Declaracao> declaracoes) {
        this.declaracoes = declaracoes;
    }

    public Collection<Documento> getDocumentos() {
        return documentos;
    }

    public void setDocumentos(Collection<Documento> documentos) {
        this.documentos = documentos;
    }

    public Edital getEdital() {
        return edital;
    }

    public void setEdital(Edital edital) {
        this.edital = edital;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Collection<Aluno> getVoluntarios() {
        return voluntarios;
    }

    public void setVoluntarios(Collection<Aluno> voluntarios) {
        this.voluntarios = voluntarios;
    }

}
