package org.scoula.dynamicweb.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = { "/*"})
public class PerformanceFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
            throws IOException, ServletException {
        long start = System.currentTimeMillis();

        // HTTP 요청과 응답으로 캐스팅
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        // 필터 체인을 통해 요청을 계속 진행
        chain.doFilter(request, response);

        long end = System.currentTimeMillis();

        // 요청 메소드와 URI, 실행 시간 로그 출력
        System.out.println(
                request.getMethod() + " : " +
                        request.getRequestURI() + " 실행 시간: " + (end - start) + "ms");
    }

}
