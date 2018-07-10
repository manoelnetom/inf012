/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

/**
 *
 * @author aluno
 */
public class Conta {

   private  double total;
   private int pessoas;
   private double gorjeta;

    public Conta(double total, int pessoas, double gorjeta) {
        this.total = total;
        this.pessoas = pessoas;
        this.gorjeta = gorjeta;
    }
    
    public String getConta(){
        
        this.total=(this.total+(this.total*this.gorjeta/100));
        double porPessoa=(this.total/this.pessoas);
        
        return "O total geral da conta é "+ this.total + " e o total por pessoa é "+porPessoa;
    }
}
