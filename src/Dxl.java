// Сохраняет список сотрудников  в sotrudniki.xls с учетом фильтров


import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Row;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet("/dxl")
public class Dxl extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        request.setCharacterEncoding("UTF8");

        // Создает  excel файла в памяти
        HSSFWorkbook xls = new HSSFWorkbook();
        HSSFSheet sheet = xls.createSheet("Сотрудники");
        // Формирует  формат времени для ячеек
        HSSFCellStyle tstyle = xls.createCellStyle();
        HSSFDataFormat df = xls.createDataFormat();
        tstyle.setDataFormat(df.getFormat("h:mm:ss"));
        // Номер столбца в строке
        int k = 0;
        //Заполнение заголовков xls файла
        Row str1 = sheet.createRow(0);
        str1.createCell(0).setCellValue("ID");
        Row str2 = sheet.createRow(1);
        str2.createCell(0).setCellValue("ФИО");
        Row str3 = sheet.createRow(2);
        str3.createCell(0).setCellValue("Возраст");
        Row str4 = sheet.createRow(3);
        str4.createCell(0).setCellValue("Район");
        Row str5 = sheet.createRow(4);
        str5.createCell(0).setCellValue("Округ");
        Row str6 = sheet.createRow(5);
        str6.createCell(0).setCellValue("Адрес");
        Row str7 = sheet.createRow(6);
        str7.createCell(0).setCellValue("Начало смены");
        Row str8 = sheet.createRow(7);
        str8.createCell(0).setCellValue("Конец смены");
        sheet.autoSizeColumn(0);

        BDconnect con = new BDconnect();
        String sql4 = request.getParameter("f_sort") == null ? ";" : " order by " + request.getParameter("f_sort") + " ;" ;
              try (PreparedStatement statement = con.getConnect().prepareStatement(Const.sql1+ Const.sql2+ Const.sql3+sql4)) {

                    statement.setString(1, request.getParameter("f_fio"));
                    statement.setString(2, request.getParameter("f_rayon"));
                    statement.setString(3, request.getParameter("f_okrug"));

                    try (ResultSet rs = statement.executeQuery();){
                        //Заполнение xls файла
                        while ( rs.next() ) {
                            k++;
                            str1.createCell(k).setCellValue(rs.getInt("num"));
                            str2.createCell(k).setCellValue(rs.getString("fio"));
                            str3.createCell(k).setCellValue(rs.getInt("age"));
                            str4.createCell(k).setCellValue(rs.getString("rayon"));
                            str5.createCell(k).setCellValue(rs.getString("okrug"));
                            str6.createCell(k).setCellValue(rs.getString("adres"));
                            str7.createCell(k).setCellValue(rs.getTime("start"));
                            str8.createCell(k).setCellValue(rs.getTime("finish"));
                            str7.getCell(k).setCellStyle(tstyle);
                            str8.getCell(k).setCellStyle(tstyle);
                            sheet.autoSizeColumn(k);
                         }

                    } catch (SQLException ex){
                        ex.printStackTrace();
                    }
                } catch (SQLException ex){
                    ex.printStackTrace();
                }

        //Настройка записи в файл xls
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment;filename=sotrudniki.xls");

        //Запись в файл xls
        xls.write(response.getOutputStream());

   }
}
