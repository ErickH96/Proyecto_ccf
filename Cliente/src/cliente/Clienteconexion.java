/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author marvi
 */
public class Clienteconexion {

    int puerto;
    Socket s;

    public Clienteconexion(int puerto) {
        this.puerto = puerto;

    }

    public void Conectar() {
        try {
            s = new Socket("localhost", 6666);
            DataOutputStream d = new DataOutputStream(s.getOutputStream());
            d.writeUTF("Hola");
            d.flush();
            d.close();
            s.close();
        } catch (Exception e) {
            System.out.println("Error en cliente");
            
          
        }
    }

}
