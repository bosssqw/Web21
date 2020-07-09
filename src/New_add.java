//Получает значения полей сотрудника для добавления их в БД
//Добавляет данные о новом сотруднике в 3 таблицы БД

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet("/new_add")
public class New_add extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException{

        request.setCharacterEncoding("UTF8");

           //Создает соединения с БД dela
            BDconnect con = new BDconnect();
            try (PreparedStatement statement = con.getConnect().prepareStatement(Const.sql5+ Const.sql6+ Const.sql7)) {

                    statement.setInt(1, Integer.parseInt(request.getParameter("new_id")));
                    statement.setString(2, request.getParameter("new_name"));
                    statement.setInt(3, Integer.parseInt(request.getParameter("new_age")));
                    statement.setInt(4, Integer.parseInt(request.getParameter("new_id")));
                    statement.setString(5, request.getParameter("new_adres"));
                    statement.setString(6, request.getParameter("new_rayon"));
                    statement.setString(7, request.getParameter("new_okrug"));
                    statement.setInt(8, Integer.parseInt(request.getParameter("new_id")));
                    statement.setTime(9, Time.valueOf(request.getParameter("new_start")));
                    statement.setTime(10, Time.valueOf(request.getParameter("new_finish")));

                statement.executeUpdate();

            } catch (
                    SQLException ex) {
                ex.printStackTrace();
            }

        response.setContentType("text/html;charset=UTF-8");
        request.setAttribute("added", "Новый сотрудник добавлен в базу");

        getServletContext().getRequestDispatcher("/sotrudniki").forward(request, response);
    }
}