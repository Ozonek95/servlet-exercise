package pl.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

@WebServlet(urlPatterns = "/RandomServlet")
public class RandomNumberServlet extends HttpServlet {
    Random random = new Random();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<body>");
        writer.println("<ul>");
        for (int i=0;i<5;i++){
            writer.println("<li>"+random.nextInt((250)+50)+"</li>");
        }
        writer.println("</ul>");
        writer.println("</body>");
        writer.println("</html>");
    }
}
