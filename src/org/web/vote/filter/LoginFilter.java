package org.web.vote.filter;

import com.sun.deploy.net.HttpRequest;
import org.web.vote.bean.User;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.util.Enumeration;

public class LoginFilter extends HttpServlet implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }
    @Override
    public void destroy() {
        super.destroy();
    }
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String meth = request.getParameter("meth");
        User user = (User)request.getSession().getAttribute("User");
        if(user != null){
            if(meth.equals("addVote")||meth.equals("toManage")){
                System.out.println(user.toString());
                if(!(user.getStatus()==2)){
                    request.getRequestDispatcher("error.jsp").forward(request,response);
                }
            }

        }else {
            request.getRequestDispatcher("error.jsp").forward(request,response);        }
        filterChain.doFilter(request,response);

    }
}
