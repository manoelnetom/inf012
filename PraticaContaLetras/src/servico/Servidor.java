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
 * @author aluno
 */
public class Servidor {
    public static void main(String srs[]) throws Exception{
    
        ServerSocket srv = new ServerSocket(1234);
        
        while(true){
        
            Socket cliente= srv.accept();
            ProcessaPedido pp= new ProcessaPedido(cliente);
            Thread t=new Thread(pp);
            t.start();
        
        }
        
    }
}
