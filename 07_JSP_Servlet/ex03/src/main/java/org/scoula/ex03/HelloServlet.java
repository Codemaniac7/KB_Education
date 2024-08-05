package org.scoula.ex03;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

//@WebServlet(name = "helloServlet", value = "/hello-servlet")
@WebServlet(name="helloServlet", value={"/xxx", "/yyy"})

public class HelloServlet extends HttpServlet {
    private String message;


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("init-------------");
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("destroy-------------");
    }
}