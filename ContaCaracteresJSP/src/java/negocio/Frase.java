/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class Frase {
    private String texto;
    private int outros=0;
    private int vogais=0;
    private int consoantes=0;

    public Frase() {
        this.texto = "";
    }
    

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto.toLowerCase();
        this.contaCaracteres();
    }
    
    

    private void contaCaracteres(){
        
        for (int i = 0; i < this.getTexto().length(); i++) {
            char c=this.getTexto().charAt(i);
            if(Character.isLetter(c)){
                if((c=='a')||(c=='e')||(c=='i')||(c=='o')||(c=='u')){
                    vogais++;
                }else {
                    consoantes++;
                }
            }else if(!Character.isWhitespace(c)){
                outros++;
            }
        }
        
    }

    public int getOutros() {
        return outros;
    }

    public void setOutros(int outros) {
        this.outros = outros;
    }

    public int getVogais() {
        return vogais;
    }

    public void setVogais(int vogais) {
        this.vogais = vogais;
    }

    public int getConsoantes() {
        return consoantes;
    }

    public void setConsoantes(int consoantes) {
        this.consoantes = consoantes;
    }
    
}
