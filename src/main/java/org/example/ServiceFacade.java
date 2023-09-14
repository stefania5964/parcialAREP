package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class ServiceFacade {
    /**
     * este metodo es el de fachada
     * @param args
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(37000);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 37000.");
            System.exit(1);
        }

        Socket clientSocket = null;
        try {
            System.out.println("Listo para recibir ...");
            clientSocket = serverSocket.accept();
        } catch (IOException e) {
            System.err.println("Accept failed.");
            System.exit(1);
        }
        PrintWriter out = new PrintWriter(
                clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream()));
        String inputLine, outputLine = null;
        while ((inputLine = in.readLine()) != null) {
            System.out.println("Recibí: " + inputLine);
            if (!in.ready()) {break;
            }else if(inputLine.startsWith("qck")){
                System.out.println("entro: " );
            }

        ReflexCalculator.quic(new Double[]{1.25});
        if (inputLine.startsWith("qck")) {
            double[] inp= todouble(new String[]{String.valueOf(inputLine.length()-1)});
            outputLine = "HTTP/1.1 200 OK\r\n"
                    + "Content-Type: application/json\r\n"
                    + "\r\n"
                    + ReflexCalculator.quic(inp);

        }
        out.println(outputLine);
        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();}





    }

    /**
     * metodo cambia de string a double
     *
     * @param strings
     * @return
     */
    private static double[] todouble(String[] strings) {
        return new double[]{Double.parseDouble(Arrays.toString(strings))};
    }
}
