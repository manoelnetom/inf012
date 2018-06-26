/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streamjava;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FilterWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.JFileChooser;

/**
 *
 * @author aluno
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File file = chooser.getSelectedFile();
        PrintWriter escrita= new PrintWriter(file);
        escrita.println("hhdhdjkdkdkd");
        escrita.flush();
        escrita.close();
        
        
        //BufferedReader ler = new BufferedReader(new FileReader(file));
        //String texto = null;
        //while ((texto = ler.readLine()) != null) {
        //    System.out.println(texto.toUpperCase());
        //}
        
        
        
    }

}
