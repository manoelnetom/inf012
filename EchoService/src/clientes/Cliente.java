/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package clientes;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author ManoelNeto
 */
public class Cliente {
    public static void main(String[] args) throws Exception{
        
        Socket cli=new Socket("127.0.0.1",1234);
         Scanner ler=new Scanner(cli.getInputStream());
         PrintWriter esc=new PrintWriter(cli.getOutputStream(),true);
         
         esc.println("teste de msg em minusculo");
         String msgMaisculo= ler.nextLine();
         
         System.out.println(msgMaisculo);
            
    
    }
    
}
