package negocio;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Random;

/**
 *
 * @author ManoelNeto
 */
public class Jogo {

    private int numeroSorteado;
    private int numeroDigitado;

    public Jogo() {
        this.sortear();
    }

    public int getNumeroSorteado() {
        return numeroSorteado;
    }

    private void setNumeroSorteado(int numeroSorteado) {
        this.numeroSorteado = numeroSorteado;
    }

    private void sortear() {
        Random r = new Random();
        this.setNumeroSorteado(r.nextInt(101));

    }

    public int getNumeroDigitado() {
        return numeroDigitado;
    }

    public void setNumeroDigitado(int numeroDigitado) {
        this.numeroDigitado = numeroDigitado;
    }

    public String getResultado() {

        if (this.getNumeroDigitado() > this.getNumeroSorteado()) {
            return "O número digitado é Maior que o número Sorteado";
        } else if (this.getNumeroDigitado() < this.getNumeroSorteado()) {
            return "O número digitado é Menor que o número Sorteado";
        } else {
            this.sortear();
            return "Parabens Você acertou";
        }
    }

}
