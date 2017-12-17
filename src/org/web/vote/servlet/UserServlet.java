package org.web.vote.servlet;

import org.web.vote.bean.User;
import org.web.vote.service.UserService;
import org.web.vote.service.UserServiceImpl;

import javax.imageio.ImageIO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class UserServlet extends DispatchServlet{
    public User user = null;
    public UserService uService = new UserServiceImpl();
    public  void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("UTF-8");
        //将页面传过来的值封装到User
        user = new User(request.getParameter("username"),
                request.getParameter("password"));
        System.out.println(user.toString());
        User u = uService.getUser(user);
        if(u != null){
                request.getSession().setAttribute("User",u);
                response.sendRedirect("VoteServlet?meth=getListAll");
        }else {
            String error = "账号或密码不对";
            /*response.sendRedirect("login.jsp?error="+error);*/
            response.getWriter().print(error);
            //跳转到登录页面
            //request.getRequestDispatcher("/login.jsp?error="+error).forward(request, response);
        }
    }


    public  void reg(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("UTF-8");
        //将页面传过来的值封装到User
        User user = new User();
        String name = request.getParameter("username");
        String pwd = request.getParameter("password");
        int age = Integer.parseInt(request.getParameter("age"));
        int sex= Integer.parseInt(request.getParameter("sex"));
        String hobbies = request.getParameter("hobbies");
        String phome = request.getParameter("tel");
        user.setAge(age);
        user.setHobbies(hobbies);
        user.setUname(name);
        user.setPhome(phome);
        user.setUpwd(pwd);
        user.setSex(sex);
        int b = uService.addUser(user);
        System.out.println(b);
        System.out.println(user.toString());
    }


    /**
     * 安全退出
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void retreatsafely(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        //销毁Session
        session.removeAttribute("User");
        response.sendRedirect("login.jsp");

    }


    public void imageCode(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();

        BufferedImage bfi = new BufferedImage(70,40,BufferedImage.TYPE_INT_RGB);
        Random r = new Random();
        Graphics g = bfi.getGraphics();
        Color c = new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255));
        g.setColor(c);
        g.fillRect(0,0,70,40);
        // char ch[] = "qwertyuiopasdgfhjklzxcvbnm1234567890".toCharArray();
        String str = "qwertyuiopasdgfhjklzxcvbnm1234567890";
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < 4; i++){
            int index = r.nextInt(str.length());
            g.setColor(new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255),r.nextInt(255)));
            g.drawString(str.charAt(index) + "",i*15+9, 20);
            sb.append(str.charAt(index));
        }
        request.getSession().setAttribute("code",sb);
        ImageIO.write(bfi,"JPG",response.getOutputStream());
    }
}
