package sevidorweb;

import java.net.*;


public class WebServer {
  public static void main(String[] args)throws Exception {
    int port = 8080;
    System.out.println("Servidor Web nor ar rodando na porta 8080...");
    ServerSocket serv= new ServerSocket(port);
    while (true) {
      Socket listem=serv.accept();
      Thread t=new Thread(new HttpRequest(listem));
      t.start();
    }
  }
}
