package cn.itcast.web.servlet.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(urlPatterns = "/requestDemo2")
public class RequestDemo2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**
         * 2. 获取请求头数据
         * 	  * 方法：
         * 			* (*)String getHeader(String name):通过请求头的名称获取请求头的值
         * 		            * name:指定的请求头	User-Agent Accept等等...
         * 			* Enumeration<String> getHeaderNames():获取所有的请求头名称
         */
        String header = req.getHeader("User-Agent");
        System.out.println(header);

        System.out.println("------------------------------");

        // Enumeration内部原理与迭代器iterator类似,req对象却不类似集合
        Enumeration<String> headerNames = req.getHeaderNames();



        while (headerNames.hasMoreElements()){
            String s = headerNames.nextElement();
           // System.out.println(s);

            String header1 = req.getHeader(s);
            System.out.println(s+"--->"+header1);
        }



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
