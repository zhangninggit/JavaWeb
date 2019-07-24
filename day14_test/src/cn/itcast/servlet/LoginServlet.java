package cn.itcast.servlet;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");


        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User loginUser = new User();
        loginUser.setUsername(username);
        loginUser.setPassword(password);

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
