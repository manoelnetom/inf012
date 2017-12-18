/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication14;

import com.sun.webkit.ThemeClient;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author ManoelNeto
 */
public class Servidor {
        
    public static void main(String[] args) throws Exception{
        // TODO code application logic here
        ServerSocket srv=new ServerSocket(1234);
        System.out.println("Servidor no ar porta 1234...");
        while(true){
            System.out.println("Aguardando clientes ...");
            Socket cliente=srv.accept();
            Thread t=new Thread(new Echo(cliente));
            t.start();
        }
        
    }
    

}
