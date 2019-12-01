package cn.itcast.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 服务器输出字符数据到浏览器
 * * 步骤：
 * 				1. 获取字符输出流
 * 				2. 输出数据
 *
 * 			* 注意：
 * 				* 乱码问题：
 * 					1. PrintWriter pw = response.getWriter();获取的流的默认编码是ISO-8859-1
 * 					2. 设置该流的默认编码
 * 					3. 告诉浏览器响应体使用的编码
 *
 * 					//简单的形式，设置编码，是在获取流之前设置
 *         			response.setContentType("text/html;charset=utf-8");
 */

@WebServlet(urlPatterns = "/responseDemo3")
public class ResponseDemo3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        response.setContentType("text/html;charset=utf-8"); // 告诉浏览器要使用的编码格式
        PrintWriter writer = response.getWriter();

        writer.write("大家好！热部署");
    }
}
