package CMS;

import javax.swing.*;
import java.awt.*;
import java.sql.*;


public class teach extends bodFrame {

    private String url = "jdbc:mysql://localhost:3306/CMS";
    private String uname = "root";
    private String pwd = "";

    //creating JButtons
    private JButton button = new JButton();
    private JButton button1 = new JButton();
    private JButton button2 = new JButton();
    private JButton button3 = new JButton();



    void Teach(String ustr) {


//callling method from the bodFrame class

        bod_frame();
        bod_frame().setTitle("Course Management System - Teacher");
        bod_frame().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //setting hte attributes  of tall the created buttons

        button.setBounds(120,310,150,80);
        button.setFocusable(false);
        button.setFont(new Font(" ", Font.BOLD,18));

        button1.setBounds(350,310,150,80);
        button1.setFocusable(false);
        button1.setFont(new Font("", Font.BOLD,18));

        button2.setBounds(550,310,150,80);
        button2.setFocusable(false);
        button2.setFont(new Font("", Font.BOLD,18));

        button3.setBounds(750,310,150,80);
        button3.setFocusable(false);
        button3.setFont(new Font("", Font.BOLD,18));


        //adding the buttons to the jframe in the bod_frame method

        bod_frame().add(button1);
        bod_frame().add(button3);
        bod_frame().add(button2);
        bod_frame().add(button);

        try{

            Class.forName("com.mysql.cj.jdbc.Driver");//loads the driver
            Connection con = DriverManager.getConnection(url,uname,pwd);
            PreparedStatement st =  con.prepareStatement("Select firstName,lastName,teachID ,modules1,modules2,modules3,modules4 from teachers where firstName=?");
           //selects from  teachers where the firstname is equals ot ustr
            st.setString(1, ustr);

            ResultSet rs = st.executeQuery();


            if (rs.next()) {  //if result runs  stores the following attributes from the database.
                int id = rs.getInt("teachID");
                String first_name =rs.getString("firstName");
                String last_name =  rs.getString("lastName");
                final String mod1=rs.getString("modules1");
                final String mod2= rs.getString("modules2");
                final String mod3= rs.getString("modules3");
                final String mod4= rs.getString("modules4");
                //printing in the console
                System.out.println("Id= " + id);
                System.out.println("First Name= " +first_name );
                System.out.println("Last Name= " +last_name);
                System.out.println("module1= " + mod1);
                System.out.println("module2= " + mod2);
                System.out.println("module3= " + mod3);
                System.out.println("module4= " + mod4);



                //adding action listeners to all the buttons
                button.setText(String.valueOf(mod1));
                button.addActionListener(e -> Button(mod1)); //calls method button and passes mod1
                button1.setText(String.valueOf(mod2));
                button1.addActionListener(e -> Button1(mod2));//calls method button1 and passes mod2
                button2.setText(String.valueOf(mod3));
                button2.addActionListener(e -> Button2(mod3));//calls method button2 and passes mod3
                button3.setText(String.valueOf(mod4));
                button3.addActionListener(e -> Button3(mod4));//calls method button3 and passes mod4
            }

            //close the statment
            con.close();

            } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {  //catches and prints the error on  the console
            e.printStackTrace();
        }
    }


    void Button(String mod1) {
        String mods = mod1;
        System.out.println(mods);
        jtable obj = new jtable();  //calls form jtable method yrmod1 passes mods
        obj.yrmod1(mods);

        mark obj1 = new mark();
        obj1.mark1(mods);
    }

    void Button1(String mod2) {
        String mods = mod2;
        System.out.println(mods);
        jtable obj = new jtable();
        obj.yrmod2(mods);//calls form jtable method yrmod1 passes mods

        mark obj1 = new mark();
        obj1.mark2(mods); //calls form mark method mark2 passes mods
    }

    void Button2(String mod3) {
        String mods = mod3;
        System.out.println(mods);
        jtable obj = new jtable();//calls from jtable method yrmod3 passes mods
        obj.yrmod3(mods);

        mark obj1 = new mark();
        obj1.mark3(mods); //calls from mark method mark3 passes mods
    }

    void Button3(String mod4) {
        String mods = mod4;
        System.out.println(mods);
        jtable obj = new jtable();//calls from jtable method yrmod4 passes mods
        obj.yrmod4(mods);

        mark obj1 = new mark();
        obj1.mark4(mods);//calls from marks method mark4 passes mods
    }


}