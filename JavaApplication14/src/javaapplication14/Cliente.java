/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication14;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author ManoelNeto
 */
public class Cliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Socket cliente = new Socket("127.0.0.1", 1234);
        PrintWriter esc=new PrintWriter(cliente.getOutputStream(),true);
        
        esc.println("mensagem em minusculo");
        
        Scanner ler =new Scanner(cliente.getInputStream());
        String resposta = ler.nextLine();
        
        System.out.println(resposta);
        
    }
    
}
