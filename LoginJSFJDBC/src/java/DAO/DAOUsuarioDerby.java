/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Usuario;

/**
 *
 * @author ManoelNeto
 */
public class DAOUsuarioDerby implements DAOUsuario{

    @Override
    public boolean Logar(Usuario usuario) throws Exception {
        Connection conn = DerbyDbConnection.getInstancia().getConexao();
        PreparedStatement pst=conn.prepareStatement("select * from SA.USUARIOS where login=? and senha=?");
        pst.setString(1, usuario.getLogin());
        pst.setString(2, usuario.getSenha());
        
        ResultSet rs =pst.executeQuery();
                
        return rs.next();
        
    }
    
}
