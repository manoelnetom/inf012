/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import DAO.DAOUsuario;
import DAO.DAOUsuarioDerby;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import model.Usuario;

/**
 *
 * @author ManoelNeto
 */
@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean {

    private Usuario usuario;

    public LoginBean() {
        this.usuario = new Usuario();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void logar(ActionEvent ev){
        
        String message;
        DAOUsuario dao = new DAOUsuarioDerby();
        try {
            if(dao.Logar(this.getUsuario())){
                message = "Login efetuado com sucesso!!!";
            }else{
                message = "Problemas ao relaizar o seu Login!!!";
            }
        } catch (Exception ex) {
            message = "Problemas ao conectar com o BD!!!"+ex;
        }
        
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Login", message));
        

    }

}
