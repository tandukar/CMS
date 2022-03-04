package CMS;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class report extends bodFrame{

    private final String url = "jdbc:mysql://localhost:3306/CMS";
    private final String uname = "root";
    private final String pwd = "";

    JTextField idtxt = new JTextField();   //creating a idtext
    JLabel idlabel = new JLabel("Stu.ID ");  //creating a idlabel
    JButton btn = new JButton("Enter");  //creating a jbtn


    public void  frame() {
//calling
        bod_frame();
        bod_frame().setTitle("Course Management System - Report");
        bod_frame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        idlabel.setBounds(45, 60, 80, 25);
        idtxt.setBounds(160, 60, 90, 25);


        bod_frame().add(idlabel);
        bod_frame().add(idtxt);




        btn.setBounds(150, 150, 80, 25);
        bod_frame().add(btn);
        bod_frame().setVisible(true);


    }


    void result() {
        frame();
        bod_frame().setSize(500, 260);

        btn.addActionListener(e -> {
            try {
                String id = idtxt.getText();
                //load the driver
                Class.forName("com.mysql.cj.jdbc.Driver");
                //create the connection
                Connection connect = DriverManager.getConnection(url, uname, pwd);
                //create the query
                String admin_query = "select * from students where studentID=?";
                //create the statement
                PreparedStatement statement = connect.prepareStatement(admin_query);
                statement.setString(1, id);

                ResultSet rs = statement.executeQuery(); //executes  statement
                if (rs.next()) {
                    int ID = rs.getInt("studentID");
                    int yr = rs.getInt("year");
                    String first_name = rs.getString("firstName");
                    String last_name = rs.getString("lastName");
                     int m1 = rs.getInt("marks1");
                     int m2 = rs.getInt("marks2");
                     int m3 = rs.getInt("marks3");



                     //storing  the strings from the table in the following database
                     String mod1 = rs.getString("module1");
                     String mod2 = rs.getString("module2");
                     String mod3 = rs.getString("module3");

                    //prints in the console
                    System.out.println("Id= " + ID);
                    System.out.println("year= " + yr);
                    System.out.println("First Name= " + first_name);
                    System.out.println("Last Name= " + last_name);
                    System.out.println("module1= " + mod1+": "+m1);
                    System.out.println("module2= " + mod2+": "+m2);
                    System.out.println("module3= " + mod3+": "+m3);



                    //close the statment
                    connect.close();

                    FileWriter fw;
                    BufferedWriter bw;
                    PrintWriter pw;
                    try {
                        fw = new FileWriter("report.txt"); //writes to the filename
                        bw = new BufferedWriter(fw);
                        pw = new PrintWriter(bw);
                        pw.println("**********Report************");
                        pw.println("ID: "+ ID);
                        pw.println("Name: "+ first_name +" "+last_name);
                        pw.println("Year: "+ yr);
                        pw.println(mod1+": "+m1);
                        pw.println(mod2+": "+m2);
                        pw.println(mod3+": "+m3);
                        int check = 50;
                        if(m1> check && m2> check && m3 > check){  //checking if  the student has passed or failed
                            pw.println("Level passed");
                            pw.println("Congratulations of passing the level!!");
                            System.out.println("Level passed");
                        }
                        else{
                            pw.println("Level failed");
                            System.out.println("Level failed");
                        }
                        pw.println("*****************************");

                        System.out.println("Data Successfully added into file");
                        pw.flush();
                    } catch (IOException ex) {
                        ex.printStackTrace();   //catches an ioexception
                    }
                }
            }  catch (ClassNotFoundException | SQLException ex) {
                ex.printStackTrace(); //catches an ClassNotFoundException
            } //catches an SQLException

        });
    }
}
