package ru.job4j.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            boolean isWork = true;
            while (isWork) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str;
                    String msg = "Привет";
                    while (!(str = in.readLine()).isEmpty()) {
                        if (str.equals("GET /?msg=Bye HTTP/1.1")) {
                            isWork = false;
                        }
                        if (str.startsWith("GET")) {
                            String[] strings = str.split(" ");
                            String[] strings1 = strings[1].split("=");
                            msg = strings1[1];
                        }
                        System.out.println(str);
                    }
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    out.write(msg.getBytes());
                }
            }
        }
    }
}

