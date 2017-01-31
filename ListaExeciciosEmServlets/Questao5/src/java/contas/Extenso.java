package contas;
import java.util.*;
public class Extenso {
    
    private String valorTexto;
    private String valor;
    private Hashtable unidade=new Hashtable();
    private Hashtable dez=new Hashtable();
    private Hashtable centena=new Hashtable();
    
    
    public String getValor() {
       
        return this.valor;
    }
    
    public void setValor(String valor) {
        this.setCentena();
        this.setDez();
        this.setUnidade();
        this.valor = valor;
    }
    
    public String getValorTexto() {
        this.setValorTexto();
        return this.valorTexto;
    }
    public void setValorTexto() {
        this.valorTexto = this.traduzParteInteira()+this.traduzParteDecimal();
    }
    
    
    public String traduzParteInteira(){
        String vt[]=this.getValor().split(",");
        int tam=vt[0].length();
        String txt="";
        char u=' ', d=' ', c=' ';
        switch (tam){
            case 3: //Centenas
            {
                u=vt[0].charAt(2);
                d=vt[0].charAt(1);
                c=vt[0].charAt(0);
                
                if((d=='0')&&(u!='0')){       //para tratar cento e um, cento e dois....
                    txt=txt+" "+this.getCentena().get(""+c)+" e "+this.getUnidade().get(""+u);
                }else if((d=='0')&&(u=='0')){//para tratar cem, duzentos...
                    if(this.getCentena().get(""+c).equals("cento")){
                        txt=txt+" Cem ";
                    }else {
                        txt=txt+" "+this.getCentena().get(""+c);
                    }
                }else if((d=='1')){//para tratar ....cento e onze, duzentos e doze...
                    txt=txt+" "+this.getCentena().get(""+c)+" e "+this.getUnidade().get(""+d+""+u);
                }else if((d!='0')&&(u=='0')){//para tratar cento e vinte, duzentoes e trinta....
                    txt=txt+" "+this.getCentena().get(""+c)+" e "+this.getDez().get(""+d);
                } else {
                    txt=txt+" "+this.getCentena().get(""+c)+" e "+this.getDez().get(""+d)+" e "+this.getUnidade().get(""+u);
                }
                break;
            }
            case 2: ///dezenas
            {
                u=vt[0].charAt(1);
                d=vt[0].charAt(0);
                if(d=='1'){//para tratar onze...doze....
                    txt=txt+" "+this.getUnidade().get(""+d+""+u);
                }else if(u=='0'){ // vinte , trinta
                    txt=txt+" "+this.getDez().get(""+d);
                }else{
                    txt=txt+" "+this.getDez().get(""+d)+" e "+this.getUnidade().get(""+u);
                }
                break;
            }
            
            default://Unidades
                
            {
                u=vt[0].charAt(0);
                txt=txt+" "+this.getUnidade().get(""+u);
            }
        }
        txt+= " <b>Reais</b> ";
        return txt;
    }
    
    public String traduzParteDecimal(){
        String vt[]=this.getValor().split(",");
        String txt="";
        int tam=vt[1].length();
        char u=' ';
        char d=' ';
        u=vt[1].charAt(1);
        d=vt[1].charAt(0);
        if((d=='0')&& (u!='0')){//para tratar 01, 02 ,  03 ....
            txt=txt+" e "+this.getUnidade().get(""+u) + " <b>Centavos</b> ";
        }else if(d=='1'){//para tratar onze...doze....
            txt=txt+" e "+this.getUnidade().get(""+d+""+u) + " <b>Centavos</b> ";
        }else if(u=='0'){ // vinte , trinta
            txt=txt+" e "+this.getDez().get(""+d) + " <b>Centavos</b> ";
        }else if((d!='0')&&(u!='0')){
            txt=txt+" e "+this.getDez().get(""+d)+" e "+this.getUnidade().get(""+u) + " <b>Centavos</b> ";
        }
        
        return txt;
    }
    
    public Hashtable getDez() {
        return this.dez;
    }
    
    public Hashtable getCentena() {
        return this.centena;
    }
    
    public Hashtable getUnidade() {
        return this.unidade;
    }
    
    public void setUnidade() {
        this.unidade.put("1","Um");
        this.unidade.put("2","Dois");
        this.unidade.put("3","Três");
        this.unidade.put("4","Quatro");
        this.unidade.put("5","Cinco");
        this.unidade.put("6","Seis");
        this.unidade.put("7","Sete");
        this.unidade.put("8","Oito");
        this.unidade.put("9","Nove");
        this.unidade.put("10","Dez");
        this.unidade.put("11","Onze");
        this.unidade.put("12","Doze");
        this.unidade.put("13","Treze");
        this.unidade.put("14","Quatorze");
        this.unidade.put("15","Quinze");
        this.unidade.put("16","Dezeseis");
        this.unidade.put("17","Dezessete");
        this.unidade.put("18","Dezoito");
        this.unidade.put("19","Dezenove");
        
    }
    public void setDez() {
        this.dez.put("2","Vinte");
        this.dez.put("3","Trinta");
        this.dez.put("4","Quarenta");
        this.dez.put("5","Cinquenta");
        this.dez.put("6","Sessenta");
        this.dez.put("7","Setenta");
        this.dez.put("8","Oitenta");
        this.dez.put("9","Noventa");
        
    }
    
    public void setCentena() {
        this.centena.put("1","Cento");
        this.centena.put("2","Duzentos");
        this.centena.put("3","Trezentos");
        this.centena.put("4","Quatrocentos");
        this.centena.put("5","Quinhentos");
        
    }
    
}
