package cn.itcast.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/responseDemo1")
public class ResponseDemo1 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**
         * 1. 完成重定向
         * 			* 重定向：资源跳转的方式
         * 			* 代码实现：
         * 				//1. 设置状态码为302
         * 		        response.setStatus(302);
         * 		        //2.设置响应头location
         * 		        response.setHeader("location","/day15/responseDemo2")
         *
         *          * 重定向的特点:redirect
         * 				1. 地址栏发生变化
         * 				2. 重定向可以访问其他站点(服务器)的资源
         * 				3. 重定向是两次请求。不能使用request对象来共享数据
         * 			* 转发的特点：forward
         * 				1. 转发地址栏路径不变
         * 				2. 转发只能访问当前服务器下的资源
         * 				3. 转发是一次请求，可以使用request对象来共享数据
         *
         */
        System.out.println("demo111111111111");
      /*  resp.setStatus(302);
        resp.setHeader("location","/day15/responseDemo2");*/

        int i = 1;
        req.setAttribute("i",i);
        resp.sendRedirect("/day15/responseDemo2"); // Redirect重定向
    }
}
