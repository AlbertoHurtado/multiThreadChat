package server;

import java.io.*;

import static server.Server.clientSocket;

public class Teclado implements Runnable{
    @Override
    public void run() {
        String line ="";
        while(!line.equals("*")){
            try {
                line = leoDeTeclado();
                escriboAlCliente(line);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void escriboAlCliente(String line) throws IOException {
        //creo writer para escribir en socket
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
       // OutputStreamWriter writerBytes = new OutputStreamWriter(clientSocket.getOutputStream());
        //Escribo en pantalla de momento lo comento
        //System.out.println(line);


        //Escribo en socket
       //writerBytes.write("Soy el servidor " + line);
        bufferedWriter.write(line);
        bufferedWriter.newLine();
        bufferedWriter.flush();

    }

    private static String leoDeTeclado() throws IOException {
        //leo de teclado
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        return bufferedReader.readLine();
    }



}
