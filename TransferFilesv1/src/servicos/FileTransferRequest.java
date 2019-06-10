/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author manoel
 */
public class FileTransferRequest implements Runnable {

    private Socket socket;

    public FileTransferRequest(Socket socket) {
        this.socket = socket;
    }
    
    
    
    @Override
    public void run() {
        try {
            BufferedReader ler=new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            String nome=ler.readLine();
            this.receiveFile(new File(nome), this.socket.getInputStream());
            ler.close();
        } catch (Exception ex) {
            Logger.getLogger(FileTransferRequest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void receiveFile(File arquivo, InputStream is) throws Exception {

        FileOutputStream fos = new FileOutputStream(arquivo);
        byte[] buffer = new byte[1024];
        int bytes;

        while ((bytes = is.read(buffer)) != -1) {
            fos.write(buffer, 0, bytes);
        }
        is.close();
        fos.close();
        this.socket.close();
    }
}
