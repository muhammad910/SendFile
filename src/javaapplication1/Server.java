/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author rizka
 */
public class Server {
    
    public static void main(String[] args) throws IOException {
        
         ServerSocket    server   = new ServerSocket(5000); 
         Socket socket = server.accept();          
         System.out.println("Server started"); 
         
         String pesan="assalamu'alaikum";
         
//         DataInputStream  input   = new DataInputStream(System.in); 
         DataOutputStream out     = new DataOutputStream(socket.getOutputStream()); 
         out.writeUTF(pesan);
         
        
        
    }
    
}
