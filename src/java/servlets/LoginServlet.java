package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.*;

/**
 *
 * @author jerma
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("logout") != null) {
            request.setAttribute("logoutmessage", "true");
            session.removeAttribute("logout");
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
                 .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        request.setAttribute("invalid", "false");
        
        if (username == null || username == "" || password == null || password == "") {
            request.setAttribute("invalid", "true");
            request.setAttribute("username", username);
            request.setAttribute("password", password);
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
                 .forward(request, response);
        }
        
        AccountService as = new AccountService();
        User user = as.login(username, password);
        
        if (user != null) {
            session.setAttribute("name", user.getUsername());
            session.setAttribute("logout", "true");
            getServletContext().getRequestDispatcher("/WEB-INF/home.jsp")
                 .forward(request, response);
        } else {
            request.setAttribute("wronglogin", "true");
            request.setAttribute("username", username);
            request.setAttribute("password", password);
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
                 .forward(request, response);
        }
    }

}
