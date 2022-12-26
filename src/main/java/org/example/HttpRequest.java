package org.example;

import java.io.BufferedReader;
import java.io.IOException;

public class HttpRequest {

    private final RequestLine requestLine;

    public HttpRequest(BufferedReader br) throws IOException {
        // 프로토콜의 첫번째 라인 -> request line
        this.requestLine = new RequestLine(br.readLine());
    }
}
