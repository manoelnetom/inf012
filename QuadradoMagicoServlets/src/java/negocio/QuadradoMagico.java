/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.Random;

/**
 *
 * @author aluno
 */
public class QuadradoMagico {
    
    private int mat[][]=new int[3][3];

    public QuadradoMagico() {
        this.novoQuadrado();
    }
    
    private void initMat(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                mat[i][j]=-1;
            }
        }
    }
    
    private void novoQuadrado(){
        this.initMat();
        Random rand=new Random();
        int qtd=rand.nextInt(5)+1;
        
        for (int i = 0; i < qtd; i++) {
            int linha =rand.nextInt(3);
            int coluna = rand.nextInt(3);
            int valor= rand.nextInt(10);
            mat[linha][coluna]=valor;
        }
    }
    
}
