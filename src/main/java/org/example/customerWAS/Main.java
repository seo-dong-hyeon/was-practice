package org.example.customerWAS;

import java.io.IOException;

// GET /calculate?operand1=11&operator=*&operand2==55
// 클라이언트 -> 요청 메시지(request line, header, blank line, body) -> 서버
// 서버 -> 응답 메시지(Status line, header, blank line, body) -> 클라이언트
public class Main {
    public static void main(String[] args) throws IOException {
        new CustomerWebApplicationServer(8080).start();
    }
}