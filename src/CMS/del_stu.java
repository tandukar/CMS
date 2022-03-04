package CMS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class del_stu implements ActionListener{
    JFrame frame1 = new JFrame();  //creating two jframes
    JFrame frame2 = new JFrame();
    JPanel panel = new JPanel();  //creating jpanel
    JLabel F_name = new JLabel("First Name");
    JLabel L_name = new JLabel("Last Name");
    JLabel ID = new JLabel("ID");


    JTextField F_name_text = new JTextField(20);
    JTextField L_name_text = new JTextField(20);
    JTextField ID_text = new JTextField(20);


    JButton btn = new JButton("Delete");

    static final String url = "jdbc:mysql://localhost:3306/CMS";
    static final String uname = "root";
    static final String pwd = "";

    JRadioButton radBtn;
    JRadioButton radBtn1;
    JRadioButton radBtn2;
    ButtonGroup group = new ButtonGroup();

    void frame() {
        frame2.setSize(400, 260);
        frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame2.setLocationRelativeTo(null);
        frame2.add(panel);

    }

    void panel() {
        panel.setLayout(null);
        F_name.setBounds(45, 20, 80, 25);
        L_name.setBounds(45, 60, 80, 25);
        F_name_text.setBounds(120, 20, 220, 25);
        L_name_text.setBounds(120, 60, 220, 25);


        ID.setBounds(45, 100, 80, 25);
        ID_text.setBounds(120, 100, 220, 25);


        btn.setBounds(90, 135, 80, 25);


    }




    void rdBtn(){

        radBtn = new JRadioButton("Level 4");
        radBtn1 = new JRadioButton("Level 5");
        radBtn2 = new JRadioButton("Level 6");

        radBtn.addActionListener(this);
        radBtn1.addActionListener(this);
        radBtn2.addActionListener(this);

        group.add(radBtn);
        group.add(radBtn1);
        group.add(radBtn2);

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
            delStudents();
        }
        else if(e.getSource()==radBtn1) {
              delStudents();

        }
        else if(e.getSource()==radBtn2) {
            delStudents();
        }

    }
    public void delStudents(){
        frame();
        panel();
        panel.add(F_name);
        panel.add(L_name);
        panel.add(ID);
        panel.add(F_name_text);
        panel.add(L_name_text);
        panel.add(ID_text);
        panel.add(btn);
        frame2.setVisible(true);
        frame2.setTitle("Del - Student level 4");
        btn.addActionListener(e -> {

            if (e.getSource() == btn) {

                String Fname = F_name_text.getText();
                String Lname = L_name_text.getText();
                String Id = ID_text.getText();

                try {
                    System.out.println("delete");
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection(url,uname,pwd);
                    PreparedStatement st = con.prepareStatement("DELETE FROM students WHERE firstName=? and lastName=? and studentID=?");
                    st.setString(1, Fname);
                    st.setString(2, Lname);
                    st.setString(3, Id);
                    st.executeUpdate();
                    JOptionPane.showMessageDialog(btn, "Student Removed");

                } catch (Exception w1) {
                    System.out.println(w1);
                }
            }
        });
    }
}
