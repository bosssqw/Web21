//Создает форму для заполнения данными на нового сотрудника

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

@WebServlet("/new_form")
public class New_form extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        int row_count = 0;
        List<String> new_age = new ArrayList<>();
        for (int i = 18; i <= 65; i++) {
            new_age.add(String.valueOf(i));
        }
        List<String> new_time = new ArrayList<>();
        for (int i = 0; i <= 23; i++) {
            new_time.add(i + ":00:00");
        }

            BDconnect con = new BDconnect();
            try (Statement stmt = con.getConnect().createStatement();) {

                //Подсчитывает количество сотрудников в БД и пределяет ID для нового сотрудника
                try (ResultSet rs = stmt.executeQuery("SELECT count(*) AS cnt FROM pers_files.members;");) {

                    while (rs.next()) {
                        row_count = rs.getInt(("cnt"));
                    }

                } catch (SQLException e) {
                    e.printStackTrace();
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        //Передает данные в форму создания сотрудника
        request.setAttribute("cnt", row_count);
        request.setAttribute("new_okrug", Const.menu_okrug);
        request.setAttribute("new_age", new_age);
        request.setAttribute("new_rayon", Const.menu_rayon);
        request.setAttribute("new_time", new_time);

        response.setContentType("text/html;charset=UTF-8");
        getServletContext().getRequestDispatcher("/WEB-INF/zome/new.jsp").forward(request, response);
    }
}