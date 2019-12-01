package cn.itcast.web.servlet;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet(urlPatterns = "/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");


      /*  String username = request.getParameter("username");
        String password = request.getParameter("password");

        User loginUser = new User();
        loginUser.setUsername(username);
        loginUser.setPassword(password);*/


        User loginUser = new User();
        // 将属性名和属性值等装到map集合中 key为属性名，value为属性值
        Map<String, String[]> map = request.getParameterMap();
        try {
            // 自动解析map集合，将map集合封装到Javabean中，通过map的key确定调用的setter方法
            BeanUtils.populate(loginUser,map);

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        UserDao uDao = new UserDao();
        User user = uDao.login(loginUser);

        if (user != null){
            // 登录成功
            request.setAttribute("User",user);
            request.getRequestDispatcher("/successServlet").forward(request,response);

        }else{
            // 登录失败
            request.getRequestDispatcher("/faildServlet").forward(request,response);

        }

        //   request.setAttribute("loginUser",loginUser);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
