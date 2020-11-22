/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

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
            socketserver = new ServerSocket(puerto);
            Socket socket = socketserver.accept();
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            System.out.println((String) dis.readUTF());
            socketserver.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
