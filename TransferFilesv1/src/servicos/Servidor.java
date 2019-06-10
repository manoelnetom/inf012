/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author manoel
 */
public class Servidor {
    
    public static void main(String args[]) throws Exception{
        
        ServerSocket srv=new ServerSocket(1234);
        System.out.print("Servidor no ar na porta 1234...");
        while(true){
            Socket soc=srv.accept();
            Thread t=new Thread(new FileTransferRequest(soc));
            t.start();
        }
                
    
    }
    
    
}
