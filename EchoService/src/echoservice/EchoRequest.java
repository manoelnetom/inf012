/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package echoservice;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ManoelNeto
 */
public class EchoRequest implements Runnable{
    
    Socket socket;

    public EchoRequest(Socket socket) {
        this.socket = socket;
    }
    
    

    @Override
    public void run() {
        
        try {
            //To change body of generated methods, choose Tools | Templates.

            Scanner ler=new Scanner(socket.getInputStream());
            PrintWriter esc=new PrintWriter(socket.getOutputStream(),true);
            
            String messsagem=ler.nextLine();
            messsagem=messsagem.toUpperCase();
            
            esc.println(messsagem);
            
        } catch (IOException ex) {
            Logger.getLogger(EchoRequest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}
