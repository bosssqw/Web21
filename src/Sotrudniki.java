//Формирует и передает данных для элементов фильтров
//Принимает параметры фильтрации  списка сотрудников для запроса в БД

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.*;
import java.util.*;

@WebServlet("/sotrudniki")
public class Sotrudniki extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException{
        request.setCharacterEncoding("UTF8");

        List <String> num = new ArrayList <>();
        List <String> allusers = new ArrayList <>();

        //Проверка наличия авторизации ... где использовать?
        HttpSession session = request.getSession();
        if ((boolean) session.getAttribute("autorized")) {
            System.out.println("Авторизация проверена");
        }

        //Формирует и передает данных для элементов фильтров
        Map <String, String> f_sort;
        f_sort = new TreeMap<>();
            f_sort.put(" Фамилия", "fio");
            f_sort.put("Возраст", "age");
            f_sort.put("Округ", "okrug");
            f_sort.put("Район", "rayon");

        request.setAttribute("f_rayon", Const.menu_rayon);
        request.setAttribute("f_okrug", Const.menu_okrug);
        request.setAttribute("f_sort", f_sort);

        //Принимает параметры фильтрации  списка сотрудников для запроса в БД
        request.setCharacterEncoding("UTF8");
        String ff_rayon = request.getParameter("ff_rayon");
        String ff_okrug = request.getParameter("ff_okrug");
        String ff_sort = request.getParameter("ff_sort");
        String ff_fio = request.getParameter("ff_fio");

        BDconnect con = new BDconnect();
        String sql4 = ff_sort == null ? ";" : " order by " + ff_sort + " ;" ;
                try (PreparedStatement statement = con.getConnect().prepareStatement(Const.sql1+ Const.sql2+ Const.sql3+sql4);) {

                    statement.setString(1, ff_fio);
                    statement.setString(2, ff_rayon);
                    statement.setString(3, ff_okrug);

                       try (ResultSet rs = statement.executeQuery();){
                        //Формирует списк сотрудников по результату запроса
                        while ( rs.next() ) {
                            num.add(rs.getString("num"));

                            int columns = rs.getMetaData().getColumnCount();
                            for (int i = 1; i <= columns; i++){
                                allusers.add(rs.getString(i));
                            }
                        }

                       } catch (SQLException e){
                           e.printStackTrace();
                       }
              } catch (SQLException ex){
                    ex.printStackTrace();
                }

        request.setAttribute("num", num);
        request.setAttribute("allusers", allusers);
        request.setAttribute("username", session.getAttribute("username"));
        request.setAttribute("sessionid", session.getId());

        //Формирует гиперссылку  для скачивания отфильтрованного списка в XLS
        String para="/dxl"+"?f_rayon="+ff_rayon+"&f_okrug="+ff_okrug+"&f_sort="+ff_sort+"&f_fio="+ff_fio;
        request.setAttribute("dxl", "<a href="+para+" > Сохранить в XLS </a>");

        response.setContentType("text/html;charset=UTF-8");
        getServletContext().getRequestDispatcher("/WEB-INF/zome/index.jsp").forward(request, response);

    }
}