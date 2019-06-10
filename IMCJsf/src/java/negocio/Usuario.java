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
public class Usuario {
    
    private double peso;
    private double altura;

    public Usuario(double peso, double altura) {
        this.peso = peso;
        this.altura = altura;
    }

    public Usuario() {
        this.peso = 0;
        this.altura = 0;
    }

    
    public String getIMCTradicional(){
        double valor=(this.getPeso()/Math.pow(this.altura, 2));
        return "O seu IMC pela formula tradicional é: "+ valor; 
    }
    
    public String getIMCOxford(){
        double valor=(1.3*this.getPeso()/Math.pow(this.altura, 2.5));
        return "O seu IMC pela formula de OXFORD é: "+ valor; 
    }
    
    public String getIMCHildenburg(){
        double valor=(1.72*this.getPeso()/Math.pow(this.altura, 3.06));
        return "O seu IMC pela formula de Hildenburg é: "+ valor; 
    }
    
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
    
    
    
}
