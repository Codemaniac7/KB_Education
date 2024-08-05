<%@ page import="java.io.PrintWriter" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="true" %>
<%
    // 'session' 객체를 사용하기 위해서는 'session' 지시어가 필요합니다.
    // 'request'와 'response' 객체는 JSP에서 자동으로 제공됩니다.

    // 사용자 입력 데이터 가져오기
    String id = request.getParameter("userid");

    // 아이디가 null일 경우 로그인 페이지로 리다이렉트
    if (id == null || id.isEmpty()) {
        response.sendRedirect("loginForm.html");
    } else {
        // 비밀번호 가져오기
        String pw = request.getParameter("password");

        // 세션에 사용자 정보 저장
        session.setAttribute("userid", id);
        session.setAttribute("password", pw);

        // 사용자에게 인사 메시지 출력
        PrintWriter out = response.getWriter();

        out.print("안녕하세요 " + id + "<br>");
        out.print("<a href='loginInfo.jsp'>정보보기</a>");
    }
%>