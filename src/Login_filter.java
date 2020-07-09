// Проверяет совпадение полей: имя пользователя и пароль
// Если ок - направляет в /sotrudniki

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpSession;

import java.io.IOException;


@WebFilter("/login_filter")
public class Login_filter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {

        request.setCharacterEncoding("UTF8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");

            if(username.equals("user1") && password.equals("123456")){
              request.getServletContext().getRequestDispatcher("/logindata").forward(request, response);
            }
            else {
                request.setAttribute("login_err", "Wrong userName or passWord");
                request.getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
            }
   }

    @Override
    public void destroy() {

    }



}