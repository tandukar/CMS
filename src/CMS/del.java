package CMS;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class del {

    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    JLabel C_name = new JLabel("course Name");  //creating a jlabel named c_name
    JLabel F_name = new JLabel("First Name"); //creating a jlabel named F_name
    JLabel L_name = new JLabel("Last Name");  //creating a   jlabel named L_name
    JLabel ID = new JLabel("ID");  //creating aJlabel named ID

    JTextField C_name_text = new JTextField(20);  //creating a JTextField named C_name_text
    JTextField F_name_text = new JTextField(20);  //creating a JTextField named F_name_text
    JTextField L_name_text = new JTextField(20);  //creating a JTextField named L_name_text
    JTextField ID_text = new JTextField(20);  //creating a JTextField named ID_text


    JButton btn = new JButton("Delete");

    static final String url = "jdbc:mysql://localhost:3306/CMS";
    static final String uname = "root";
    static final String pwd = "";


    void frame() {
        frame.setSize(400, 260);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.add(panel);

    }

    void panel() {
        panel.setLayout(null);
        C_name.setBounds(45, 20, 80, 25);
        C_name_text.setBounds(125, 20, 220, 25);
        F_name.setBounds(45, 20, 80, 25);
        F_name_text.setBounds(125, 20, 220, 25);
        L_name.setBounds(45, 60, 80, 25);
        L_name_text.setBounds(125, 60, 220, 25);

        ID.setBounds(45, 100, 80, 25);
        ID_text.setBounds(125, 100, 220, 25);
        btn.setBounds(90, 135, 80, 25);


    }


    public void del_course(){
        frame();
        panel();
        panel.add(C_name);
        panel.add(C_name_text);
//adding attributs to the panel
        panel.add(btn);
        frame.setVisible(true);
        frame.setTitle("Del - Course");
        btn.addActionListener(e -> {
            //when the btn  is presed
            if (e.getSource() == btn) {
// texts from the textfield are stored in the following variables
                String Cname = C_name_text.getText();

                try {
                    System.out.println("delete");
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con =  DriverManager.getConnection(url,uname,pwd);
                    // PreparedStatement for the courses table
                    PreparedStatement st =  con.prepareStatement("DELETE FROM courses WHERE courseName=?");
                    st.setString(1, Cname);
                    st.executeUpdate();  // the st wil execute once teh above requirements are satisfied
                    JOptionPane.showMessageDialog(btn, "Course Removed");

                } catch (Exception w1) {
                    System.out.println(w1); //catches and prints out the error in the console
                }
            }
        });
        }

    public void del_teach(){
        frame();
        panel();
        panel.add(F_name);
        panel.add(L_name);
        panel.add(F_name_text);
        panel.add(L_name_text);
        panel.add(ID);
        panel.add(ID_text);

        panel.add(btn);
        frame.setVisible(true);
        frame.setTitle("Del - Teacher");
        btn.addActionListener(e -> {
            //when the btm  is presed
            if (e.getSource() == btn) {


                // texts from the textfield are stored in the following variables
                String Fname = F_name_text.getText();
                String Lname = L_name_text.getText();
                String teachID = ID_text.getText();

                try {
                    System.out.println("delete");
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection(url,uname,pwd);

                    // prepred statement for the teachers table
                    PreparedStatement st =  con.prepareStatement("DELETE FROM teachers WHERE firstName=? and lastName=? and teachID=?");
                    st.setString(1, Fname);
                    st.setString(2, Lname);
                    st.setString(3, teachID);

                    st.executeUpdate();  // the st wil execute once teh above requirements are satisfied
                    JOptionPane.showMessageDialog(btn, "Teacher Removed");

                } catch (Exception w1) {
                    System.out.println(w1);  //catches and prints out the error in the console
                }
            }
        });
    }
}
