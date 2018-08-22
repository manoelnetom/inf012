/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import modelo.PassagemAerea;

/**
 *
 * @author aluno
 */
public interface DAOPassagemAerea {
    
    public void addPassagem(PassagemAerea passgem) throws Exception;
    public ArrayList<PassagemAerea> listaPassgens() throws Exception;
    
}
