package cn.itcast.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class FilterDemo2 implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("FliterDemo2拦截了请求...");
        chain.doFilter(req, resp);
        System.out.println("FliterDemo2允许请求通过了");

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
