/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketvetorinteiros;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author ManoelNeto
 */
public class VetorInteiros implements Runnable {
    
    private byte[] vetor;
    private Socket cliente;
    
    public VetorInteiros(Socket cliente) {
        this.cliente = cliente;
    }
    
    public byte[] getVetor() {
        return vetor;
    }
    
    public void sort(byte[] vetor) {
        for (int i = vetor.length; i >= 1; i--) {
            for (int j = 1; j < i; j++) {
                if (vetor[j - 1] > vetor[j]) {
                    byte aux = vetor[j];
                    vetor[j] = vetor[j - 1];
                    vetor[j - 1] = aux;
                }
            }
        }
        this.vetor = vetor;
    }
    
    public void setVetPar(byte[] vetor) {
        this.sort(vetor);
        byte[] vetPar = new byte[this.vetor.length];
        int x = 0;
        for (int i = 0; i < this.vetor.length; i++) {
            if ((this.vetor[i] % 2) == 0) {
                vetPar[x] = this.vetor[i];
                x++;
            }
        }
        byte[] vetParTrim = new byte[x];
        System.arraycopy(vetPar, 0, vetParTrim, 0, x);
        this.vetor = vetParTrim;
    }
    
    public void setVetModule(byte[] vetor) {
        this.sort(vetor);
        byte[] vetModulo = new byte[this.vetor.length];
        for (int i = 0; i < this.vetor.length; i++) {
            vetModulo[i] = (byte) (this.vetor[i] % 2);            
        }
        this.vetor = vetModulo;
        
    }
    
    public int getImparCount(byte[] vetor) {        
        int x = 0;
        for (int i = 0; i < vetor.length; i++) {
            if ((vetor[i] % 2) != 0) {
                x++;
            }
        }        
        return x;
    }

    @Override
    public void run() {
        try {
            DataOutputStream out = new DataOutputStream(cliente.getOutputStream());
            DataInputStream in = new DataInputStream(cliente.getInputStream());
            
            byte op = in.readByte();
            //System.out.println("OP: "+op);
            int lengt = in.read();
            //System.out.println("length: "+lengt);
            byte[] vet = new byte[lengt];
            in.read(vet, 0, lengt);
            //for (int i = 0; i < lengt; i++) {
            //    System.out.print(vet[i]+",");
            //}
            switch (op) {
                case 1:
                    this.sort(vet);
                    out.write(this.getVetor().length);
                    out.flush();
                    out.write(this.getVetor());
                    out.flush();
                    break;
                case 2:
                    this.setVetPar(vet);
                    out.write(this.getVetor().length);
                    out.flush();
                    out.write(this.getVetor());
                    out.flush();
                    break;
                case 3:
                    this.setVetModule(vet);
                    out.write(this.getVetor().length);
                    out.flush();
                    out.write(this.getVetor());
                    out.flush();
                    break;
                case 4:
                    out.write(this.getImparCount(vet));
                    out.flush();
                    break;                
                
            }
        } catch (IOException e) {
            System.out.print(e);
        }
    }
    
}
