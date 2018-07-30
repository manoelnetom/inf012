/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Pessoa;

/**
 *
 * @author aluno
 */
public class DaoPessoaDerby implements DAOPessoa{

    private Connection conn;
    
    public DaoPessoaDerby() {
        try {
            this.conn = ConexaoDerby.getInstancia().getConn();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoPessoaDerby.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DaoPessoaDerby.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    

    @Override
    public String addPessoas(Pessoa pessoa) {
        Statement st;
        String resultado="";
        try {
            st = this.conn.createStatement();
            st.executeUpdate("insert into SA.PESSOAS values ('"+pessoa.getCpf()+"','"+pessoa.getNome()+"','"+pessoa.getTelefone()+"')");
            resultado="Pessoa add com sucesso";
        } catch (SQLException ex) {
            Logger.getLogger(DaoPessoaDerby.class.getName()).log(Level.SEVERE, null, ex);
            resultado="Erro ao add pessoa";
        }
        return resultado;
    }

    @Override
    public List buscarPessoas(Pessoa pessoa) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
