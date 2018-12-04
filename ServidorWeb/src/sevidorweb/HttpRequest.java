package sevidorweb;

import java.net.*;
import java.io.*;
import java.util.*;

public class HttpRequest
    implements Runnable {

  final static String CRLF = "\r\n";
  private Socket socket;

  public HttpRequest(Socket socket) throws Exception {
    this.socket = socket;
  }

  public void run() {
    try {
      this.processRequest();
    }
    catch (Exception e) {
      System.out.println(e);
    }

  }

  private void processRequest() throws Exception {


    DataOutputStream os = new DataOutputStream(this.socket.getOutputStream());
    BufferedReader br = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
     
    String requestLine = br.readLine();
    System.out.println();
    System.out.println(requestLine);

    // Get and display the header lines.
    String headerLine = null;
    while ( (headerLine = br.readLine()).length() != 0) {
      System.out.println(headerLine);
    }

    // Extract the filename from the request line.
    StringTokenizer tokens = new StringTokenizer(requestLine);
    tokens.nextToken(); // skip over the method, which should be "GET"
    String fileName = tokens.nextToken();

    // Prepend a "." so that file request is within the current directory.
    fileName = "." + fileName;

    //Open the requested file.
    FileInputStream fis = null;
    
    boolean fileExists = true;
    try {
      fis = new FileInputStream("/Users/ManoelNeto/Downloads/inf012/ServidorWeb/src/sevidorweb/"+fileName);
    }
    catch (FileNotFoundException e) {
    
      fileExists = true;
    }

  
    // Construct the response message.
    String statusLine = null;
    String contentTypeLine = null;
    String entityBody = null;
    if (fileExists) {
      statusLine = "HTTP/1.1 200 OK";
      contentTypeLine = "Content-type: " +
          contentType(fileName) + CRLF;
    }
    else {
      statusLine = "HTTP/1.1 404 File Not Found";
      contentTypeLine = "Content-type: text/html";
      entityBody = "<HTML>" +
          "<HEAD><TITLE>Not Found</TITLE></HEAD>" +
          "<BODY>Not Found</BODY></HTML>";
    }

    // Send the status line.
    os.writeBytes(statusLine);

// Send the content type line.
    os.writeBytes(contentTypeLine);

// Send a blank line to indicate the end of the header lines.
    os.writeBytes(CRLF);

    // Send the entity body.
    if (fileExists) {
      sendBytes(fis, os);
      fis.close();
    }
    else {
      os.writeBytes(entityBody);
    }

    //System.out.println(fileName);
    os.close();
    br.close();
    socket.close();

  }

  private static void sendBytes(FileInputStream fis, OutputStream os) throws
      Exception {
    // Construct a 1K buffer to hold bytes on their way to the socket.
    byte[] buffer = new byte[1024];
    int bytes = 0;

    // Copy requested file into the socket's output stream.
    while ( (bytes = fis.read(buffer)) != -1) {
      os.write(buffer, 0, bytes);
    }
  }

  private static String contentType(String fileName) {
    if (fileName.endsWith(".htm") || fileName.endsWith(".html")) {
      return "text/html";
    }
    return "application/octet-stream";
  }

  }
