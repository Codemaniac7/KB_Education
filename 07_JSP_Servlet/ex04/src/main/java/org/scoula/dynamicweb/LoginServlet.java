package org.scoula.dynamicweb;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // MIME 타입 설정
        response.setContentType("text/html;charset=UTF-8");

        String userid = request.getParameter("userid");
        String password = request.getParameter("passwd");

        // 응답 내보내기
        response.setContentType("text/html;charset=UTF-8");

        // 자바 I/O
        PrintWriter out = response.getWriter();

        // html 작성 및 출력
        out.print("<html><body>");
        out.print("아이디값: " +  userid + "<br>");
        out.print("비밀번호값: " +  password + "<br>");
        out.print("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setCharacterEncoding("UTF-8");
        super.doGet(req, resp);
    }
}
