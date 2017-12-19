/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taferasockets;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author ManoelNeto
 */
public class Cliente {
public static void main(String[] args) throws IOException{ 
   Socket cliente =new Socket("127.0.0.1",1234);
    Scanner ler =new Scanner(cliente.getInputStream());
    System.out.println(ler.nextLine());
            
        
        
 }
}
