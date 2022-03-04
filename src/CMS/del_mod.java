package CMS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class del_mod implements ActionListener{
    JFrame frame2 = new JFrame();  //radiobutton
    JFrame frame1 = new JFrame();
    JPanel panel = new JPanel();
    JLabel M_name = new JLabel("Module Name");
    JLabel C_name = new JLabel("Course Name");
    JLabel ID = new JLabel("ID");


    JTextField M_name_text = new JTextField(20);
    JTextField C_name_text = new JTextField(20);
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
        frame1.setSize(400, 260);
        frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame1.setLocationRelativeTo(null);
        frame1.add(panel);

    }

    void panel() {
        panel.setLayout(null);
        M_name.setBounds(45, 20, 80, 25);
        C_name.setBounds(45, 60, 80, 25);
        ID.setBounds(45, 100, 80, 25);
        M_name_text.setBounds(125, 20, 220, 25);
        C_name_text.setBounds(125, 60, 220, 25);
        ID_text.setBounds(125, 100, 220, 25);

        btn.setBounds(90, 135, 80, 25);
        panel.add(M_name);
        panel.add(C_name);
        panel.add(ID);
        panel.add(ID_text);
        panel.add(M_name_text);
        panel.add(C_name_text);
        panel.add(btn);

        //adding attributes to the panel
    }


    void rdBtn(){
//creating 3 radio buttons
        radBtn = new JRadioButton("Level 4");
        radBtn1 = new JRadioButton("Level 5");
        radBtn2 = new JRadioButton("Level 6");


        //adding ActionListener in all the  radio buttons
        radBtn.addActionListener(this);
        radBtn1.addActionListener(this);
        radBtn2.addActionListener(this);

        group.add(radBtn);
        group.add(radBtn1);
        group.add(radBtn2);

        frame2.setLayout(new FlowLayout());
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setLocationRelativeTo(null);
        frame2.setSize(300,300);
        frame2.add(radBtn);
        frame2.add(radBtn1);
        frame2.add(radBtn2);
        frame2.pack();
        //adding attributes to the radFrame

        frame2.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==radBtn) {
            delMod1();  //if radBtn is selected delMod1 is called
        }
        else if(e.getSource()==radBtn1) {
            delMod2(); //if radBtn is selected delMod2 is called

        }
        else if(e.getSource()==radBtn2) {
            delMod3(); //if radBtn is selected delMod3 is called
        }
    }
    public void delMod1(){
        frame();
        panel();

        panel.add(btn);
        frame1.setVisible(true);
        frame1.setTitle("Del - Modules level 4");
        btn.addActionListener(e -> {
            //action lisenter is triggerd
            //Texts ftored form teh textfields

            if (e.getSource() == btn) {
                String Mname = M_name_text.getText();
                String Cname = C_name_text.getText();
                String ID = ID_text.getText();
                try {
                    System.out.println("delete");
                    //loads the driver
                    Class.forName("com.mysql.cj.jdbc.Driver");

                    //creates connection
                    Connection con = DriverManager.getConnection(url,uname,pwd);
                    PreparedStatement st =  con.prepareStatement("DELETE FROM yr1modules WHERE moduleName=? and Course=? and ID=?");
                    st.setString(1, Mname);
                    st.setString(2, Cname);
                    st.setString(3, ID);
                    //the above variables  set the string
                    st.executeUpdate();  // executes after satisfied

                    JOptionPane.showMessageDialog(btn, "Modules Removed");

                } catch (Exception w1) {
                    System.out.println(w1);  //catches and prints the error on the console
                }
            }
        });
    }

    public void delMod2(){
        frame();
        panel();

        panel.add(btn);
        frame1.setVisible(true);
        frame1.setTitle("Del - Modules level 4");
        btn.addActionListener(e -> {
            //action lisenter is triggerd
//Texts ftored form teh textfields
            if (e.getSource() == btn) {
                String Mname = M_name_text.getText();
                String Cname = C_name_text.getText();
                String ID = ID_text.getText();
                try {
                    System.out.println("delete");
                    //loads the driver
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    //creates connection
                    Connection con = DriverManager.getConnection(url,uname,pwd);
                    //from the table yr2modules
                    PreparedStatement st = con.prepareStatement("DELETE FROM yr2modules WHERE moduleName=? and Course=? and ID=?");
                    st.setString(1, Mname);
                    st.setString(2, Cname);
                    st.setString(3, ID);
                    //the above variables  set the string
                    st.executeUpdate(); // executes after satisfied
                    JOptionPane.showMessageDialog(btn, "Modules Removed");

                } catch (Exception w1) {
                    System.out.println(w1); //catches and prints the error on the console
                }
            }
        });
    }

    public void delMod3(){
        frame();
        panel();

        panel.add(btn);
        frame1.setVisible(true);
        frame1.setTitle("Del - Modules level 6");
        btn.addActionListener(e -> {
            //action lisenter is triggerd
            if (e.getSource() == btn) {
                //Texts ftored form teh textfileds
                String Mname = M_name_text.getText();
                String Cname = C_name_text.getText();
                String ID = ID_text.getText();
                try {
                    System.out.println("delete");
                    //loads the driver
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    //creates connection
                    Connection con = DriverManager.getConnection(url,uname,pwd);

                    //the above variables  set the string
                    PreparedStatement st = con.prepareStatement("DELETE FROM yr3modules WHERE moduleName=? and Course=? and ID=?");
                    st.setString(1, Mname);
                    st.setString(2, Cname);
                    st.setString(3, ID);
                    st.executeUpdate(); // executes after satisfied
                    JOptionPane.showMessageDialog(btn, "Modules Removed");

                } catch (Exception w1) {
                    System.out.println(w1); //catches and prints the error on the console
                }
            }
        });
    }
}
