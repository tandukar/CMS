package CMS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateTable {

    void createTable_CMS() {
        try {
            //load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //create the connection
            String url = "jdbc:mysql://localhost:3306/CMS";
            String uname = "root";
            String pwd = "";
            Connection connect = DriverManager.getConnection(url, uname, pwd);

            //creating tables for the db
            String students = "CREATE TABLE IF NOT EXISTS students(studentID int PRIMARY KEY AUTO_INCREMENT, firstName varchar(50) NOT NULL, lastName varchar(50) NOT NULL, password varchar(50) NOT NULL, Course varchar(50) NOT NULL, module1 varchar(50) NOT NULL, module2 varchar(50) NOT NULL, module3 varchar(50) NOT NULL,module4 varchar(50), year int NOT NULL,marks1 int, marks2 int, marks3 int, marks4 int)";
            String teachers = "CREATE TABLE IF NOT EXISTS teachers(teachID int PRIMARY KEY AUTO_INCREMENT, firstName varchar(50) NOT NULL, lastName varchar(50)  NOT NULL, modules1 varchar(50), modules2 varchar(50), modules3 varchar(50), modules4 varchar(50), password varchar(50) NOT NULL,  Course varchar(50) NOT NULL)";
            String admin = "CREATE TABLE IF NOT EXISTS admin(adminID int PRIMARY KEY AUTO_INCREMENT, firstName varchar(50) NOT NULL, lastName varchar(50)  NOT NULL, password varchar(50) NOT NULL)";
            String Yr1modules = "CREATE TABLE IF NOT EXISTS Yr1modules(ID int PRIMARY KEY AUTO_INCREMENT, moduleName varchar(90) NOT NULL, Course varchar(50) NOT NULL)";
            String Yr2modules = "CREATE TABLE IF NOT EXISTS Yr2modules(ID int PRIMARY KEY AUTO_INCREMENT, moduleName varchar(90) NOT NULL, Course varchar(50) NOT NULL)";
            String Yr3modules = "CREATE TABLE IF NOT EXISTS Yr3modules(ID int PRIMARY KEY AUTO_INCREMENT, moduleName varchar(90) NOT NULL, Course varchar(50) NOT NULL)";
            String Courses = "CREATE TABLE IF NOT EXISTS Courses(courseID int PRIMARY KEY AUTO_INCREMENT, courseName varchar(90) NOT NULL)";


            //create the statement
            Statement statement = connect.createStatement();
            statement.executeUpdate(students);
            statement.executeUpdate(teachers);
            statement.executeUpdate(admin);
            statement.executeUpdate(Yr1modules);
            statement.executeUpdate(Yr2modules);
            statement.executeUpdate(Yr3modules);
            statement.executeUpdate(Courses);

            //close the statment
            connect.close();

        } catch (Exception exp) {
            System.out.println(exp);
        }

    }
}
