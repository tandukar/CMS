package CMS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Login    implements ActionListener {
    JFrame frame = new JFrame("Login");
    JFrame frame1 = new JFrame();   //This is for radiobtn
    JPanel panel = new JPanel();
    private  JLabel id_label = new JLabel("ID");
    private JLabel user_label = new JLabel("User Name");
    private JLabel pwd_label = new JLabel("Password");

    private JTextField id_text = new JTextField(20);
    private JTextField user_text = new JTextField(20);

    private JPasswordField pwd_text = new JPasswordField(20);
    private JButton btn = new JButton("Login");

    String url = "jdbc:mysql://localhost:3306/CMS";
    String uname = "root";
    String pwd = "";




    private JRadioButton radBtn;
    private JRadioButton radBtn1;
    private  JRadioButton radBtn2;
    private ButtonGroup group = new ButtonGroup();



    void frame(){
        frame.setSize(400, 270);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.add(panel);

    }

    void panel(){
        panel.setLayout(null);
        id_label.setBounds(45, 20, 80, 25);
        user_label.setBounds(45, 60, 80, 25);
        pwd_label.setBounds(45, 100, 80, 25);
       // course_label.setBounds(45, 140, 80, 25);

        id_text.setBounds(120, 20, 220, 25);
        user_text.setBounds(120, 60, 220, 25);
        pwd_text.setBounds(120, 100, 220, 25);
     //   course_text.setBounds(120, 140, 220, 25);
        btn.setBounds(90, 180, 80, 25);


        panel.add(id_label);
        panel.add(user_label);
        panel.add(pwd_label);

        panel.add(id_text);
        panel.add(user_text);
        panel.add(pwd_text);

        panel.add(btn);
    }
    void radioBtn(){


        //creating radio buttons
        radBtn = new JRadioButton("Level 4");
        radBtn1 = new JRadioButton("Level 5");
        radBtn2 = new JRadioButton("Level 6");

        //adding action listener to the radio buttons
        radBtn.addActionListener(this);
        radBtn1.addActionListener(this);
        radBtn2.addActionListener(this);


        //grouping the radio butons all together
        group.add(radBtn);
        group.add(radBtn1);
        group.add(radBtn2);

        //adding attributes to the frame1 Jframe
        frame1.setLayout(new FlowLayout());
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setLocationRelativeTo(null);
        frame1.setSize(300,300);
        frame1.add(radBtn);
        frame1.add(radBtn1);
        frame1.add(radBtn2);
        frame1.pack();

        frame1.setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==radBtn) {
            loginStudents();
        }
        //if the radBtn and the radBtn1 is selected loginstudents is called
        else if(e.getSource()==radBtn1) {
            loginStudents();

        }
        //when radBtn2 is selected loginStudents3 is called
        else if(e.getSource()==radBtn2) {
            loginStudents3();
        }


    }






    void loginStudents() {
        frame();
        panel();

        frame.setVisible(true);
        //replacing anonymous new ActionListener with lamda
        //when the button is  pressed action listener is triggerd
        btn.addActionListener(e -> {

            int i = 0;
            //All the texts from the textfields are stored in the foloowing  varaiables.
            String id = id_text.getText();
            String ustr = user_text.getText();
            String pstr = pwd_text.getText();


            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(url,uname,pwd);
                //searches from table students for login
                PreparedStatement st = con.prepareStatement("Select studentID, firstName,password,course from students where studentID=? and firstName=? and  password=?");
                st.setString(1, id);
                st.setString(2, ustr);  //they are the conditions  that are checked, if all of them are correct login is sucessfull
                st.setString(3, pstr);


                ResultSet rs = st.executeQuery();  //executes the query
                if (rs.next()) {
                    i = 1;
                }
            } catch (Exception w1) {
                System.out.println(w1);
            }
            if (i == 1) {
                JOptionPane.showMessageDialog(btn, "You have successfully logged in");//displays the msg if execution is  successful
                student obj = new student();
                obj.Student1(id);


            } else {
                JOptionPane.showMessageDialog(btn, "Wrong Username & Password");//displays the msg if execution is  unsuccessful
            }
        });


    }
    void loginStudents3() {
        frame();
        panel();

        frame.setVisible(true);
        btn.addActionListener(e -> {
            int i = 0;
            String id = id_text.getText();
            String ustr = user_text.getText();
            String pstr = pwd_text.getText();


            try {

                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(url,uname,pwd);
                PreparedStatement st = con.prepareStatement("Select studentID, firstName,password,course from students where studentID=? and firstName=? and  password=?");
                st.setString(1, id);
                st.setString(2, ustr);//they are the conditions  that are checked, if all of them are correct login is sucessfull
                st.setString(3, pstr);

                ResultSet rs = st.executeQuery();//executes the query
                if (rs.next()) {
                    i = 1;
                }
            } catch (Exception w1) {
                System.out.println(w1);
            }
            if (i == 1) {
                JOptionPane.showMessageDialog(btn, "You have successfully logged in");//displays the msg if execution is  successful
                student obj = new student();
                obj.Student3(id);

            } else {
                JOptionPane.showMessageDialog(btn, "Wrong Username & Password");//displays the msg if execution is  unsuccessful
            }
        });
    }


    void loginTeach() {
        frame();
        panel();
        frame.setVisible(true);
        btn.addActionListener(e -> {

            int i = 0;
            String ustr = user_text.getText();
            String pstr = pwd_text.getText();
            String id = id_text.getText();

            try {

                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(url,uname,pwd);
                PreparedStatement st = con.prepareStatement("Select firstName,password,teachID from teachers where firstName=? and  password=? and teachID=?");
                st.setString(1, ustr);
                st.setString(2, pstr);
                st.setString(3, id);//they are the conditions  that are checked, if all of them are correct login is sucessfull
                ResultSet rs = st.executeQuery();//executes the query
                if (rs.next()) {
                    i = 1;
                }
            } catch (Exception w1) {
                System.out.println(w1);
            }
            if (i == 1) {
                JOptionPane.showMessageDialog(btn, "You have successfully logged in"); //displays the msg if execution is successful
                teach obj = new teach();
                obj.Teach(ustr);
            } else {
                JOptionPane.showMessageDialog(btn, "Wrong Username & Password");//displays the msg if execution is  unsuccessful
            }
        });
    }
    void  loginAdmin() {
        frame();
        panel();
        frame.setVisible(true);
        btn.addActionListener(e -> {
            int i = 0;
            //Stores the jtextfield texts in the following variables
            String ustr = user_text.getText();
            String id = id_text.getText();
            String pstr = pwd_text.getText();
            try {

                //loads the driver
                Class.forName("com.mysql.cj.jdbc.Driver");
                //creates connection
                Connection con = DriverManager.getConnection(url,uname,pwd);
                //searches the table admin
                PreparedStatement st = con.prepareStatement("Select firstName, adminID, password from admin where firstName=? and  adminID=? and  password=?");
                st.setString(1, ustr);
                st.setString(2, id); //they are the conditions  that are checked, if all of them are correct login is sucessfull
                st.setString(3, pstr);
                ResultSet rs = st.executeQuery();//executes the query
                if (rs.next()) {
                    i = 1;
                }
            } catch (Exception w1) {
                System.out.println(w1);
            }
            if (i == 1) {
                JOptionPane.showMessageDialog(btn, "You have successfully logged in"); //displays the msg if execution is successful
                admin obj = new admin();
                obj.Admin();


            } else {
                JOptionPane.showMessageDialog(btn, "Wrong Username & Password"); //displays the msg if execution is unsuccessful
            }
        });
    }





}



