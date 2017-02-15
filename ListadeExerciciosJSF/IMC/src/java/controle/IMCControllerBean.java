/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controle;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import negocio.Usuario;

/**
 *
 * @author ManoelNeto
 */
@ManagedBean(name="controllerIMCBean")
@RequestScoped
public class IMCControllerBean {

    private Usuario usuario;
    private String message;
 
    public IMCControllerBean() {
        this.usuario=new Usuario();
    }
    
    public Usuario getUsuario(){
        return this.usuario;
    }
    
     
    public void calculaIMC() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("IMC",  this.getUsuario().getIMCTradicional()) );
        context.addMessage(null, new FacesMessage("Pela fórmula de Hildenburg", this.getUsuario().getIMCHildenburg()));
        context.addMessage(null, new FacesMessage("Pela fórmula de Oxford",  this.getUsuario().getIMCOxford()));
    
    }
    
}
