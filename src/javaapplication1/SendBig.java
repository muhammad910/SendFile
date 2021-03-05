
package javaapplication1;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author rizka
 */
public class SendBig {

    public static File f = null;

    public static void main(String[] args) throws IOException {

        int Port = Integer.parseInt(JOptionPane.showInputDialog("Masukkan Port"));

        ServerSocket servsock = new ServerSocket(Port);
        JFileChooser file = new JFileChooser();
        file.setMultiSelectionEnabled(true);
        file.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        if (file.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            f = file.getSelectedFile();

        }
        Socket sock = servsock.accept();

        //kirim data keluar
        BufferedOutputStream bos = new BufferedOutputStream(sock.getOutputStream());

        //untuk membaca file yang ada dalam harddisc(direktory)
        FileInputStream fis = new FileInputStream(f);

        BufferedInputStream bis = new BufferedInputStream(fis);

        int n;
        byte[] buffer = new byte[4096];
        try {
            while ((n = bis.read(buffer)) > 0) {
//                        System.out.println(n);
                bos.write(buffer, 0, n);
                bos.flush();
            }
        } catch (Exception e) {
        }

    }

}
