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
public class QuadradoMagico {

    private int[][] mat = new int[3][3];

    public QuadradoMagico() {
        this.gerarNovoQuadrado();
    }

    
    
    public int[][] getMat() {
        return mat;
    }

    
    
    private void initMatrix() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.mat[i][j] = -1;
            }

        }
    }

    private void gerarNovoQuadrado() {
        this.initMatrix();
        Random r = new Random();
        int posicoes = r.nextInt(8) + 1;

        for (int i = 0; i < posicoes; i++) {
            int linha = r.nextInt(3);
            int coluna = r.nextInt(3);

            this.mat[linha][coluna] = r.nextInt(10);
        }

    }

    public String getResultado() {
        int linha1 = this.getP00() + this.getP01() + this.getP02();
        int linha2 = this.getP10() + this.getP11() + this.getP12();
        int linha3 = this.getP20() + this.getP21() + this.getP22();

        int coluna1 = this.getP00() + this.getP10() + this.getP20();
        int coluna2 = this.getP01() + this.getP11() + this.getP21();
        int coluna3 = this.getP02() + this.getP12() + this.getP22();

        if ((linha1 == linha2) && (linha2 == linha3) && (linha3 == coluna1) && (coluna1 == coluna2) && (coluna2 == coluna3)) {
            return "É um quadrado Mágico";
        }
        return "Não é um quadrado Mágico";
    }

    public void setP00(int p00) {
        this.mat[0][0] = p00;
    }

    public void setP01(int p01) {
        this.mat[0][1] = p01;
    }

    public void setP02(int p02) {
        this.mat[0][2] = p02;
    }

    public void setP10(int p10) {
        this.mat[1][0] = p10;
    }

    public void setP11(int p11) {
        this.mat[1][1] = p11;
    }

    public void setP12(int p12) {
        this.mat[1][2] = p12;
    }

    public void setP20(int p20) {
        this.mat[2][0] = p20;
    }

    public void setP21(int p21) {
        this.mat[2][1] = p21;
    }

    public void setP22(int p22) {
        this.mat[2][2] = p22;
    }

    public int getP00() {
        return this.mat[0][0];
    }

    public int getP01() {
        return this.mat[0][1];
    }

    public int getP02() {
        return this.mat[0][2];
    }

    public int getP10() {
        return this.mat[1][0];
    }

    public int getP11() {
        return this.mat[1][1];
    }

    public int getP12() {
        return this.mat[1][2];
    }

    public int getP20() {
        return this.mat[2][0];
    }

    public int getP21() {
        return this.mat[2][1];
    }

    public int getP22() {
        return this.mat[2][2];
    }
}
