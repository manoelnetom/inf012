/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taferasockets;

import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author ManoelNeto
 */
public class Servidor {

    public static void main(String[] args) {
// (3) escolha uma porta para ser usada por este servidor BoaSotre msg = new Mensagens();
        try { // (4) crie um socket de servidor
            ServerSocket srv = new ServerSocket(1234);
            System.out.println("Servidor no ar...porta 1234");

            while (true) {
                // (5) aceite uma conexão de um cliente, /
                // (6) Processa mensagem de boa sorte  } }
                System.out.println("Servidor Aguardando Cliente...");
                Socket cliente = srv.accept();
                Thread t = new Thread(new BoaSorte(cliente));
                t.start();
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
