package org.scoula.dynamicweb.cookie;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/cart_view_cookie")
public class CartViewCookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // MIME 타입 설정
        response.setContentType("text/html;charset=UTF-8");

        // 자바 I/O
        PrintWriter out = response.getWriter();
        out.print("<html><body>");
        out.print("장바구니 리스트<br>");

        Cookie [] cookies = request.getCookies();

        if (cookies != null) {
            for(Cookie c : cookies) {
                out.print(c.getName()+ " : " + c.getValue() + "<br>");
            }
        } else {
            out.print("장바구니 비었음<br>");
        }
        out.print("<a href='cookie_product.jsp'>상품 선택 페이지</a>");
        out.print("<a href='cart_delete_cookie'>장바구니 비우기</a>");
        out.print("</body></html>");
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
