package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import static java.lang.System.*;

public class Main {

    // сервер слушает порт, который мы ему укажем
    public static void main(String[] args) throws IOException {

        out.println("server started");
        int port = 8089; // порт можно выбрать любой в доступном диапазоне 0-65536

// серверный сокет ждет подключения на сервер в режиме слушателя, для
        ServerSocket serverSocket = new ServerSocket(port); // этот метод может выбросить исключение IOException
        while (true) { // бесконечный цикл который слушает порт
            Socket clientSocket = serverSocket.accept(); // для блокирующего ожидания используется метод accept, как только вернется значение будет создат клиентский сокет  для работы с этим подключением
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),true);// у клиентского сокета есть потоки ввода вывода, через который можно с ним рабоатть т е можем прочитать из одного потока и записать в другой
            //серверс сокет использует TCP протокол в качестве транспорта для этого нам понадобится датограммсокет класс????

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            System.out.println("New connection accepted. Port: " + clientSocket.getPort());

            final String name = in.readLine(); // читаем строку с клиента

            out.println("Hi " + name +  ", your port is:"+ clientSocket.getPort()); // отвечаем клиента
            //порт будет приходить все время разный т.к. какой система выделила такой и будет


        }
    }
}