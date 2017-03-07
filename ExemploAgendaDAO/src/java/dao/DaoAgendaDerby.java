/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Pessoa;

/**
 *
 * @author ManoelNeto
 */
public class DaoAgendaDerby implements DAOAgenda{

    @Override
    public boolean inserir(Pessoa pessoa) throws Exception {
        
        Connection conn=ConexaoAgendaDerby.getInstance().getConexao();
        PreparedStatement pst=conn.prepareStatement("insert into MANOEL.TELEFONE (NOME,NUMERO,OPERADORA) values (?,?,?)");
        pst.setString(1, pessoa.getNome());
        pst.setString(2, pessoa.getNumero());
        pst.setString(3, pessoa.getOperadora());
        pst.executeUpdate();
        pst.close();
        return true;
    }

    @Override
    public boolean remover(Pessoa pessoa) throws Exception {
        Connection conn=ConexaoAgendaDerby.getInstance().getConexao();
        PreparedStatement pst=conn.prepareStatement("delete from MANOEL.TELEFONE where NOME=? and NUMERO=? and OPERADORA=? ");
        pst.setString(1, pessoa.getNome());
        pst.setString(2, pessoa.getNumero());
        pst.setString(3, pessoa.getOperadora());
        pst.executeUpdate();
        pst.close();
        
        return true;
    }

    @Override
    public Pessoa atualizar(Pessoa pessoa, Pessoa nova) throws Exception {
        Connection conn=ConexaoAgendaDerby.getInstance().getConexao();
        PreparedStatement pst=conn.prepareStatement("update MANOEL.TELEFONE set NOME=?, NUMERO=?, OPERADORA=? where NOME=? and NUMERO=? and OPERADORA=?");
        pst.setString(1, nova.getNome());
        pst.setString(2, nova.getNumero());
        pst.setString(3, nova.getOperadora());
        
        pst.setString(4, pessoa.getNome());
        pst.setString(5, pessoa.getNumero());
        pst.setString(6, pessoa.getOperadora());
        pst.executeUpdate();
        pst.close();
        
        return nova;
    
    }

    @Override
    public List<Pessoa> buscar(Pessoa pessoa) throws Exception {
        Connection conn=ConexaoAgendaDerby.getInstance().getConexao();
        PreparedStatement pst=conn.prepareStatement("select * from MANOEL.TELEFONE where NOME=? and NUMERO=? and OPERADORA=? ");
        pst.setString(1, pessoa.getNome());
        pst.setString(2, pessoa.getNumero());
        pst.setString(3, pessoa.getOperadora());
        ResultSet rs=pst.executeQuery();
        
        List<Pessoa> lista=new ArrayList<Pessoa>();
        while(rs.next()){
            Pessoa temp=new Pessoa();
            temp.setNome(rs.getString("NOME"));
            temp.setNumero(rs.getString("NUMERO"));
            temp.setOperadora(rs.getString("OPERADORA"));
  
            lista.add(temp);
        }
        
        return lista;
    }

    @Override
    public List<Pessoa> listar() throws Exception {
Connection conn=ConexaoAgendaDerby.getInstance().getConexao();
        PreparedStatement pst=conn.prepareStatement("select * from MANOEL.TELEFONE");
       
        ResultSet rs=pst.executeQuery();
        
        List<Pessoa> lista=new ArrayList<Pessoa>();
        while(rs.next()){
            Pessoa temp=new Pessoa();
            temp.setNome(rs.getString("NOME"));
            temp.setNumero(rs.getString("NUMERO"));
            temp.setOperadora(rs.getString("OPERADORA"));
  
            lista.add(temp);
        }
        
        return lista;
    }
    
}
