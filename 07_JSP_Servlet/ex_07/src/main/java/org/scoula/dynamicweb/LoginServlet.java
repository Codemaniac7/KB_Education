package org.scoula.dynamicweb;

import org.scoula.dynamicweb.domain.Member;
import org.scoula.dynamicweb.dto.LoginDTO;

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
        String passwd = request.getParameter("passwd");

        LoginDTO loginDTO = new LoginDTO(userid, passwd);

        HttpSession session = request.getSession();
        Member member = new Member("홍길동", userid);
        session.setAttribute("user", member);

        request.setAttribute("userid", userid);
        request.setAttribute("passwd", passwd);

        request.setAttribute("login", loginDTO);

        request.getRequestDispatcher("login.jsp").forward(request, response);

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
