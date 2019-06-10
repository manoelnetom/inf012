/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clientes;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author manoel
 */
public class Cliente {

    private Socket socket;
    private File arquivo;

    public File getArquivo() {
        return arquivo;
    }
    
    

    public void setArquivo(File arquivo) {
        this.arquivo = arquivo;
    }

    public void setConnection(String ip, int porta) throws Exception {
        this.socket = new Socket(ip, porta);

    }

    public void closeConnection() throws Exception {
        this.socket.close();

    }

    public void sendFile() throws Exception {
        Thread.sleep(1000); 
        OutputStream os = this.socket.getOutputStream();
        PrintWriter out=new PrintWriter(os,true);//Filtro de Escrita 
        out.println(arquivo.getName());//Envia Nome do arquivo "String" 
        FileInputStream fis = new FileInputStream(arquivo);
        byte[] buffer = new byte[1024];
        int bytes;

        while ((bytes = fis.read(buffer)) != -1) {
            System.out.println(">"+bytes);
            os.write(buffer, 0, bytes);
        }
        out.close();
        fis.close();
        os.close();
        this.socket.close();
    }
}
