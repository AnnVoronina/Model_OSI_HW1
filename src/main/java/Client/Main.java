package Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        String localHost = "127.0.0.1"; // локальный хост
        int port = 8089;

        try (Socket clientSocket = new Socket(localHost, port); //подключаемся клиентским сокетом передаем порт и хост
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true); //поток по символьного чтения
             BufferedReader in = new BufferedReader( // поток посимвольной записи
                     new InputStreamReader(clientSocket.getInputStream()))) {
            out.println("Bla bla");
            String resp = in.readLine(); // читаем ответ от сервера
            System.out.println(resp);
        }catch (IOException exception){
            exception.printStackTrace();
        }
    }
}
