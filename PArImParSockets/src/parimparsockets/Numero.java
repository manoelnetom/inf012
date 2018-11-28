/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parimparsockets;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aluno
 */
public class Numero implements Runnable {

    int valor;
    Socket cli;

    public Numero(Socket cli) {
        this.cli = cli;
    }

    public String getResposta() {
        int numero = valor;
        if ((numero % 2) == 0) {
            return "E par";
        }
        return "E impar";

    }

    @Override
    public void run() {
        PrintWriter out;
        try {
            out = new PrintWriter(cli.getOutputStream(), true);
            Scanner ler = new Scanner(cli.getInputStream());
            valor = (Integer.parseInt(ler.nextLine()));
            out.println(this.getResposta());
        } catch (IOException ex) {
            Logger.getLogger(Numero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
