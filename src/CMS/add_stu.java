package CMS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


public class add_stu   implements ActionListener {
    // adding  a radiobutton to the frame
    JFrame frame1 = new JFrame();
    JFrame frame2 = new JFrame();// creating a new frame
    JPanel panel = new JPanel();  //creating a new panel
    JLabel F_name = new JLabel("First Name");  //creating a jlabel named Fname
    JLabel L_name = new JLabel("Last Name"); //creating a jlabel named Lname
    JLabel course = new JLabel("Course"); //creating a jlabel named course
    JLabel module1 = new JLabel("Module 1"); //creating a jlabel named module1
    JLabel module2 = new JLabel("Module 2"); //creating a jlabel named module2
    JLabel module3 = new JLabel("Module 3");  //creating a jlabel named module3

    JTextField F_nameText = new JTextField(20);  //creating a JTextField named F_nameText
    JTextField L_nameText = new JTextField(20); //creating a JTextField named L_nameText
    JTextField courseText = new JTextField(20); //creating a JTextField named courseText



   // TextField modText1 = new JTextField(); //creating a JTextField named modText1
   // JTextField modText2 = new JTextField(); //creating a JTextField named modText2
   // JTextField modText3 = new JTextField(); //creating a JTextField named modText3



    JComboBox<String> courseSel = new JComboBox<String>();
    JComboBox<String> modText1 = new JComboBox<>();
    JComboBox<String> modText2 = new JComboBox<String>();
    JComboBox<String> modText3 = new JComboBox<String>();



    JButton btn = new JButton("ADD");  //creating a Jbutton named btn

    static  String url = "jdbc:mysql://localhost:3306/CMS";  //creating a static url where the db location is stored
    static  String uname = "root";  //creating a static uname where the user name is stored
    static  String pwd = "";   //creating a static pwd where the password is stored


    // creating three ratio buttons
    JRadioButton radBtn1;
    JRadioButton radBtn2;
    JRadioButton radBtn3;
    ButtonGroup group = new ButtonGroup();  // grouping the three radio buttons  together so only one can be selected at a time

    void frame() {
        frame2.setSize(600, 360);  //setting the sizse
        frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  //When the close is pressed
        frame2.setLocationRelativeTo(null);
        frame2.add(panel); //adding the panel to the jframe
        //adding the following components in the jpanel
        panel.add(F_name);
        panel.add(L_name);
        panel.add(course);
        panel.add(courseSel);
        panel.add(module1);
        panel.add(module2);
        panel.add(module3);
        panel.add(F_nameText);
        panel.add(L_nameText);
        panel.add(courseText);
        panel.add(modText1);
        panel.add(modText2);
        panel.add(modText3);

    }

    void panel() {
        panel.setLayout(null); //setting the panel layout to null
        //setting sizes to the jlabels

        courseSel.setBounds(120, 100, 220, 25);

        F_name.setBounds(45, 20, 80, 25);
        L_name.setBounds(45, 60, 80, 25);
        course.setBounds(45, 100, 80, 25);
        module1.setBounds(45, 140, 80, 25);
        module2.setBounds(45, 180, 80, 25);
        module3.setBounds(45, 220, 80, 25);
        // setting the sizes of jtextfields and the button
        F_nameText.setBounds(120, 20, 220, 25);
        L_nameText.setBounds(120, 60, 220, 25);
       // courseText.setBounds(120, 100, 220, 25); //changing this
        modText1.setBounds(120, 140, 220, 25);
        modText2.setBounds(120, 180, 220, 25);
        modText3.setBounds(120, 220, 220, 25);

        panel.add(btn);
        frame2.setVisible(true);  //setting the gui  visible
        btn.setBounds(90, 270, 80, 25);


    }


    void rdBtn() {  //method for radio button
//creating three Jradiobuttons
        radBtn1 = new JRadioButton("Level 4");
        radBtn2 = new JRadioButton("Level 5");
        radBtn3 = new JRadioButton("Level 6");
   // adding action listeners to the  radio buttons
        radBtn1.addActionListener(this);
        radBtn2.addActionListener(this);
        radBtn3.addActionListener(this);
        //adding the three radio buttons to the group
        group.add(radBtn1);
        group.add(radBtn2);
        group.add(radBtn3);
        frame1.setLayout(new FlowLayout()); //setting  the layout to flowlayout
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //closes the gui permanently after the close  is pressed
        frame1.setLocationRelativeTo(null); //this makes the  gui to be opened in the middle of the screen
        frame1.setSize(300, 300); //this is the jframe for the radio buttons
        //adding radio buttons to the frame1
        frame1.add(radBtn1);
        frame1.add(radBtn2);
        frame1.add(radBtn3);
        frame1.pack();
        frame1.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == radBtn1) {
            addStudents1();  //when the the  radBtn1 pressed it calls the addStudents1
        } else if (e.getSource() == radBtn2) {
            addStudents2();  //when the the  radBtn2 pressed it calls the addStudents2
        } else if (e.getSource() == radBtn3) {
            addStudents3(); //when the the  radBtn3  pressed it calls the addStudents3
        }
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

    public  void selmod1() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");//loading the driver
            Connection con = DriverManager.getConnection(url, uname, pwd);  //creating a connection
            PreparedStatement pst = con.prepareStatement("SELECT * FROM yr1modules "); //selcting from yr3modules table

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {  //if result set runs without any hitch it runs the following code
                String Mname1 = rs.getString("moduleName");
                String Mname2 = rs.getString("moduleName");
                String Mname3 = rs.getString("moduleName");
                modText1.addItem(Mname1);
                modText2.addItem(Mname2);
                modText3.addItem(Mname3);//gets the strings stored in moduleName column and adds then into the combo box.
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            e.printStackTrace();
        }
    }


    public  void selmod2() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");//loading the driver
            Connection con = DriverManager.getConnection(url, uname, pwd);  //creating a connection
            PreparedStatement pst = con.prepareStatement("SELECT * FROM yr2modules "); //selcting from yr3modules table

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {  //if result set runs without any hitch it runs the following code
                String Mname1 = rs.getString("moduleName");
                String Mname2 = rs.getString("moduleName");
                String Mname3 = rs.getString("moduleName");
                modText1.addItem(Mname1);
                modText2.addItem(Mname2);
                modText3.addItem(Mname3);//gets the strings stored in moduleName column and adds then into the combo box.
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public  void selmod3() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");//loading the driver
            Connection con = DriverManager.getConnection(url, uname, pwd);  //creating a connection
            PreparedStatement pst = con.prepareStatement("SELECT * FROM yr3modules "); //selcting from yr3modules table

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {  //if result set runs without any hitch it runs the following code
                String Mname1 = rs.getString("moduleName");
                String Mname2 = rs.getString("moduleName");
                String Mname3 = rs.getString("moduleName");
                modText1.addItem(Mname1);
                modText2.addItem(Mname2);
                modText3.addItem(Mname3);//gets the strings stored in moduleName column and adds then into the combo box.
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }




    public void addStudents1() {
        frame();
        panel();  //calling the two methods
        selcourse();
        selmod1();
        frame2.setTitle("Add - Student level 1");
        btn.addActionListener(e -> {
            if (e.getSource() == btn) {  //when the add button is pressed
                //it gets the text from the textfield and storing it in the following variables
                String Fname = F_nameText.getText();
                String Lname = L_nameText.getText();
                //String course = courseText.getText();
//                String modules1 = modText1.getText();
//                String modules2 = modText2.getText();
//                String modules3 = modText3.getText();
                try {
                    System.out.println("add");
                    //loading the driver
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    //create connection
                    Connection con = DriverManager.getConnection(url, uname, pwd);
                    //create preparedstatement
                    PreparedStatement st = con.prepareStatement("INSERT INTO  students(firstName,lastName,Course,password,module1,module2,module3,year) values(?,?,?,?,?,?,?,?)");

//                    sets the following strings in places of the values and when  everything runs properly and executes they are inserted  into the table students
                        st.setString(1, Fname);
                        st.setString(2, Lname);
                        st.setString(3, (String) courseSel.getSelectedItem());
                        st.setString(4, "1");
                        st.setString(5, (String) modText1.getSelectedItem());
                        st.setString(6, (String) modText2.getSelectedItem());
                        st.setString(7, (String) modText3.getSelectedItem());
                        st.setString(8, "1");
                        st.executeUpdate();
                    JOptionPane.showMessageDialog(btn, "Student Added");
                } catch (Exception w1) {
                    System.out.println(w1);  //  catches and prints out the exception
                }
            }
        });
    }


    public void addStudents2() {
        frame();
        panel();  //calling the two methods
        selcourse();
        selmod2();
        frame2.setTitle("Add - Student level 2");
        btn.addActionListener(e -> { //action listener
            if (e.getSource() == btn) {
                //when the add button is pressed
                //it gets the text from the textfield and storing it in the following variables
                String Fname = F_nameText.getText();
                String Lname = L_nameText.getText();
               // String course = courseText.getText();
//                String modules1 = modText1.getText();
//                String modules2 = modText2.getText();
//                String modules3 = modText3.getText();
                try {
                    System.out.println("add");
                    //loading the driver
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection(url, uname, pwd);  //creating connection
                    PreparedStatement st = con.prepareStatement("INSERT INTO  students(firstName,lastName,Course,password,module1,module2,module3,year) values(?,?,?,?,?,?,?,?)");
                    //  sets the following strings in places of the values and when  everything runs properly and executes they are inserted  into the table students
                    st.setString(1, Fname);
                    st.setString(2, Lname);
                    st.setString(3, (String) courseSel.getSelectedItem());
                    st.setString(4, "1");
//                    st.setString(5, modules1);
//                    st.setString(6, modules2);
//                    st.setString(7, modules3);
                    st.setString(5, (String) modText1.getSelectedItem());
                    st.setString(6, (String) modText2.getSelectedItem());
                    st.setString(7, (String) modText3.getSelectedItem());
                    st.setString(8, "2");
                    st.executeUpdate();
                    JOptionPane.showMessageDialog(btn, "Student Added");  //shows this message when a student is added to the database
                } catch (Exception w1) {
                    System.out.println(w1);   //catches the exception and prints it in the console
                }
            }
        });
    }
    public void addStudents3() {
        frame();
        panel();//calling the two methods
        selcourse();
        selmod3();

        frame2.setTitle("Add - Student level 3");
        btn.addActionListener(e -> {
            if (e.getSource() == btn) { //when the add button is pressed
                //it gets the text from the textfield and storing it in the following variables
                String Fname = F_nameText.getText();
                String Lname = L_nameText.getText();
              //  String course = courseText.getText();
//                String modules1 = modText1.getText();
//                String modules2 = modText2.getText();
//                String modules3 = modText3.getText();
                try {
                    System.out.println("add");
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection(url, uname, pwd);
                    PreparedStatement st = con.prepareStatement("INSERT INTO  students(firstName,lastName,Course,password,module1,module2,module3,year) values(?,?,?,?,?,?,?,?)");
                    //  sets the following strings in places of the values and when  everything runs properly and executes they are inserted  into the table students
                    st.setString(1, Fname);
                    st.setString(2, Lname);
                    st.setString(3, (String) courseSel.getSelectedItem());
                    st.setString(4, "1");
//                    st.setString(5, modules1);
//                    st.setString(6, modules2);
//                    st.setString(7, modules3);
                    st.setString(5, (String) modText1.getSelectedItem());
                    st.setString(6, (String) modText2.getSelectedItem());
                    st.setString(7, (String) modText3.getSelectedItem());
                    st.setString(8, "3");
                    st.executeUpdate();
                    JOptionPane.showMessageDialog(btn, "Student Added"); //shows this message when a student is added to the database
                } catch (Exception w1) {
                    System.out.println(w1); //catches the exception and prints it in the console
                }
            }
        });
    }
}
