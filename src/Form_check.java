// Проверяет на пустой ввод в поле Адрес, ФИО
// Проверяет поля  (ФИО и Возраст) нового сотрудника на совпадение с уже созданными
// Если ок - отправляет в /new_add

import org.apache.commons.lang3.StringUtils;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import javax.servlet.ServletException;

@WebServlet("/form_check")
public class Form_check extends HttpServlet {

  @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException{

        request.setCharacterEncoding("UTF8");
        boolean ok = true;

        // Проверяет на пустой ввод
        if (StringUtils.containsOnly(request.getParameter("new_name"), " ") ||
            StringUtils.containsOnly(request.getParameter("new_adres"), " ") ||
            StringUtils.isEmpty(request.getParameter("new_okrug")) ||
            StringUtils.isEmpty(request.getParameter("new_rayon")) ) {

            request.setAttribute("new_err", "Пустой ввод");
            request.getServletContext().getRequestDispatcher("/new_form").forward(request, response);
         }
        else {
           BDconnect con = new BDconnect();
                    try (Statement stmt = con.getConnect().createStatement();) {

                        try (ResultSet rs = stmt.executeQuery("SELECT *  FROM pers_files.members;");){

                            // Проверяет поля  (ФИО и Возраст) нового сотрудника на совпадение с уже созданными
                            while (rs.next())
                                if (request.getParameter("new_name").equals(rs.getString("fio")) &&
                                    request.getParameter("new_age").equals(rs.getString("age"))) ok = false;

                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                     } catch (SQLException ex) {
                         ex.printStackTrace();
                     }

           if (!ok) {
                request.setAttribute("new_err", "Одинаковые ФИО и возраст");
                request.getServletContext().getRequestDispatcher("/new_form").forward(request, response);
            } else {
                response.setContentType("text/html;charset=UTF-8");
                request.getServletContext().getRequestDispatcher("/new_add").forward(request, response);
            }
        }
    }
}