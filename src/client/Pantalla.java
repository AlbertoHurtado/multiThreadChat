package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static client.Client.clientSocket;

public class Pantalla implements Runnable {
    @Override
    public void run() {
        String line= "";
        while(!line.equals("*")){
            try {
                escriboRespuestaDelServer();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void escriboRespuestaDelServer() throws IOException {
        BufferedReader socketReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        //La escribo en pantalla
        String answer = socketReader.readLine();
        System.out.println(answer);
    }
}
