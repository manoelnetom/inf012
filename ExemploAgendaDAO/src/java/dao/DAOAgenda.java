/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.util.List;
import model.Pessoa;

/**
 *
 * @author ManoelNeto
 */
public interface DAOAgenda {
    
    public boolean inserir(Pessoa pessoa) throws Exception;
    public boolean remover(Pessoa pessoa) throws Exception;
    public Pessoa atualizar(Pessoa pessoa, Pessoa nova) throws Exception;
    public List<Pessoa> buscar(Pessoa pessoa) throws Exception;
    public List<Pessoa> listar() throws Exception;  
}
