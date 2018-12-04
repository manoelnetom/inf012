
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ManoelNeto
 */
public class Servidor {
    public static void main(String[] args) throws IOException {
    
        ServerSocket srv=new ServerSocket(1234);
        
        while(true){
        
            Socket ponta = srv.accept();
            
            Scanner ler = new Scanner(ponta.getInputStream());
            String texto= ler.nextLine();
            PrintWriter esc = new PrintWriter(ponta.getOutputStream(),true);
        
             esc.println("Chegou "+texto);
        }
        
    }
    
}
