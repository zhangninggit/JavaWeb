package cn.itcast.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(urlPatterns = "/cookieTest")
public class CookkieTest extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=utf-8");
        // 1. 获取所有cookie
        Cookie[] cookies = req.getCookies();
        boolean flag = false; // 没有cookie名称为lastTime
        // 2.遍历cookie数组
        if(cookies != null && cookies.length > 0){
            for (Cookie cookie : cookies) {
                // 3.获取cookie名称
                String name = cookie.getName();
                // 4.判断名称是否为lastTime
                if("lastTime".equals(name)){
                    // 存在名字为lastTime的cookie

                    flag = true;

                    // 设置cookie的value
                    // 获取当前时间的字符串
                    Date date = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                    String str_date = sdf.format(date);
                    System.out.println("编码前:"+str_date);
                    // URL编码
                     str_date = URLEncoder.encode(str_date, "utf-8");
                    System.out.println("编码后:"+str_date);
                    cookie.setValue(str_date);
                    // 设置cookie存活时间
                    cookie.setMaxAge(60*60*24*30); // 存活一个月
                    resp.addCookie(cookie);

                    //响应数据
                    //获取Cookie的value，时间
                    String value = cookie.getValue();
                    System.out.println("解码前："+value);
                    //URL解码：
                    value = URLDecoder.decode(value,"utf-8");
                    System.out.println("解码后："+value);
                    resp.getWriter().write("<h1>欢迎回来，您上次访问时间为:"+value+"</h1>");


                    break;

                }

            }
        }

        if(cookies == null || cookies.length == 0 || flag == false){
            //没有，第一次访问

            //设置Cookie的value
            //获取当前时间的字符串，重新设置Cookie的值，重新发送cookie
            Date date  = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
            String str_date = sdf.format(date);
            System.out.println("编码前："+str_date);
            //URL编码
            str_date = URLEncoder.encode(str_date,"utf-8");
            System.out.println("编码后："+str_date);

            Cookie cookie = new Cookie("lastTime",str_date);
            //设置cookie的存活时间
            cookie.setMaxAge(60 * 60 * 24 * 30);//一个月
            resp.addCookie(cookie);

            resp.getWriter().write("<h1>您好，欢迎您首次访问</h1>");
        }

    }

}
