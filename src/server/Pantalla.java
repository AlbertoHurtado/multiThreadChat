package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static server.Server.clientSocket;


public class Pantalla implements Runnable {
    @Override
    public void run() {
        String line ="";
        while(!line.equals("*")){
            try {
                line = leoCliente();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(line);
        }
    }

    private static String leoCliente() throws IOException {
        //leo del cliente
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String line = bufferedReader.readLine();
        return line;
    }
}
