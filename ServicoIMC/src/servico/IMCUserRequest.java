/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servico;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import negocio.Usuario;

/**
 *
 * @author ManoelNeto
 */
public class IMCUserRequest implements Runnable {

    private Socket cliente;

    public IMCUserRequest(Socket cliente) {
        this.cliente = cliente;
    }

    @Override
    public void run() {
        try {
            Usuario user = new Usuario();
            Scanner ler = new Scanner(cliente.getInputStream());
            PrintWriter escrever = new PrintWriter(cliente.getOutputStream(), true);
            //Manda mensagem de boas vindas para o cliente e pede que ele digte o peso
            escrever.println("Olá, seja bem-vindo. Digite o seu peso e clique em enviar");
            //Lê o peso digitado.
            user.setPeso(Double.parseDouble(ler.nextLine()));
            //Manda mensagem pedindo que o usuario digte a altura
            escrever.println("Agora, digite a sua altura e clique em enviar");
            //Lê a altura digitada.
            user.setAltura(Double.parseDouble(ler.nextLine()));
            //Manda mensagem pedindo que o usuario digte qual é a formula 1, 2 ou 3
            escrever.println("Agora, digite 1) para IMC tradicional, 2) para IMC OXFORD e 3) ImC Hindenburg e clique em enviar");
            //Lê a formula escolhida.
            int formula = Integer.parseInt(ler.nextLine());
            //Manda respota do IMC para usuario
            if (formula == 1) {
                escrever.println(user.getIMCTradicional());
            } else if (formula == 2) {
                escrever.println(user.getIMCOxford());
            } else {
                escrever.println(user.getIMCHildenburg());
            }
        } catch (IOException ex) {
            Logger.getLogger(IMCUserRequest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
