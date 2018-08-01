/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
    public List buscarPessoas(Pessoa pessoa) {
        
        ArrayList lista=new ArrayList();
        Statement st;
       
        try {
            st = this.conn.createStatement();
            ResultSet rs = st.executeQuery("Select * from SA.PESSOAS where nome like '%"+pessoa.getNome()+"%'");
            while(rs.next()){
                Pessoa p = new Pessoa();
                p.setCpf(rs.getString("cpf"));
                p.setNome(rs.getString("nome"));
                p.setTelefone(rs.getString("telefone"));
                lista.add(p);
            }
            
           
        } catch (SQLException ex) {
            Logger.getLogger(DaoPessoaDerby.class.getName()).log(Level.SEVERE, null, ex);
           
        }
        return lista;
        
        
        
    }

    @Override
    public Pessoa getPessoa(String cpf) {
        
     Statement st;
      Pessoa p = new Pessoa(); 
        try {
            st = this.conn.createStatement();
            ResultSet rs = st.executeQuery("Select * from SA.PESSOAS where  cpf= '"+cpf+"'");
            while(rs.next()){          
                p.setCpf(rs.getString("cpf"));
                p.setNome(rs.getString("nome"));
                p.setTelefone(rs.getString("telefone"));
            }   
        } catch (SQLException ex) {
            Logger.getLogger(DaoPessoaDerby.class.getName()).log(Level.SEVERE, null, ex);
           
        }
        return p;
    }
    
}
