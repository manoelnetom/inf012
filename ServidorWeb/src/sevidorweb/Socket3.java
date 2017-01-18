package sevidorweb;

import java.net.*;
import java.io.*;
import java.util.*;

public class Socket3 {
  public static void main(String[] args) {
//    String server = "www.whitehouse.net";
    String server = "127.0.0.1";
    int port = 13; // porta da hora/dia
    try {
      // obtem socket e conecta
      Socket socket = new Socket(server, port);
      System.out.println("Obtive socket");
      // Obtém um stream de entrada
      BufferedReader inputStream =
          new BufferedReader(new InputStreamReader(
          socket.getInputStream()));
      System.out.println("Hora na www.whitehouse.net:");
      System.out.println(inputStream.readLine());
      System.out.println("Hora em Salvador epicentro do universo:");
      System.out.println(new Date());
      // fecha socket
      socket.close();
    } // fim de try
    catch (UnknownHostException e) {
      System.out.println(e);
      System.out.println("Tem de estar conectado");
    } // fim do catch UnknownHostException
    catch (IOException e) {
      System.out.println(e);
    }
  } // fim do main
} // fim
