/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

/**
 *
 * @author aluno
 */
public class MesaBar {
    
    private double total;
    private int pessoas;
    private double gorgeta;
   
    public MesaBar() {
        
    }

    public double calcularTotalGeral(){
        return this.getTotal()+(this.getTotal()*(this.getGorgeta()/100)); 
    }
    
    public double calcularTaotalPessoa(){
        return this.calcularTotalGeral()/this.getPessoas(); 
    }
    
    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getPessoas() {
        return pessoas;
    }

    public void setPessoas(int pessoas) {
        this.pessoas = pessoas;
    }

    public double getGorgeta() {
        return gorgeta;
    }

    public void setGorgeta(double gorgeta) {
        this.gorgeta = gorgeta;
    }
    
    
    
}
