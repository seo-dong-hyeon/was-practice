package org.example;

import org.example.calculator.Domain.Calculator;
import org.example.calculator.Domain.PositiveNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

// Http 서블릿 -> get 요청 시엔 doGet, post 요청 시엔, doPost -> 요청마다 메소드 구현
// 톰캣 -> service 메소드 호출
// Http service 메소드 -> 내부적으로 if 문에서 처리
@WebServlet("/calculate-http")
public class CalculatorHttpServlet extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(CalculatorHttpServlet.class);
    private ServletConfig servletConfig;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("service");
        int operand1 = Integer.parseInt(request.getParameter("operand1"));
        String operator = request.getParameter("operator");
        int operand2 = Integer.parseInt(request.getParameter("operand2"));

        int result = Calculator.calculate(new PositiveNumber(operand1), operator, new PositiveNumber(operand2));
        PrintWriter writer = response.getWriter();
        writer.println(result);
    }
}
