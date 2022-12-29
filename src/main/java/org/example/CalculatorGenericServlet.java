package org.example;

import org.example.calculator.Domain.Calculator;
import org.example.calculator.Domain.PositiveNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

// Generic 서블릿 -> service만 override 
// 나머지는 필요할 때만 구현
@WebServlet("/calculate-generic")
public class CalculatorGenericServlet extends GenericServlet {

    private static final Logger logger = LoggerFactory.getLogger(CalculatorGenericServlet.class);
    private ServletConfig servletConfig;

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

}
