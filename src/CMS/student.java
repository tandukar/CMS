package CMS;

import javax.swing.*;
import java.awt.*;

import java.sql.*;

public class student extends bodFrame {

    private String url = "jdbc:mysql://localhost:3306/CMS";
    private String uname = "root";
    private String pwd = "";

    //creating the following buttons
    private JButton button = new JButton();
    private JButton button1 = new JButton();
    private JButton button2 = new JButton();
    private JButton button3 = new JButton();
    private JButton button4 = new JButton();


    void studentbtn()
    {
        button.setBounds(190,310,150,80);
        button.setFocusable(false);
        button.setFont(new Font(" ", Font.BOLD,18));

        button1.setBounds(430,310,150,80);
        button1.setFocusable(false);
        button1.setFont(new Font("", Font.BOLD,18));

        button2.setBounds(640,310,150,80);
        button2.setFocusable(false);
        button2.setFont(new Font("", Font.BOLD,18));

        button3.setBounds(720,310,150,80);
        button3.setFocusable(false);
        button3.setFont(new Font("", Font.BOLD,18));

        button4.setBounds(400,450,175,80);
        button4.setFocusable(false);
        button4.setFont(new Font("", Font.BOLD,13));
        button4.setForeground(new Color(40, 100, 150));
    }



    void Student1(String id ){

        bod_frame().setTitle("Course Management System - Student");
        bod_frame().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        bod_frame();
        studentbtn();

        bod_frame().add(button);
        bod_frame().add(button1);
        bod_frame().add(button2);


        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con =  DriverManager.getConnection(url, uname, pwd);
            //select using the id that has been passed.
            PreparedStatement st = con.prepareStatement("Select firstName,lastName,studentID ,module1,module2,module3,module4,year from  students  where studentID=?");
            st.setString(1, id);

            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                //getting the strings from the database and storing them in the variables
                int ID = rs.getInt("studentID");
                int yr = rs.getInt("year");
                String first_name = rs.getString("firstName");
                String last_name = rs.getString("lastName");
                 String mod1 = rs.getString("module1");
                 String mod2 = rs.getString("module2");
                 String mod3 = rs.getString("module3");
                 String mod4 = rs.getString("module4");
                //printing in console
                System.out.println("Id= " + ID);
                System.out.println("year= " + yr);
                System.out.println("First Name= " + first_name);
                System.out.println("Last Name= " + last_name);
                System.out.println("module1= " + mod1);
                System.out.println("module2= " + mod2);
                System.out.println("module3= " + mod3);
                System.out.println("module4= " + mod4);

                button.setText(String.valueOf(mod1));
                button.addActionListener(e -> Button(mod1)); //passing mod1 to button
                button1.setText(String.valueOf(mod2));
                button1.addActionListener(e -> Button1(mod2)); //passing mod2 to button2
                button2.setText(String.valueOf(mod3));
                button2.addActionListener(e -> Button2(mod3)); //passing mod3 to button3
            }

            //close the statment
            con.close();

        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }


    void Student3(String id) {
        bod_frame().setTitle("Course Management System - Student Lvl 3");
        bod_frame().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        bod_frame();
        studentbtn();
        button.setBounds(120,310,150,80);
        button.setFocusable(false);
        button.setFont(new Font(" ", Font.BOLD,18));

        button1.setBounds(320,310,150,80);
        button1.setFocusable(false);
        button1.setFont(new Font("", Font.BOLD,18));

        button2.setBounds(520,310,150,80);
        button2.setFocusable(false);
        button2.setFont(new Font("", Font.BOLD,18));

        bod_frame().add(button);
        bod_frame().add(button1);
        bod_frame().add(button3);
        bod_frame().add(button2);
        bod_frame().add(button4);

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con =  DriverManager.getConnection(url, uname, pwd);
            //select using the id that has been passed.
            PreparedStatement st = con.prepareStatement("Select firstName,lastName,studentID ,module1,module2,module3,module4,year,Course from  students  where studentID=? ");
            st.setString(1, id);

            ResultSet rs = st.executeQuery();


            if (rs.next()) {

                //getting the strings from the database and storing them in the variables
                int ID = rs.getInt("studentID");
                int yr = rs.getInt("year");
                String first_name = rs.getString("firstName");
                String last_name = rs.getString("lastName");
                final String mod1 = rs.getString("module1");
                final String mod2 = rs.getString("module2");
                final String mod3 = rs.getString("module3");
                final String mod4 = rs.getString("module4");
                final String course = rs.getString("Course");
                //printing in the console
                System.out.println("Id= " + ID);
                System.out.println("year= " + yr);
                System.out.println("First Name= " + first_name);
                System.out.println("Last Name= " + last_name);
                System.out.println("module1= " + mod1);
                System.out.println("module2= " + mod2);
                System.out.println("module3= " + mod3);
                System.out.println("module4= " + mod4);
                System.out.println("Course= " + course);

                button.setText(String.valueOf(mod1));
                button.addActionListener(e -> Button(mod1)); //passing mod1 to button
                button1.setText(String.valueOf(mod2));
                button1.addActionListener(e -> Button1(mod2)); //passing mod2 to button1
                button2.setText(String.valueOf(mod3));
                button2.addActionListener(e -> Button2(mod3));//passing mod3 to button2
                button3.setText(String.valueOf(mod4));
                button3.addActionListener(e -> Button3(mod4));//passing mod4 to button3
                button4.setText("Add/Change Module");
                button4.addActionListener(e -> Button4(id,course)); //passing id and course to  button3
            }

            //close the statment
            con.close();

        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();      //catches the exception and prints the error on the console
        }
    }


    void Button(String mod1) {
        String mods = mod1;
        System.out.println(mods);
        jtable obj = new jtable();
        obj.yrmodst1(mods);//passing parameter mods
    }

    void Button1(String mod2) {
        String mods = mod2;
        System.out.println(mods);
        jtable obj = new jtable();
        obj.yrmodst2(mods); //passing parameter mods
    }

    void Button2(String mod3) {
        String mods = mod3;
        System.out.println(mods);
        jtable obj = new jtable();
        obj.yrmodst3(mods); //passing parameter mods
    }

    void Button3(String mod4) {
        String mods = mod4;
        System.out.println(mods);
        jtable obj = new jtable();
        obj.yrmodst4(mods);//passing parameter mods

    }
    void Button4(String id, String course) {
        System.out.println(id);
        mod4 obj = new mod4();
        obj.selectmodules(id, course);  //passing parameter id and course to the method selectmodules
    }


}






