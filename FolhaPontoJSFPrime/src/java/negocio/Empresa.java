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
public class Empresa {
    
    private Funcionario mario;
    private Funcionario luiz;

    public Empresa() {
        this.mario = new Funcionario();
        this.luiz = new Funcionario();
    }

    public Funcionario getMario() {
        return mario;
    }

    public Funcionario getLuiz() {
        return luiz;
    }
    
    
    
    
}
