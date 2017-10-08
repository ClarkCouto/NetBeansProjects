/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.sgpp.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class Bolsa implements Serializable{
    private static final long serialVersionUID = 5953225846505938118L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable=false, unique=true)
    private Integer idBolsa;
    
    @OneToOne
    private Pessoa alteradoPor;
    
    @OneToMany(mappedBy = "bolsa")
    private List<Aluno> alunos;

    @Column(nullable=false)
    private Boolean ativo;
    
    @ManyToOne
    private CategoriaBolsa categoriaBolsa;
   
    @Column(nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCadastro;
    
    @Column(nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataUltimaAlteracao;
    
    @Column(nullable=false, length=50)
    private String nome;
    
    @ManyToOne
    private Edital edital;

    public Bolsa() {
    }

    public Bolsa(Integer idBolsa, Pessoa alteradoPor, List<Aluno> alunos, Boolean ativo, CategoriaBolsa categoriaBolsa, Date dataCadastro, Date dataUltimaAlteracao, String nome, Edital edital) {
        this.idBolsa = idBolsa;
        this.alteradoPor = alteradoPor;
        this.alunos = alunos;
        this.ativo = ativo;
        this.categoriaBolsa = categoriaBolsa;
        this.dataCadastro = dataCadastro;
        this.dataUltimaAlteracao = dataUltimaAlteracao;
        this.nome = nome;
        this.edital = edital;
    }

    public Integer getIdBolsa() {
        return idBolsa;
    }

    public void setIdBolsa(Integer idBolsa) {
        this.idBolsa = idBolsa;
    }

    public Pessoa getAlteradoPor() {
        return alteradoPor;
    }

    public void setAlteradoPor(Pessoa alteradoPor) {
        this.alteradoPor = alteradoPor;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public CategoriaBolsa getCategoriaBolsa() {
        return categoriaBolsa;
    }

    public void setCategoriaBolsa(CategoriaBolsa categoriaBolsa) {
        this.categoriaBolsa = categoriaBolsa;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Date getDataUltimaAlteracao() {
        return dataUltimaAlteracao;
    }

    public void setDataUltimaAlteracao(Date dataUltimaAlteracao) {
        this.dataUltimaAlteracao = dataUltimaAlteracao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Edital getEdital() {
        return edital;
    }

    public void setEdital(Edital edital) {
        this.edital = edital;
    }

}
