package org.web.vote.servlet;

import org.web.vote.bean.Option;
import org.web.vote.bean.Subject;
import org.web.vote.bean.User;
import org.web.vote.bean.Vote;
import org.web.vote.service.VoteService;
import org.web.vote.service.VoteServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

public class VoteServlet extends DispatchServlet{
    public VoteService vService = new VoteServiceImpl();
    public void getListAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        List list = new ArrayList();
        list = vService.getListAll();
        String method = (String) request.getSession().getAttribute("method");
        System.out.println("method-----------------"+method);
        request.setAttribute("list",list);
        request.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request,response);
       // response.sendRedirect("/WEB-INF/jsp/index.jsp?list="+list+"");
    }
    public void toVote(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        int sid = Integer.parseInt(request.getParameter("sid"));
        String stitle = request.getParameter("stitle");
        int stype = Integer.parseInt(request.getParameter("stype"));
        int optionCount = Integer.parseInt(request.getParameter("optionCount"));
        int userCount = Integer.parseInt(request.getParameter("userCount"));
        List olist = new ArrayList();
        olist = vService.getListAll(sid);
        for (Object obj:olist) {
                Option option = (Option) obj;
            System.out.println(option.toString()+"Servlet+++++++++++++");
        }
        request.setAttribute("stype",stype);
        request.setAttribute("olist",olist);
        request.getRequestDispatcher("/WEB-INF/jsp/vote.jsp").forward(request,response);
        // response.sendRedirect("/WEB-INF/jsp/index.jsp?list="+list+"");
    }

    public void doVote(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        //获取页面传过来的值
        int sid = Integer.parseInt(request.getParameter("sid"));
        String[] options = request.getParameterValues("options");
        int[] oid = new int[options.length];
        for (int i = 0;i<options.length;i++){
            oid[i] = Integer.parseInt(options[i]);
        }
        //查看session中的所有对象
        for (Enumeration e = request.getSession().getAttributeNames();e.hasMoreElements();){
            System.out.println(e.nextElement());

        }
        //获得Session里的User
        User user = (User)request.getSession().getAttribute("User");
        System.out.println(user.toString());
        //封装在Vote对象中
        Vote vote = new Vote();
        vote.setUid(user.getUid());
        vote.setOids(oid);
        vote.setSid(sid);
        System.out.println(vote.toString());
        //判断结果是否投票成功
        if(vService.addVote(vote)>0){
            System.out.println("------------------------------------------------");
            //request.getRequestDispatcher("/WEB-INF/jsp/success.jsp").forward(request,response);
            response.sendRedirect("success.jsp");
        }else{
            System.out.println("..................................");
            request.getRequestDispatcher("error.jsp").forward(request,response);
            //response.sendRedirect("http://localhost/WEB-INF/jsp/error.jsp");
        }

        // response.sendRedirect("/WEB-INF/jsp/index.jsp?list="+list+"");
    }


    public  void addNewVote(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("UTF-8");

        String title = request.getParameter("title");
        int type = Integer.parseInt(request.getParameter("type"));
        String[] options = request.getParameterValues("options");
        Subject subject = new Subject(title,type,options);
        int a = vService.addNewVote(subject);
        if(a>0){
            System.out.println("------------------------------------------------");
            //request.getRequestDispatcher("/WEB-INF/jsp/success.jsp").forward(request,response);
            response.sendRedirect("success.jsp");
        }else{
            System.out.println("..................................");
            request.getRequestDispatcher("error.jsp").forward(request,response);
            //response.sendRedirect("http://localhost/WEB-INF/jsp/error.jsp");
        }

    }

    public  void toManage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        List list = new ArrayList();
        list = vService.getListAll();
        request.setAttribute("list",list);
        request.getRequestDispatcher("/WEB-INF/jsp/manage.jsp").forward(request,response);

    }
    public  void toEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");

        int stype = Integer.parseInt(request.getParameter("stype"));
        String stitle = request.getParameter("stitle");

        List list = new ArrayList();
        int sid = Integer.parseInt(request.getParameter("sid"));
        list = vService.getListAll(sid);
        Subject subject = new Subject(sid,stitle,stype,list);
        request.setAttribute("Subject",subject);
        request.getRequestDispatcher("/WEB-INF/jsp/edit.jsp").forward(request,response);

    }

}
