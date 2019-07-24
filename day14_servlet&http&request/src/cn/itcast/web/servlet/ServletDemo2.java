package cn.itcast.web.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;


/**
 * GenericServlet类实现了Servlet接口,对Servlet接口中的方法做了空实现；
 * public abstract void service(ServletRequest var1, ServletResponse var2) throws ServletException, IOException;方法除外
 * 继承GenericServlet类时只需要实现service()方法，其它方法可不实现
 */

@WebServlet(urlPatterns = "/demo2")
public class ServletDemo2 extends GenericServlet {

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("继承GenericServlet...");
    }
}
