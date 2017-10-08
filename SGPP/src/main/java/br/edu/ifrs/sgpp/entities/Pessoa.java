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
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
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
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(name = "tipo")
public class Pessoa implements Serializable{
    private static final Long serialVersionUID = 5953225846505938118L;
    
    public static enum Sexo {
        Masculino, Feminino
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(nullable=false, unique=true)
    private Long idPessoa;
    
    @OneToOne
    private Pessoa alteradoPor;

    @Column(nullable=false)
    private Boolean ativo;
    
    @Column(nullable=false, unique=true)
    private Long cpf; 
   
    @Column(nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCadastro;
    
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataNascimento;
    
    @Column(nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataUltimaAlteracao;
    
    @OneToMany(mappedBy = "destinatario")
    private Collection<Declaracao> destinatarioDeclaracoes;
    
    @Column(nullable=false, columnDefinition = "text", length = 50)
    private String email;
    
    @ManyToOne
    private Instituicao instituicao;
    
    @Column(nullable=false, columnDefinition = "text", length = 50)
    private String nome;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable=false)
    private Sexo sexo;
    
    @Column(nullable=true, columnDefinition = "text", length = 10)
    private String telefoneFixo;
    
    @Column(nullable=true, columnDefinition = "text", length = 11)
    private String telefoneCelular;

    public Pessoa() {
    }

    public Pessoa(Long idPessoa, Pessoa alteradoPor, Boolean ativo, Long cpf, Date dataCadastro, Date dataNascimento, Date dataUltimaAlteracao, Collection<Declaracao> destinatarioDeclaracoes, String email, Instituicao instituicao, String nome, Sexo sexo, String telefoneFixo, String telefoneCelular) {
        this.idPessoa = idPessoa;
        this.alteradoPor = alteradoPor;
        this.ativo = ativo;
        this.cpf = cpf;
        this.dataCadastro = dataCadastro;
        this.dataNascimento = dataNascimento;
        this.dataUltimaAlteracao = dataUltimaAlteracao;
        this.destinatarioDeclaracoes = destinatarioDeclaracoes;
        this.email = email;
        this.instituicao = instituicao;
        this.nome = nome;
        this.sexo = sexo;
        this.telefoneFixo = telefoneFixo;
        this.telefoneCelular = telefoneCelular;
    }
    
    public Long getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Long idPessoa) {
        this.idPessoa = idPessoa;
    }

    public Pessoa getAlteradoPor() {
        return alteradoPor;
    }

    public void setAlteradoPor(Pessoa alteradoPor) {
        this.alteradoPor = alteradoPor;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Date getDataUltimaAlteracao() {
        return dataUltimaAlteracao;
    }

    public void setDataUltimaAlteracao(Date dataUltimaAlteracao) {
        this.dataUltimaAlteracao = dataUltimaAlteracao;
    }

    public Collection<Declaracao> getDestinatarioDeclaracoes() {
        return destinatarioDeclaracoes;
    }

    public void setDestinatarioDeclaracoes(Collection<Declaracao> destinatarioDeclaracoes) {
        this.destinatarioDeclaracoes = destinatarioDeclaracoes;
    }
  
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Instituicao getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(Instituicao instituicao) {
        this.instituicao = instituicao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public String getTelefoneFixo() {
        return telefoneFixo;
    }

    public void setTelefoneFixo(String telefoneFixo) {
        this.telefoneFixo = telefoneFixo;
    }

    public String getTelefoneCelular() {
        return telefoneCelular;
    }

    public void setTelefoneCelular(String telefoneCelular) {
        this.telefoneCelular = telefoneCelular;
    }

}
