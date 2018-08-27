/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import DAO.DAOPassagemAerea;
import DAO.DAOPassagemAereaDerby;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelo.PassagemAerea;

/**
 *
 * @author aluno
 */
@Named(value = "compraManagedBean")
@ApplicationScoped
public class CompraManagedBean {

    private DAOPassagemAerea dao;
    private PassagemAerea passagem;

    public CompraManagedBean() {
        this.passagem = new PassagemAerea();
        this.dao = new DAOPassagemAereaDerby();
    }

    public PassagemAerea getPassagem() {
        return passagem;
    }

    public void setPassagem(PassagemAerea passagem) {
        this.passagem = passagem;
    }

    public List<PassagemAerea> getPassagens() {
        try {
            return dao.listaPassgens();
        } catch (Exception ex) {
            Logger.getLogger(CompraManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void comprar() {
        FacesContext context = FacesContext.getCurrentInstance();

        try {
            //context.addMessage(null, new FacesMessage("Nome",  "O nome é "+this.getPassagem().getNome() ) );

            dao.addPassagem(this.getPassagem());
            context.addMessage(null, new FacesMessage("Passagem", "Passagem Comprada com sucesso"));

        } catch (Exception ex) {
            Logger.getLogger(CompraManagedBean.class.getName()).log(Level.SEVERE, null, ex);
            context.addMessage(null, new FacesMessage("Passagem", "Problemas"));

        }

    }

    public void buscar() {
        FacesContext context = FacesContext.getCurrentInstance();

        context.addMessage(null, new FacesMessage("Buscar", "Busca feita com sucesso"));

    }

}
