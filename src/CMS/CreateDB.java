package CMS;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDB {

    private String url = "jdbc:mysql://localhost:3306";
    private String uname = "root";
    private String pwd = "";


    void createDB() {
        try {
            //load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //create the connection
            Connection connect = DriverManager.getConnection(url, uname, pwd);
            // create the query
            String query_CMS = "CREATE DATABASE CMS";
            //create the statement
            Statement statement = connect.createStatement();
            int cms = statement.executeUpdate(query_CMS);
            System.out.println("All Databases Created!!!");
            //close the connection
            connect.close();
        } catch (SQLException e) {
            System.out.println(e);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
