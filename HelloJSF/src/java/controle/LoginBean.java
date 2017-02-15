/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controle;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import modelo.Usuario;

/**
 *
 * @author ManoelNeto
 */
@ManagedBean (name="controleLogin")
@SessionScoped
public class LoginBean {

    /**
     * Creates a new instance of LoginBean
     */
    private Usuario usuario;
    public LoginBean() {
        this.usuario=new Usuario();
    }

    public Usuario getUsuario() {
        return usuario;
    }
    
    public void logar(){
        
    }
    
}
