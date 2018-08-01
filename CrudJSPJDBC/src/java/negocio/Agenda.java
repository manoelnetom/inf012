/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import DAO.DAOPessoa;
import DAO.DaoPessoaDerby;
import java.util.List;
import model.Pessoa;

/**
 *
 * @author aluno
 */
public class Agenda {
    
    private Pessoa local;
    private DAOPessoa dao;
    public Agenda() {
        this.local  = new Pessoa();
        this.dao = new DaoPessoaDerby();
    }
    
    public String addPessoa(){
        return this.dao.addPessoas(local);
    }
    
    public List getPessoas (){
        return dao.buscarPessoas(local);
    }
    
    public String getCpf() {
        return this.local.getCpf();
    }

    public void setCpf(String cpf) {
        this.local.setCpf(cpf);
    }

    public String getNome() {
        return this.local.getNome();
    }

    public void setNome(String nome) {
        this.local.setNome(nome);
    }

    public String getTelefone() {
        return this.local.getTelefone();
    }

    public void setTelefone(String telefone) {
        this.local.setTelefone(telefone);
    }
}
