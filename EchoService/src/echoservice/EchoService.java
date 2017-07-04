/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package echoservice;

import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author ManoelNeto
 */
public class EchoService {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        // TODO code application logic here
        ServerSocket srv=new ServerSocket(1234);
        while (true) {            
            Socket cliente=srv.accept();
            System.out.println(cliente.getInetAddress().getHostAddress());
            Thread t=new Thread(new EchoRequest(cliente));
            t.start();
                    
        }
        
    }
    
}
