package CMS;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;


public class add {

    JFrame frame = new JFrame();  //adding  a  Jframe
    JPanel panel = new JPanel();  //adding a  panel

    JLabel F_name = new JLabel("First Name");  //creating a  JLabel named F_name
    JLabel L_name = new JLabel("Last Name");  //creating a  JLabel named L_name
    JLabel module1 = new JLabel("Module 1");//creating a  JLabel named module1
    JLabel module2 = new JLabel("Module 2");//creating a  JLabel named module2
    JLabel module3 = new JLabel("Module 3");//creating a  JLabel named module3
    JLabel module4 = new JLabel("Module 4");//creating a  JLabel named module4
    JLabel course = new JLabel("CourseName");//creating a  JLabel named course
    JLabel courseID = new JLabel("Course ID");//creating a  JLabel named courseID

    JTextField F_name_text = new JTextField(20);//creating a  JTextField named F_name_text
    JTextField L_name_text = new JTextField(20);//creating a  JTextField named L_name_text
    JTextField course_text = new JTextField(20);//creating a  JTextField named course_text
    JTextField courseID_text = new JTextField(20);//creating a  JTextField named courseID_text
    JTextField mod_text1 = new JTextField();//creating a  JTextField named mod_text1
    JTextField mod_text2 = new JTextField();//creating a  JTextField named mod_text2
    JTextField mod_text3 = new JTextField();//creating a  JTextField named mod_text3
    JTextField mod_text4 = new JTextField();//creating a  JTextField named mod_text4



    JComboBox<String> courseSel = new JComboBox<String>();
    JComboBox<String> modText1 = new JComboBox<>();
    JComboBox<String> modText2 = new JComboBox<String>();
    JComboBox<String> modText3 = new JComboBox<String>();
    JComboBox<String> modText4 = new JComboBox<String>();


    JButton btn = new JButton("ADD");//creating a Jbutton named btn


    String url = "jdbc:mysql://localhost:3306/CMS";
    String uname = "root";
    String pwd = "";


    void frame() {
        frame.setSize(400, 260);  //settig the size of the Jframe
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.add(panel);  // adds all the components of method panel in  frame
    }

    void panel() {
        panel.setLayout(null);  //setting the layout
        //setting the size of all the Jlabel and  all the textfileds and the btn
        F_name.setBounds(45, 50, 80, 25);
        L_name.setBounds(45, 80, 80, 25);
        F_name_text.setBounds(125, 50, 220, 25);
        L_name_text.setBounds(125, 80, 220, 25);

        module1.setBounds(45, 110, 80, 25);
        module2.setBounds(45, 140, 80, 25);
        module3.setBounds(45, 170, 80, 25);
        module4.setBounds(45, 200, 80, 25);

        mod_text1.setBounds(125, 110, 220, 25);
        mod_text2.setBounds(125, 140, 220, 25);
        mod_text3.setBounds(125, 170, 220, 25);
        mod_text4.setBounds(125, 200, 220, 25);

        course.setBounds(45, 20, 80, 25);
        courseID.setBounds(45, 60, 80, 25);

        course_text.setBounds(125, 20, 220, 25);
        courseID_text.setBounds(125, 60, 220, 25);


        courseSel.setBounds(125, 20, 220, 25);
        modText1.setBounds(125, 110, 220, 25);
        modText2.setBounds(125, 140, 220, 25);
        modText3.setBounds(125, 170, 220, 25);
        modText4.setBounds(125, 200, 220, 25);




        btn.setBounds(90, 250, 80, 25);
    }

    public  void selcourse() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");//loading the driver
            Connection con = DriverManager.getConnection(url, uname, pwd);  //creating a connection
            PreparedStatement pst = con.prepareStatement("SELECT * FROM courses "); //selcting from yr3modules table

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {  //if result set runs without any hitch it runs the following code
                String cname = rs.getString("courseName");
                courseSel.addItem(cname);  //gets the strings stored in moduleName column and adds then into the combo box.
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }



    public  void selmod() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");//loading the driver
            Connection con = DriverManager.getConnection(url, uname, pwd);  //creating a connection
            PreparedStatement pst = con.prepareStatement("SELECT * FROM yr3modules union SELECT * FROM yr1modules union SELECT * FROM yr2modules"); //selcting from yr3modules table

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {  //if result set runs without any hitch it runs the following code
                String Mname1 = rs.getString("moduleName");
                String Mname2 = rs.getString("moduleName");
                String Mname3 = rs.getString("moduleName");
                String Mname4 = rs.getString("moduleName");
                modText1.addItem(Mname1);
                modText2.addItem(Mname2);
                modText3.addItem(Mname3);//gets the strings stored in moduleName column and adds then into the combo box.
                modText4.addItem(Mname4);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    void add_teach() {
        frame();
        panel();   // calling the methods fram and panel
        selcourse();
        selmod();
        frame.setSize(600, 360); // changing the size

        //adding all the the Jlabel and  all the textfileds and the btn in panel
        panel.add(F_name);
        panel.add(L_name);
        panel.add(module1);
        panel.add(module2);
        panel.add(module3);
        panel.add(module4);
        panel.add(course);
        panel.add(F_name_text);
        panel.add(L_name_text);
        panel.add(modText1);
        panel.add(modText2);
        panel.add(modText3);
        panel.add(modText4);
        panel.add(courseSel);
        panel.add(btn);

        frame.setVisible(true);
        frame.setTitle("Add - Teacher");
        btn.addActionListener(new ActionListener() {   //adding an actionListener for the btn
            @Override
            public void actionPerformed(ActionEvent e) {

                //the button is pressed
                if (e.getSource() == btn) {

                    //gets all the texts from the textfileds and stores in the following  varaiables
                    String Fname = F_name_text.getText();
                    String Lname = L_name_text.getText();
//                    String modules1 = mod_text1.getText();
//                    String modules2 = mod_text2.getText();
//                    String modules3 = mod_text3.getText();
//                    String modules4 = mod_text4.getText();
//                    String CName = course_text.getText();
                    try {
                        System.out.println("add");
                        //load the driver
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        //create the connection
                        Connection con = DriverManager.getConnection(url,uname,pwd);
                        //create the statement to insert
                        PreparedStatement st =  con.prepareStatement("INSERT INTO teachers(firstName,lastName,modules1,modules2,modules3,modules4,password,Course) values(?,?,?,?,?,?,?,?)");
                        //adding everything from the variables created above to the database's table's respective columns
                        st.setString(1, Fname);
                        st.setString(2, Lname);
//                        st.setString(3, modules1);
//                        st.setString(4, modules2);
//                        st.setString(5, modules3);
//                        st.setString(6, modules4);
                        st.setString(3, (String) modText1.getSelectedItem());
                        st.setString(4, (String) modText2.getSelectedItem());
                        st.setString(5, (String) modText3.getSelectedItem());
                        st.setString(6, (String) modText4.getSelectedItem());
                        st.setString(7, "password");
                        st.setString(8, (String) courseSel.getSelectedItem());
                        //st.setString(8, CName);
                        st.executeUpdate();  //executing the statement
                        JOptionPane.showMessageDialog(btn, " Added"); //shows the message when the btn is pressed and the statement is executed properly
                    } catch (Exception w1) {  // if something fails the exception is catched and throws a message
                        System.out.println(w1);
                    }
                }
            }
        });
    }

    void add_Course() {
        frame();
        panel();
        btn.setBounds(90, 100, 80, 25);
        //adding the components to the panel
        panel.add(course);
        panel.add(courseID);
        panel.add(course_text);
        panel.add(courseID_text);
        panel.add(btn);
        frame.setTitle("Add - Course");  //setting the title

        frame.setVisible(true);
        // when the btn is pressed the following code runs
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (e.getSource() == btn) {
                    // the texts from the textfileds are stored in  the strings
                    String Cname = course_text.getText();
                    String C_ID = courseID_text.getText();

                    // the strings are stored in the arraylist
                    ArrayList<String> info = new ArrayList<String>();
                    info.add(Cname);
                    info.add(C_ID);

                    // new array list to add to the table
                    ArrayList<String> insertinto = new ArrayList<String>();
                    insertinto.add("courseName");
                    insertinto.add("courseID");
                    System.out.println("this is arraylist");
                    System.out.println(info);
                    try {
                        System.out.println("add");
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection con = (Connection) DriverManager.getConnection(url,uname,pwd);
                        //the statement where the info arraylist gets stored into the insertinto arraylist  and is inserted in the table
                        PreparedStatement st = (PreparedStatement) con.prepareStatement("insert into courses (" + String.join(", ", insertinto) + ") values( '" + String.join("', '", info) + "')");
                        st.executeUpdate();
                        JOptionPane.showMessageDialog(btn, "Course Added");

                    } catch (Exception w1) {
                        System.out.println(w1);
                    }
                }
            }

        });
    }
}