/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.util.LinkedList;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author CristianoSilva
 */
@ManagedBean
@ViewScoped
 public class UsuarioBean implements Serializable{
    private Usuario usuarioLogado = new Usuario();
    private Usuario usuario = new Usuario();
    private LinkedList<Usuario> usuarios = new LinkedList();
    private boolean editando;

    private Usuario usuarioSelecionado;
    @PostConstruct
    public void init(){
            usuarios.add(new Usuario(1,"Admin", "012345678910", "admin"));
            usuarios.add(new Usuario(2, "Cristiano", "01598825089", "123"));
            usuarios.add(new Usuario(3, "Matheus", "034.527.460-11", "456"));
    }
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    public void setUsuarioLogado(Usuario usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }

    public LinkedList<Usuario> getUsuarios() {
        if (usuarios == null) {
            this.usuarios = new LinkedList<>();
        }
        return usuarios;
    }

    public boolean isEditando() {
        return editando;
    }

    public void setEditando(boolean editando) {
        this.editando = editando;
    }

    public String salvar() {
        if (!isEditando()) {
            usuarios.add(new Usuario(usuario.getIdUsuario(), null, usuario.getIdentificador(), usuario.getSenha()));
        }
        this.usuario = new Usuario();
        setEditando(false);
        return "Listar";
    }

    public String excluir(Usuario user) {
        usuarios.remove(user);
        setEditando(false);
        return "Listar";
    }

    public String editar(Usuario user) {
        this.usuario = user;
        setEditando(true);
        return "Editar";
    }

    public void limpar() {
        this.usuario = new Usuario();
        setEditando(false);
    }

    public String validar(Usuario usuario) {
        for(Usuario user : usuarios){
            if (user.getIdentificador().equals(usuario.getIdentificador())){
                if(user.getSenha().equals(usuario.getIdentificador())){
                    this.usuarioLogado = usuario;    
                    //usuario = new Usuario();
                    return "index.xhtml";
                }
            }
        }
        return "invalido";
    }

    public Usuario getUsuarioSelecionado() {
        return usuarioSelecionado;
    }

    public void setUsuarioSelecionado(Usuario usuarioSelecionado) {
        this.usuarioSelecionado = usuarioSelecionado;
    }
    
    public void cadastrar(){
        this.usuarios.add(new Usuario(usuario.getIdUsuario(), null, usuario.getIdentificador(), usuario.getSenha()));
    }
    
    public void resetSenha(){
        
    }
    
}
