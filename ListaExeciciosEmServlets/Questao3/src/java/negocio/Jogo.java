/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package negocio;

import java.util.Random;

/**
 *
 * @author ManoelNeto
 */
public class Jogo {
    private int numero;
    private int sorteado;
    private int tentaivas;

    public Jogo() {
        this.sortear();
        
    }
    
    private void sortear(){
        this.tentaivas=0;
        Random r=new Random();
        this.sorteado=r.nextInt(101);
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public int getSorteado() {
        return sorteado;
    }
    
   public String getResposta(){
       this.tentaivas++;
       String resposta="";
       if(this.getNumero()>this.getSorteado()){
           resposta="O número que vc digitou é maior, digite um numero menor que " +this.getNumero();
       }else if (this.getNumero()<this.getSorteado()){
           resposta="O número que vc digitou é menor, digite um numero maior que " +this.getNumero();
       }else{
           resposta="Parabéns, você acertou depois de "+this.tentaivas +"! O número sorteado é "+this.getSorteado();
           this.sortear();
       }
       return resposta;
   } 
    
    
}
