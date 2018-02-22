/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import negocio.Frase;

/**
 *
 * @author ManoelNeto
 */
@Named(value = "actionContar")
@RequestScoped
public class ContaCaracterManagedBean implements Serializable {

    private Frase frase;
    public ContaCaracterManagedBean() {
        this.frase = new Frase();
    }

    public Frase getFrase() {
        return frase;
    }
    
    public void contaVogais() {
        FacesContext context = FacesContext.getCurrentInstance();    
        context.addMessage(null, new FacesMessage("Conta Vogais", "O numero de vogais e: " +this.getFrase().getVogais()));
    }
    
    public void contaConsoantes() {
        FacesContext context = FacesContext.getCurrentInstance();    
        context.addMessage(null, new FacesMessage("Conta Consoantes", "O numero de Consaotes e: " +this.getFrase().getConsoantes()));
    }
    
    public void contaOutros() {
        FacesContext context = FacesContext.getCurrentInstance();    
        context.addMessage(null, new FacesMessage("Conta Outros", "O numero de outros e: " +this.getFrase().getOutros()));
    }
}
