/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package echosocketsjava;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author aluno
 */
public class Cliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        System.out.println("Digite um texto: ");
        Scanner ler = new Scanner(System.in);
        String texto = ler.nextLine();
        
        Socket soc = new Socket("127.0.0.1", 1234);
        PrintWriter escrita = new PrintWriter(soc.getOutputStream(),true);
        escrita.println(texto);
        
        Scanner lerServidor = new Scanner(soc.getInputStream());
        System.out.println(lerServidor.nextLine());
        
        
        
    }
    
}
