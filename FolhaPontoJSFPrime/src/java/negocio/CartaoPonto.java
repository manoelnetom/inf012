/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.ArrayList;
import java.util.List;

public class CartaoPonto {

    private boolean faltas[][];
    private int dia;
    private int mes;

    public void setDia(int dia) {
        this.dia = dia;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public CartaoPonto() {
        this.faltas = new boolean[12][31];
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 31; j++) {
                this.faltas[i][j] = false;
            }
        }
    }

    public String computarFalta() {
        if (((dia > 0) && (dia < 32)) && ((mes > 0) && (mes < 13))){
            this.faltas[mes-1][dia-1] = true;
            return "falta adicionada com sucesso";
        } else {
            return "Data Incorreta";
        }
    }
    
    public int totalFaltas(){
        int total=0;
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 31; j++) {
                if(this.faltas[i][j] == true){
                    total ++;
                }
            }
        }
        return total;
    }
    
    public List<String> datasFaltas(){
        ArrayList lista;
        lista = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 31; j++) {
                if(this.faltas[i][j] == true){
                    lista.add("Falta mes: "+i+", dia: "+j);
                }
            }
        }
        return lista;
    }

}
