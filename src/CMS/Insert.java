package CMS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Insert {
    private final String url = "jdbc:mysql://localhost:3306/CMS";
    private final String uname = "root";
    private final String pwd = "";


    //inserting admin, and modules in BIT db
    void insert_Admin() {
        try {
            //load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //create the connection
            Connection connect = DriverManager.getConnection(url, uname, pwd);
            //create the query
            String admin_query = "INSERT INTO admin(firstName,lastName,password) VALUES(?,?,?)";
            //create the statement
            PreparedStatement statement = connect.prepareStatement(admin_query);

            statement.setString(1, "Willem");
            statement.setString(2, "Dafoe");
            statement.setString(3, "1");
            statement.executeUpdate();

            System.out.println("Table Updated!!! ");

            //close the statment
            connect.close();

        } catch (Exception exp) {
            System.out.println(exp);
        }
    }

}

