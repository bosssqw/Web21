import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BDconnect {

    private static Connection connect = null;

    public BDconnect (){
        if (connect==null){
            //Конфигурируем и запускаем
            ConfigConnection();
        }
    }

   private void ConfigConnection (){

       try {
           Class.forName("org.postgresql.Driver");
       } catch (ClassNotFoundException  ed) {
           ed.printStackTrace();
       }

       String dbType = ("jdbc:postgresql:");
       String dbURL = ("//localhost");
       String dbPort = (":5432");
       String dbName = ("/dela");
       String dbUser = ("user1");
       String dbPass = ("123456");

       try{
       connect = DriverManager.getConnection(dbType+dbURL+dbPort+dbName,dbUser,dbPass);

       } catch (SQLException  e) {
           e.printStackTrace();
       }
   }

    public static Connection getConnect() {
        return connect;
    }
}
