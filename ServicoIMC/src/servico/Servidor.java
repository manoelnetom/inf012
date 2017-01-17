/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servico;

import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author ManoelNeto
 */
public class Servidor {
    public static void main(String args[]) throws Exception{
        ServerSocket srv = new ServerSocket(1234);
        System.out.println("Sevidor No ar...porta 1234");
            
        while(true){
            System.out.println("Sevidor aguardando novo cliente...");
            Socket cliente=srv.accept();
            Thread t=new Thread(new IMCUserRequest(cliente));
            t.start();
        }
    }
}
