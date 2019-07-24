package cn.itcast.web.servlet.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/requestDemo1")
public class RequestDemo1 extends HttpServlet {

    /**
     *  // 获取请求行
     * 	* 方法：
     * 			1. 获取请求方式 ：GET
     * 	    		* String getMethod()
     * 			2. (*)获取虚拟目录：/day14
     * 					* String getContextPath()
     * 			3. 获取Servlet路径: /demo1
     *					* String getServletPath()
     * 			4. 获取get方式请求参数：name=zhangsan
     * 					* String getQueryString()
     * 			5. (*)获取请求URI：/day14/demo1
     * 					* String getRequestURI():		/day14/demo1
     * 					* StringBuffer getRequestURL()  :http://localhost/day14/demo1
     *
     * 					* URL:统一资源定位符 ： http://localhost/day14/demo1	中华人民共和国
     * 					* URI：统一资源标识符 : /day14/demo1					共和国
     *
     * 			6. 获取协议及版本：HTTP/1.1
     * 					* String getProtocol()
     *
     * 			7. 获取客户机的IP地址：
     * 					* String getRemoteAddr()
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 1. 获取请求方式 ：GET
        String method = req.getMethod();
        System.out.println(method);


        // 2. (*)获取虚拟目录：/day14
        System.out.println("-----------------------");

        String contextPath = req.getContextPath();
        System.out.println(contextPath);

        // 3. 获取Servlet路径: /requestDemo1
        System.out.println("-----------------------");
        String servletPath = req.getServletPath();
        System.out.println(servletPath);

        // 4. 获取get方式请求参数：name=zhangsan
        System.out.println("-----------------------");
        String queryString = req.getQueryString();
        System.out.println(queryString);

        // 5. (*)获取请求URI：/day14/requestDemo1
        System.out.println("-----------------------");
        StringBuffer requestURL = req.getRequestURL();
        System.out.println(requestURL);

        System.out.println("-----------------------");

        String requestURI = req.getRequestURI();
        System.out.println(requestURI);

        // 6. 获取协议及版本：HTTP/1.1
        System.out.println("------------------------");
        String protocol = req.getProtocol();
        System.out.println(protocol);

        // 7. 获取客户机的IP地址
        System.out.println("-------------------------");
        String remoteAddr = req.getRemoteAddr();
        System.out.println(remoteAddr);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
