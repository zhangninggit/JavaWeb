package cn.itcast.web.servlet.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

@WebServlet("/requestDemo7")
public class RequestDemo7 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * 1. 获取请求参数通用方式：不论get还是post请求方式都可以使用下列方法来获取请求参数  传送的参数
         * 		1. String getParameter(String name):根据参数名称获取参数值
         * 		2. String[] getParameterValues(String name):根据参数名称获取参数值的数组  hobby=xx&hobby=game  获取复选框的value值
         * 	           *       <input type="checkbox" name="chx" value="language">语文
         *                    <input type="checkbox" name="chx" value="math">数学
         * 		3. Enumeration<String> getParameterNames():获取所有请求的参数名称
         * 		4. Map<String,String[]> getParameterMap():获取所有参数的map集合
         */

        // 1. String getParameter(String name):根据参数名称获取参数值
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        System.out.println(username);

        System.out.println("----------------------");



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
