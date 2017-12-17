package org.web.vote.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class DispatchServlet extends HttpServlet{
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       response.setCharacterEncoding("utf-8");
       response.setContentType("text/html");
       request.setCharacterEncoding("utf-8");

       String method = request.getParameter("meth");
        System.out.println(method);
        try {
            Method m = this.getClass().getDeclaredMethod(method,
                    new Class[]{HttpServletRequest.class,HttpServletResponse.class});
            m.invoke(this,new Object[]{request,response});
            request.getSession().setAttribute("method",method);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
