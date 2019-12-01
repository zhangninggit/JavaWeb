package cn.itcast.web.download;

import cn.itcast.web.utils.DownLoadUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet(urlPatterns = "/downloadServlet")
public class DownloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.获取请求参数
        String filename = request.getParameter("filename");

        //2.使用字节输入流加载文件进内存
        //2.1找到文件服务器路
        /**
         * ServletContext获取的两种方式
         *      1. this.getServletContext(); HttpServlet类中存在getServletContext()方法可以直接获取ServletContext
         *      2. request.getServletContext()  通过request对象获取
         */
        ServletContext servletContext = this.getServletContext();
        String realPath = servletContext.getRealPath("/img/" + filename);

        //2.2用字节流关联
        FileInputStream fileInputStream = new FileInputStream(realPath);

        //3.设置response的响应头
        //3.1设置响应头类型：content-type
        String mimeType = servletContext.getMimeType(filename);
        response.setHeader("content-type",mimeType);

        //3.2设置响应头打开方式:content-disposition
        //解决中文文件名问题
        //1.获取user-agent请求头、
        String header = request.getHeader("user-agent");
        //2.使用工具类方法编码文件名即可
         filename = DownLoadUtils.getFileName(header, filename);

         response.setHeader("content-disposition","attachment;filename="+filename);
        //4.将输入流的数据写出到输出流中
        ServletOutputStream outputStream = response.getOutputStream();
        byte[] buff = new byte[1024 * 8];
        int len = 0;
        while((len = fileInputStream.read(buff)) != -1){
            outputStream.write(buff,0,len);
        }

        fileInputStream.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
