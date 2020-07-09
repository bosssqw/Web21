//Добавляет в сессию переменные username, autorized

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.*;
import java.util.*;

@WebServlet("/logindata")
public class LoginData extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException{

        request.setCharacterEncoding("UTF8");
        String username = request.getParameter("username");

        HttpSession session = request.getSession();

        session.setAttribute("username",username);
        session.setAttribute("autorized",true);

        getServletContext().getRequestDispatcher("/sotrudniki").forward(request, response);
    }
}