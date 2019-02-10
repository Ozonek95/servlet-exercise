package pl.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Set;

@WebServlet(urlPatterns = "/CalculationServlet")
public class CalculationServlet extends HttpServlet {

    private static final String SESSION_SUM = "sum";
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        updateSum(request, session);
        PrintWriter writer = response.getWriter();
        writer.write(String.format("Current sum is: %s", String.valueOf(session.getAttribute(SESSION_SUM))));
    }

    private void updateSum(HttpServletRequest request, HttpSession session) {
        if (session.getAttribute(SESSION_SUM) != null) {
            double currentSum = (double) session.getAttribute(SESSION_SUM);
            session.setAttribute(SESSION_SUM, currentSum + getSum(request));
        } else {
            session.setAttribute(SESSION_SUM,getSum(request));
        }
    }

    private double getSum(HttpServletRequest request) {
        Map<String, String[]> parameterMap = request.getParameterMap();
        Set<Map.Entry<String, String[]>> entries = parameterMap.entrySet();
        double result = 0;
        for (Map.Entry<String, String[]> entry : entries) {
            String[] value = entry.getValue();
            for (String s : value) {
                try {
                    result += Double.parseDouble(s);
                } catch (Exception ignored) {

                }
            }

        }
        return result;
    }
}
