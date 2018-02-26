/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import negocio.Usuario;

/**
 *
 * @author ManoelNeto
 */
@Named(value = "imcBean")
@RequestScoped
public class IMCControllerBean {

    private Usuario usuario;
    
    public IMCControllerBean() {
        this.usuario =new Usuario();
    }

    public Usuario getUsuario() {
        return usuario;
    }
    
     public void calculaIMCTradicional() {
        FacesContext context = FacesContext.getCurrentInstance();    
        context.addMessage(null, new FacesMessage("IMC Tradicional", this.getUsuario().getIMCTradicional()));
    }
     
    public void calculaIMCHildenburg() {
        FacesContext context = FacesContext.getCurrentInstance();    
        context.addMessage(null, new FacesMessage("IMC Hildenburg", this.getUsuario().getIMCHildenburg()));
    }
    
    public void calculaIMCOxford() {
        FacesContext context = FacesContext.getCurrentInstance();    
        context.addMessage(null, new FacesMessage("IMC Oxford", this.getUsuario().getIMCOxford()));
    } 
}
