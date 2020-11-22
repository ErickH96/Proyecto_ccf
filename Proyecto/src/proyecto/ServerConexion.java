/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.*;  
import java.io.*;  

/**
 *
 * @author marvi
 */
public class ServerConexion {

    int puerto;
    ServerSocket socketserver;

    public ServerConexion(int puerto) {
        this.puerto = puerto;
    }

    public void CrearConexion() {
        try {
            ServerSocket ss = new ServerSocket(3333);
            Socket s = ss.accept();
            DataInputStream din = new DataInputStream(s.getInputStream());
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String str = "", str2 = "";
            while (!str.equals("stop")) {
                str = din.readUTF();
                System.out.println("client says: " + str);
                str2 = br.readLine();
                dout.writeUTF(str2);
                dout.flush();
            }
            din.close();
            s.close();
            ss.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
