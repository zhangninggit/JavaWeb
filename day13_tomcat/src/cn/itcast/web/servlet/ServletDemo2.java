package cn.itcast.web.servlet;

import javax.servlet.*;
import java.io.IOException;

public class ServletDemo2 implements Servlet {

    /*
    *初始化方法
    * 在Servlet被创建时执行，只会执行一次
    *Servlet的init方法，只执行一次，说明一个Servlet在内存中只存在一个对象，Servlet是单例的
    *
    * */

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init......");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * 提供服务的方法
     * 每一次Servlet被访问时，执行。执行多次。
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("service......");
    }


    /**
     * 获取Servlet的一些信息，版本作者等等...
     * @return
     */
    @Override
    public String getServletInfo() {
        return null;
    }


    /**
     * 销毁方法
     * 在Servlet被杀死时(服务器关闭时)，执行，执行一次。
     */
    @Override
    public void destroy() {
        System.out.println("destroy......");
    }
}
