package pl.sda.shop.web;


import javax.servlet.*;
import java.io.IOException;


public class LogFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println(request.getRemoteAddr());
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
