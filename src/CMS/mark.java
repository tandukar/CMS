package CMS;

import javax.swing.*;
import java.sql.*;

public class mark extends bodFrame {

    String url = "jdbc:mysql://localhost:3306/CMS";
    String uname = "root";
    String pwd = "";

    // creating the following  Jtextfields and jlabel and a Jbutton
    JTextField usertxt = new JTextField();
    JLabel ulabel = new JLabel("Stu. Name ");

    JTextField idtxt = new JTextField();
    JLabel idlabel = new JLabel("Stu.ID ");

    JTextField text1 = new JTextField();
    JLabel label1 = new JLabel("Enter marks");

    JButton btn = new JButton("Enter");



    public void  frame() {

        //adding following attributes to the Jframe form the class bodFrame
        bod_frame().setTitle("Course Management System - Marks");
        bod_frame().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //setting sizes
        ulabel.setBounds(45, 20, 80, 25);
        usertxt.setBounds(160, 20, 90, 25);

        idlabel.setBounds(45, 60, 80, 25);
        idtxt.setBounds(160, 60, 90, 25);

        label1.setBounds(45, 100, 80, 25);
        text1.setBounds(160, 100, 90, 25);


        //adding following attributes to the Jframe form the class bodFrame
        bod_frame().add(ulabel);
        bod_frame().add(usertxt);

        bod_frame().add(idlabel);
        bod_frame().add(idtxt);

        bod_frame().add(label1);
        bod_frame().add(text1);
        btn.setBounds(150, 150, 80, 25);
        bod_frame().add(btn);
        bod_frame().setVisible(true);



    }

    public final void mark1(String mods) {  //updating for  module1
        frame();
        bod_frame().setSize(400, 260);
        btn.addActionListener(e -> {
            String ustr = usertxt.getText();
            String id = idtxt.getText();
            String marks = text1.getText();
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(url,uname,pwd);
                //stored in marks
                PreparedStatement st = con.prepareStatement("Update students set marks1=?  where firstName=? and studentID=? and module1=?");
                st.setString(1, marks);
                st.setString(2, ustr);
                st.setString(3, id);
                st.setString(4, mods);
                // they need to be satistied for the marks to be added
                st.executeUpdate();
            }
            catch (Exception w1) {
                System.out.println(w1);
            }
        });
    }

    public final void mark2(String mods) {//updating for  module2
        frame();
        bod_frame().setSize(500, 260);
        btn.addActionListener(e -> {
            String ustr = usertxt.getText();
            String id = idtxt.getText();
            String marks = text1.getText();
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(url,uname,pwd);
                PreparedStatement st = con.prepareStatement("Update students set marks2=?  where firstName=? and studentID=? and module2=?");
                st.setString(1, marks);
                st.setString(2, ustr);
                st.setString(3, id);
                st.setString(4, mods);
                // they need to be satistied for the marks to be added
                st.executeUpdate();
            }
            catch (Exception w1) {
                System.out.println(w1);
            }
        });
    }

    public final void mark3(String mods) { //updating for  module3
        frame();
        bod_frame().setSize(500, 260);
        btn.addActionListener(e -> {
            String ustr = usertxt.getText();
            String id = idtxt.getText();
            String marks = text1.getText();
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(url,uname,pwd);
                PreparedStatement st = con.prepareStatement("Update students set marks3=?  where firstName=? and studentID=? and module3=?");
                st.setString(1, marks);
                st.setString(2, ustr);
                st.setString(3, id);
                st.setString(4, mods);
                // they need to be satistied for the marks to be added
                st.executeUpdate();
            }
            catch (Exception w1) {
                System.out.println(w1);
            }
        });
    }


    public final void mark4(String mods) { //updating for  module4
        frame();
        bod_frame().setSize(500, 260);
        btn.addActionListener(e -> {
            String ustr = usertxt.getText();
            String id = idtxt.getText();
            String marks = text1.getText();
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(url,uname,pwd);
                PreparedStatement st = con.prepareStatement("Update students set marks4=?  where firstName=? and studentID=? and module4=?");
                st.setString(1, marks);
                st.setString(2, ustr);
                st.setString(3, id);
                st.setString(4, mods);
                // they need to be satistied for the marks to be added
                st.executeUpdate();
            }
            catch (Exception w1) {
                System.out.println(w1);
            }
        });
    }

}
