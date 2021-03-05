/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author rizka
 */
public class Client {
    public static void main(String[] args) throws IOException {
         Socket socket = new Socket("localhost", 5000); 
         
         DataInputStream input=new DataInputStream(socket.getInputStream());
         String a= input.readUTF();
         System.out.println(a);
    }
}
