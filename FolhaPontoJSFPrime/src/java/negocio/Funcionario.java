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
public class Funcionario {
    
    private String nome;
    private CartaoPonto ponto;
    private final double salariobase = 2000;
    public Funcionario() {
        this.ponto = new CartaoPonto();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public CartaoPonto getPonto() {
        return ponto;
    }

    
}
