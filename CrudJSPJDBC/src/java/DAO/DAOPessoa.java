/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import model.Pessoa;

/**
 *
 * @author aluno
 */
public interface DAOPessoa {
    
    public String addPessoas(Pessoa pessoa) ;
    public List buscarPessoas(Pessoa pessoa) ;
}
