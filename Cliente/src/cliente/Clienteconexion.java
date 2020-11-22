/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
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

    public void EnviarMensaje(String mensaje) {
        try {
            Socket s = new Socket("localhost", 3333);
            DataInputStream din = new DataInputStream(s.getInputStream());
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String str = "", str2 = "";
            while (!str.equals("stop")) {
                str = br.readLine();
                dout.writeUTF(str);
                dout.flush();
                str2 = din.readUTF();
                System.out.println("Server says: " + str2);
            }

            dout.close();
            s.close();
        } catch (Exception e) {
            System.out.println("Error en cliente");

        }
    }

}
