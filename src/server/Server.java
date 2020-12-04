package server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private static ServerSocket serverSocket;
    protected static Socket clientSocket;
    public static void main(String[] args) throws Exception {
        System.out.println("Empieza ejecucion server");

        inicioConexionCliente();
        Thread pantalla = new Thread(new Pantalla());
        Thread teclado = new Thread(new Teclado());
        pantalla.start();
        teclado.start();

        pantalla.join();
        teclado.join();
        clientSocket.close();

    }

    private static void inicioConexionCliente() throws IOException {
        serverSocket = new ServerSocket(9999);
        clientSocket = serverSocket.accept();
        System.out.println("Aceptada conexión con cliente");
    }
}
