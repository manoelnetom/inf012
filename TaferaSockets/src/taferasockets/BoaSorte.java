/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taferasockets;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ManoelNeto
 */
public class BoaSorte implements Runnable {
// (1) crie um vetor de mensagens
    
private HashMap map =new HashMap();
private Socket cliente;
    public BoaSorte(Socket cliente) {
        this.cliente = cliente;
        map.put("1", "A sorte acompanha vc");
        map.put("2", "A sorte é uma virtude");
        map.put("3", "Sorte é tudo na vida");
        map.put("4", "Que tem fe tem sorte"); 
    }


public String boaSorte( ){
    return ""+map.get(""+Math.round(Math.random()*4));

} 


@Override
public void run(){
    try {
        PrintWriter esc2=new PrintWriter(new FileOutputStream(new File("")),true);
        PrintWriter esc=new PrintWriter(this.cliente.getOutputStream(),true);
        // (2) escolha uma mensagem aleatória do vetor e envie}  
        esc.println(boaSorte());
    } catch (IOException ex) {
        Logger.getLogger(BoaSorte.class.getName()).log(Level.SEVERE, null, ex);
    }
   
}

}
