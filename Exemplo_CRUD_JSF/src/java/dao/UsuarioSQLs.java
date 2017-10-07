/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author Silvia Bertagnolli
 */
public enum UsuarioSQLs {
    INSERIR("insert into usuario(nome, identificador, senha) values (?, ?, ?)"), 
    LISTAR_TODOS("select * from usuario"),
    VALIDAR("select nome from usuario where identificador = ? AND senha = ?"),
    REMOVER("delete from usuario where nome=? AND identificador=?"),
    ATUALIZAR("update usuario set nome=?, senha=? where identificador=?");
        
    private final String sql;
    UsuarioSQLs(String sql){
        this.sql = sql; 
    
    }

    public String getSql() {
        return sql;
    }    
}

