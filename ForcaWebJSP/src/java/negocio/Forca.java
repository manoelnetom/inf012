/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.*;

public class Forca {
    
    private String categoria;
    private String filmes[] = {"A era do Gelo 1","A era do Gelo 2", "Os incríveis"};
    private String novelas[] = {"Bang Bang","Vamp", "Bebe a Bordo"};
    private String marcas[] = {"Gol","Golf", "Fiesta"};
    private String img[] = {"img/semnada.JPG","img/semcorpo.JPG", "img/sembracoDE.JPG", "img/sembracoE.JPG", "img/sempe.JPG", "img/completa.JPG"};
    private String palavra;
    private String palavravazia[];
    private String letra;
    private int erros;
    private int acertos;
    private Hashtable letras=new Hashtable();
    
    public String getImg(){
        return this.img[erros];
    }
    
    public String getLetras(){
        String result="";
        Enumeration e=letras.elements();
        while(e.hasMoreElements()){
            result+=e.nextElement()+ " - ";
        }
        
        return result;
    }
    public String getResultado(){
        String result="";
        if(acertos==this.palavra.length()){
            result="Você  Ganhou";
        }else if(erros==5){
            result="Vc Perdeu";
        }else{
            for(int i=0;i<this.palavra.length();i++){
                result+=this.palavravazia[i];
            }
        }
        
        
        return  result;
    }
    public String getCategoria() {
        return this.categoria;
    }
    
    
    public void setCategoria(String categoria) {
        Random r=new Random();
        int i=r.nextInt(3);
        this.categoria = categoria;
        if(this.categoria.equals("filmes")){
            this.setPalavra(this.filmes[i]);
        }else if(this.categoria.equals("novela")){
            this.setPalavra(this.novelas[i]);
        }else{
            this.setPalavra(this.marcas[i]);
        }
    }
    
    public String getPalavra() {
        return this.palavra;
    }
    
    
    public void setPalavra(String palavra) {
        this.palavra = palavra;
        this.palavravazia=new String[this.palavra.length()];
        for(int i=0;i<this.palavra.length();i++){
            if(!this.palavra.substring(i,i+1).equals(" ")){
                this.palavravazia[i]=" __ ";
            }else{
                this.palavravazia[i]="&nbsp;";
                acertos++;
            }
        }
    }
    
    public String getLetra() {
        return this.letra;
    }
    
    public void setLetra(String letra) {
        this.letra = letra;
        letras.put(this.letra,this.letra);
        if(this.palavra.indexOf(this.letra)>-1){
            while(this.palavra.indexOf(this.letra)>-1){
                int pos=this.palavra.indexOf(this.letra);
                this.palavra=(this.palavra.replaceFirst(this.letra,"#"));
                this.palavravazia[pos]=this.letra;
                acertos++;
            }
        }else{
            erros++;
        }
    }
    
}
