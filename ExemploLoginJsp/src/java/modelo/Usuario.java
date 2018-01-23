/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author ManoelNeto
 */
public class Usuario {
    
    private String user;
    private String senha;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public String getLogin(){
        if((this.getUser().equalsIgnoreCase("manoel"))&&(this.getSenha().equals("abc123"))){
            return "Usuario Logado";
        }
        return "Usuario não identificado";
    }
    
}
