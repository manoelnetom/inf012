/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

/**
 *
 * @author ManoelNeto
 */
public class Numero {
    
    private int numero;

    public Numero(int numero) {
        this.numero = numero;
    }
    
    public String getResposta(){
    
        if((numero%2)==0)
            return "E Par";
        return "E impar";
               
    }
    
}
