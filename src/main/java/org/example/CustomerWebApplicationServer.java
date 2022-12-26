package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class CustomerWebApplicationServer {

    private final int port;

    private static final Logger logger = LoggerFactory.getLogger(CustomerWebApplicationServer.class);

    public CustomerWebApplicationServer(int port) {
        this.port = port;
    }

    public void start() throws IOException {
        // 해당 포트로 서버를 띄움
        try(ServerSocket serverSocket = new ServerSocket(port)){
            logger.info("[CustomerWebApplicationServer] started {} port.", port);

            Socket clientSocket;
            logger.info("[CustomerWebApplicationServer] waiting for client.");

            // 클라이언트 소켓을 기다림
            while ((clientSocket = serverSocket.accept()) != null){
                logger.info("[CustomerWebApplicationServer] connected!");

                // 요청 -> Spring에 요청
                // 톰캣 역할
                try(InputStream in = clientSocket.getInputStream(); OutputStream out = clientSocket.getOutputStream()){
                    // InputStream -> Reader -> Buffer reader -> line by line으로 읽어오기 가능
                    BufferedReader br = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));
                    DataOutputStream dos = new DataOutputStream(out);

                    // 프로토콜
                    String line;
                    while ((line = br.readLine()) != ""){
                        System.out.println(line);
                    }
                }
            }
        }
    }
}
