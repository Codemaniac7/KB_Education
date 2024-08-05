package org.scoula.dynamicweb;

import org.scoula.dynamicweb.domain.Member;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet("/jstl_ex")
public class JstlServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // MIME 타입 설정
        response.setContentType("text/html;charset=UTF-8");

        List<Member> members = new ArrayList<Member>();
        for(int i=0; i<10; i++){
            Member member = new Member("홍길동_" + i, "hong_" + i);
            members.add(member);
        }
        request.setAttribute("members", members);
        request.setAttribute("role", "ADMIN");

        request.setAttribute("today", new Date());

        request.getRequestDispatcher("jstl_ex.jsp").forward(request, response);

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
