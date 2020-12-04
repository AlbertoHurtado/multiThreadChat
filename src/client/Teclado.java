package client;

import java.io.*;

import static client.Client.clientSocket;

public class Teclado implements Runnable{
    @Override
    public void run() {
        String line= "";
        while(!line.equals("*")){
            try {
                line = leoDeTeclado();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                escriboEnSocket(line);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    private static String leoDeTeclado() throws IOException {
        //leo de teclado
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        return bufferedReader.readLine();
    }

    private static void escriboEnSocket(String line) throws IOException {
        //creo writer para escribir en socket
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
        OutputStreamWriter byteWriter = new OutputStreamWriter(clientSocket.getOutputStream());

        //Escribo en socket
        bufferedWriter.write(line);
        bufferedWriter.newLine();
        bufferedWriter.write(line);
        bufferedWriter.flush();
    }

}
