/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplostreamsemjava;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author ManoelNeto
 */
public class ExemploStreamsEmJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        //System.out.println("Olá Mundo");
        
        Scanner ler= new Scanner(System.in);
        String texto= ler.nextLine();
        
        //?Onde está a maquina: IP 127.0.0.1
        //Qual é o programa que eu quero me comunicar: PORTA

        Socket cliente =new Socket("127.0.0.1", 1234);
        
        PrintWriter esc = new PrintWriter(cliente.getOutputStream(),true);
        
        esc.println(texto);

        Scanner ler2 = new Scanner(cliente.getInputStream());
            String texto2= ler2.nextLine();
          System.out.println("O Texto: " + texto2);
        //BufferedReader ler2 = new BufferedReader(new InputStreamReader(System.in));
        
        
        /*
        System.out.println("O Texto: " + texto);
        
        texto = ler2.readLine();
        
        System.out.println("O Texto2: " + texto);
        
        File file=new File("Arq.txt");
        
        PrintWriter esc =new PrintWriter(new FileOutputStream(file),true);
        
        esc.println("Texto escrito em um arquivo texto");
                
        BufferedReader ler32 = new BufferedReader(new FileReader(file));
      
        while ((texto=ler32.readLine())!=null) {
          System.out.println("O Texto3: " + texto);
            
        }
         */
                
    }
    
}
