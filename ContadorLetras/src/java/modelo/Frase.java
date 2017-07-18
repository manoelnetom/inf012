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
public class Frase {
    private String texto;
    private int vogais;

    
    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public void setVogais(int vogais) {
        this.vogais = vogais;
    }
    
    
    public int getVogais(){
        this.processaFrase();
        return vogais;
    }
    
    private void processaFrase(){
        this.vogais=0;
        for (int i = 0; i < this.getTexto().length(); i++) {
            char c=this.getTexto().toLowerCase().charAt(i);
            if(Character.isLetter(c)){
                if((c=='a')||(c=='e')||(c=='i')||(c=='o')||(c=='u')){
                    this.vogais++;
                }
            }
        }
    }
    
}
