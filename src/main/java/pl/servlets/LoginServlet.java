package pl.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet(urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        PrintWriter writer = resp.getWriter();
        session.setMaxInactiveInterval(10);
        String name = req.getParameter("name");
            session.setAttribute("name",name);
            writer.write(String.valueOf(session.getAttribute("name")));

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        PrintWriter writer = resp.getWriter();
        if(session.getAttribute("name")==null||session.getAttribute("name").equals("")){
            writer.write("Unknown Name");
        }
         else writer.write(String.valueOf(session.getAttribute("name")));
    }
}
