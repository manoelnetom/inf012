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
public class Pessoa {

    private double peso;
    private double altura;
    
    

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double calculaIMC(){
    
        return (this.getPeso()/Math.pow(this.getAltura(), 2));
    }
    
}
