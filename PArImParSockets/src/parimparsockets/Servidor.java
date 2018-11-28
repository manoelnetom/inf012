/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parimparsockets;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author aluno
 */
public class Servidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
        ServerSocket srv= new ServerSocket(1234);
        System.out.println("Servidor no ar porta 1234...");
        while(true){
            System.out.println("Aguardando solicitacoes de clientes...");
            Socket cli= srv.accept();
            System.out.println(cli);
            Thread t= new Thread(new Numero(cli));
            t.start();
        }
        
        
    }
    
}
