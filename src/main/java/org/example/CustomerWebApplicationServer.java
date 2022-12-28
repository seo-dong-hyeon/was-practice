package org.example;

import org.example.calculator.Domain.Calculator;
import org.example.calculator.Domain.PositiveNumber;
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
                // 사용자 요청이 들어올 때마다 Thread를 새로 생성해서 처리
                // 새로운 요청에 대해서도 이전 요청을 기다리지 않고 처리 가능
                /**
                 * 문제점
                 * 1.Thread 생성 -> 독립적 stack 메모리 할당 -> 성능 하락
                 * 2.동시 접속 증가 -> cpu context switching 증가, 메모리 사용량 증가
                 * 3.서버 리소스 가용성 감소 -> 서버 다운
                 * */
                new Thread(new ClientRequestHandler(clientSocket)).start();
            }
        }
    }
}
