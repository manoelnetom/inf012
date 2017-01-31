/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servico;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import negocio.Texto;

/**
 *
 * @author aluno
 */
public class ProcessaPedido implements Runnable{

    private Socket cliente;

    public ProcessaPedido(Socket cliente) {
        this.cliente = cliente;
    }

    public void run() {
        try {
            Scanner ler = new Scanner(this.cliente.getInputStream());
            Texto texto = new Texto(ler.nextLine());
            PrintWriter escrever = new PrintWriter(this.cliente.getOutputStream(), true);
            escrever.println(texto.responder());
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
