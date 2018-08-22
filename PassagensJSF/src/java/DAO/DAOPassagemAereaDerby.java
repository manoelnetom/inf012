/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.PassagemAerea;

/**
 *
 * @author aluno
 */
public class DAOPassagemAereaDerby implements DAOPassagemAerea{

    @Override
    public void addPassagem(PassagemAerea passgem) throws Exception {
      
        PreparedStatement pstm = ConexaoDerby.getInstancia().getConnection().prepareStatement("INSERT INTO SA.PASSAGENS(nome,origem,destino,valor) values (?,?,?,?)");
        pstm.setString(1, passgem.getNome());
        pstm.setString(2, passgem.getOrigem());
        pstm.setString(3, passgem.getDestino());
        pstm.setDouble(4, passgem.getValor());
        
        pstm.executeUpdate();
        
    }

    @Override
    public ArrayList<PassagemAerea> listaPassgens() throws Exception {
    
        ArrayList<PassagemAerea> lista= new ArrayList<>();
        PreparedStatement pstm = ConexaoDerby.getInstancia().getConnection().prepareStatement("SELECT * FROM SA.PASSAGENS");
        ResultSet rs =pstm.executeQuery();
        while (rs.next()) {
            PassagemAerea passagem=new PassagemAerea();
            passagem.setNome(rs.getString("nome"));
            passagem.setOrigem(rs.getString("origem"));
            passagem.setDestino(rs.getString("destino"));
            passagem.setValor(rs.getDouble("valor"));
            
            lista.add(passagem);
            
        }
        
        return lista;
    }
    
}
