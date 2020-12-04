package client;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Client {

    protected static Socket clientSocket;

    public static void main(String[] args) throws Exception {
        conexionConServer();
       Thread pantalla = new Thread(new Pantalla());
       Thread teclado = new Thread(new Teclado());
       pantalla.start();
       teclado.start();

       pantalla.join();
       teclado.join();
       clientSocket.close();

    }

    private static void conexionConServer() throws IOException {
        System.out.println("Arranco cliente");
        //Abro conexión
        clientSocket = new Socket(InetAddress.getByName(null), 9999);
        System.out.println("Cliente dice: conexion establecida con servidor");
    }
}
