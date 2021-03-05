package javaapplication1;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author rizka
 */
public class receiveBig {

    private static File f = null;

    public static void main(String[] args) throws IOException {

        int Port = Integer.parseInt(JOptionPane.showInputDialog("Masukkan Port : "));
        String IP = JOptionPane.showInputDialog("Masukkan IP");

        JFileChooser file = new JFileChooser();
        file.setMultiSelectionEnabled(true);
        file.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        if (file.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            f = file.getSelectedFile();

        }

        Socket sock = new Socket(IP, Port);
        BufferedInputStream bis = new BufferedInputStream(sock.getInputStream());
        FileOutputStream fos = new FileOutputStream(f);

        BufferedOutputStream bos = new BufferedOutputStream(fos);

//        JOptionPane.showMessageDialog(null, "Connected");

        int n;
        byte[] buffer = new byte[4096];
        try {
            while ((n = bis.read(buffer)) > 0) {
//                System.out.println(n);
                bos.write(buffer, 0, n);

                bos.flush();
            }
        } catch (Exception e) {
            //It will land here....
        }

//        JOptionPane.showMessageDialog(null, "File Received");

    }

}
