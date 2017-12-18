/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication14;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ManoelNeto
 */
public class Echo implements Runnable{
        
    private Socket cliente;

    public Echo(Socket cliente) {
        this.cliente = cliente;
    }
    
    
    public void processRequest()throws Exception{
        Scanner ler =new Scanner(cliente.getInputStream());
        String msg = ler.nextLine();
        msg=msg.toUpperCase();
        PrintWriter esc=new PrintWriter(cliente.getOutputStream(),true);
        esc.println();
        ler.close();
        esc.close();
        cliente.close();     
    }
    
    @Override
    public void run() {  
        try {
            processRequest();
        } catch (Exception ex) {
            Logger.getLogger(Echo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
