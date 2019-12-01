package cn.itcast.filter;

import javax.servlet.*;
import java.io.IOException;

public class FilterDemo1 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("FliterDemo1拦截了请求...");
        filterChain.doFilter(servletRequest,servletResponse);  // 允许请求通过
        System.out.println("FliterDemo1允许请求通过了");
    }

    @Override
    public void destroy() {

    }
}
