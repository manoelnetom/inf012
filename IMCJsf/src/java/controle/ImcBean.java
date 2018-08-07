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
 * @author aluno
 */
@Named(value = "imcBean")
@RequestScoped
public class ImcBean {

    
    private Usuario usuario;
    
    public ImcBean() {
        this.usuario=new Usuario();
    }

    public Usuario getUsuario() {
        return usuario;
    }
    
    public void calcularIMC(){
        
        FacesContext context = FacesContext.getCurrentInstance();
         
        context.addMessage(null, new FacesMessage("IMC",  this.usuario.getImcTradicional() ) );
    
    }
}
