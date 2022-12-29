package org.example.customerWAS;

import java.io.BufferedReader;
import java.io.IOException;

public class HttpRequest {
    private final RequestLine requestLine;
//    private final HttpHeaders httpHeaders;
//    private final Body body;

    public HttpRequest(BufferedReader br) throws IOException {
        // 프로토콜의 첫번째 라인 -> request line
        //this.requestLine = new RequestLine("GET /calculate?operand1=20&operator=-&operand2=55 HTTP");
         this.requestLine = new RequestLine(br.readLine());
    }

    public boolean isGetRequest() {
        return requestLine.isGetRequest();
    }

    public boolean matchPath(String requestPath){
        return requestLine.matchPath(requestPath);
    }

    public QueryStrings getQueryStrings() {
        return requestLine.getQueryStrings();
    }
}
