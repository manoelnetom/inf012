/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import model.Usuario;

/**
 *
 * @author ManoelNeto
 */
public interface DAOUsuario {
    
    public boolean Logar(Usuario usuario) throws Exception;
    
    
}
