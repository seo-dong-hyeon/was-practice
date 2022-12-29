package org.example;

import org.example.calculator.Domain.Calculator;
import org.example.calculator.Domain.PositiveNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

// 서블릿 객체 -> 싱글톤으로 관리 -> 인스턴스 하만 생성해서 공유
@WebServlet("/calculate")
public class CalculatorServlet implements Servlet {

    private static final Logger logger = LoggerFactory.getLogger(CalculatorServlet.class);
    private ServletConfig servletConfig;

    // 처음 생성됐을 때만 호출
    @Override
    public void init(ServletConfig config) throws ServletException {
        logger.info("init");
        this.servletConfig = servletConfig;
    }

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        logger.info("service");
        int operand1 = Integer.parseInt(request.getParameter("operand1"));
        String operator = request.getParameter("operator");
        int operand2 = Integer.parseInt(request.getParameter("operand2"));

        int result = Calculator.calculate(new PositiveNumber(operand1), operator, new PositiveNumber(operand2));
        PrintWriter writer = response.getWriter();
        writer.println(result);
    }

    @Override
    public void destroy() {
        // resource release
    }

    @Override
    public ServletConfig getServletConfig() {
        return this.servletConfig;
    }

    @Override
    public String getServletInfo() {
        return null;
    }

}
