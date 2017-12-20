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

public class Cliente {

    public static void main(String[] args) throws IOException {
        Socket cliente = new Socket("127.0.0.1", 1234);

        DataOutputStream out = new DataOutputStream(cliente.getOutputStream());
        DataInputStream in = new DataInputStream(cliente.getInputStream());
        byte[] vet = {1, 6, 3, 9, 2, 5, 4, 8, 7};
        int op = 4;
        out.write(op);// Defina Op 
        out.flush();
        out.write(vet.length);//tamanho
        out.flush();
        out.write(vet);
        out.flush();
        if (op != 4) {
            int newLength = in.read();
            byte[] newvet = new byte[newLength];
            in.read(newvet, 0, newLength);
            for (int i = 0; i < newvet.length; i++) {
                System.out.print(newvet[i]);
                System.out.print(",");
            }
        } else {
            int qtd = in.read();
            System.out.print("Qtd impares: " +qtd);
        }

    }
}
