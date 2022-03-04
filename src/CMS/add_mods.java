package CMS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;


public class add_mods implements ActionListener {
    JFrame frame2 = new JFrame();  //radiobutton
    JFrame frame1 = new JFrame();
    JPanel panel = new JPanel();
    JLabel M_name = new JLabel("Module Name");
    JLabel C_name = new JLabel("Course Name");


    JTextField M_name_text = new JTextField(20);
    JTextField C_name_text = new JTextField(20);


    JButton btn = new JButton("ADD");

    String url = "jdbc:mysql://localhost:3306/CMS";
    String uname = "root";
    String pwd = "";


    //adding the three radio buttons
    JRadioButton radBtn;
    JRadioButton radBtn1;
    JRadioButton radBtn2;
    ButtonGroup group = new ButtonGroup();

    void frame() {
        //adding attributes to frame
        frame1.setSize(400, 260);
        frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame1.setLocationRelativeTo(null);
        frame1.add(panel);

    }

    void panel() {
        //setting the attributes to  the label and the textfields
        panel.setLayout(null);
        M_name.setBounds(45, 20, 80, 25);
        C_name.setBounds(45, 60, 80, 25);
        M_name_text.setBounds(125, 20, 220, 25);
        C_name_text.setBounds(125, 60, 220, 25);

        btn.setBounds(90, 135, 80, 25);


        //adding the labela and the textfield to pannel
        panel.add(M_name);
        panel.add(C_name);
        panel.add(M_name_text);
        panel.add(C_name_text);
        panel.add(btn);


    }


    void rdBtn() {

        radBtn = new JRadioButton("Level 4");
        radBtn1 = new JRadioButton("Level 5");
        radBtn2 = new JRadioButton("Level 6");

        radBtn.addActionListener(this);
        radBtn1.addActionListener(this);
        radBtn2.addActionListener( this);

        group.add(radBtn);
        group.add(radBtn1);
        group.add(radBtn2);

        frame2.setLayout(new FlowLayout());
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setLocationRelativeTo(null);
        frame2.setSize(300, 300);
        frame2.add(radBtn);
        frame2.add(radBtn1);
        frame2.add(radBtn2);
        frame2.pack();
        frame2.setVisible(true);

    }

    //for the selected item from the radio button that is  year 1 , 2 and 3
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == radBtn) {
            addMods1();  //when the year 1 is pressed addmods1 method is called
        } else if (e.getSource() == radBtn1) {
            addMods2();//when the year 2 is pressed addmods2 method is called

        } else if (e.getSource() == radBtn2) {
            addMods3();//when the year 3 is pressed addmods3 method is called
        }

    }

    public void addMods1() {
        frame();
        panel(); //calling the two methods

        frame1.setVisible(true);
        frame1.setTitle("Add - Module level 4");
        btn.addActionListener(e -> {
// if btn is pressed
            if (e.getSource() == btn) {

                //get text from the text fields
                String Mname = M_name_text.getText();
                String Cname = C_name_text.getText();


                //arraylist to store the texts from the text fields
                ArrayList<String> info = new ArrayList<>();
                info.add(Mname);
                info.add(Cname);

                //arraylist to store the column names
                ArrayList<String> insertinto = new ArrayList<>();
                insertinto.add("moduleName");
                insertinto.add("Course");
                System.out.println(info);


                try {
                    System.out.println("add");
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection(url, uname, pwd);
                    //inserting into table yr1moduels by using   arraylist  insertinto to get the column names and inserting  the values of the array list info
                    PreparedStatement st = con.prepareStatement("insert into yr1modules (" + String.join(", ", insertinto) + ") values( '" + String.join("', '", info) + "')");


                    st.executeUpdate();
                    JOptionPane.showMessageDialog(btn, "Module has been Added");


                } catch (Exception w1) {
                    System.out.println(w1);
                }
            }
        });
    }


    public void addMods2() {
        frame();
        panel();

        frame1.setVisible(true);
        frame1.setTitle("Add - Module level 5");
        btn.addActionListener(e -> {

            if (e.getSource() == btn) {

                String Mname = M_name_text.getText();
                String Cname = C_name_text.getText();

                ArrayList<String> info = new ArrayList<>();
                info.add(Mname);
                info.add(Cname);

                ArrayList<String> insertinto = new ArrayList<>();
                insertinto.add("moduleName");
                insertinto.add("Course");
                System.out.println("this is arraylist");
                System.out.println(info);


                try {
                    System.out.println("add");
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection(url, uname, pwd);
                    //inserting into table yr2moduels by using   arraylist  insertinto to get the column names and inserting  the values of the array list info
                    PreparedStatement st = con.prepareStatement("insert into yr2modules (" + String.join(", ", insertinto) + ") values( '" + String.join("', '", info) + "')");

                    st.executeUpdate();
                    JOptionPane.showMessageDialog(btn, "Module Added");

                } catch (Exception w1) {
                    System.out.println(w1);
                }
            }
        });
    }

    public void addMods3() {
        frame();
        panel();

        frame1.setVisible(true);
        frame1.setTitle("Add - Module level 6");
        btn.addActionListener(e -> {
            if (e.getSource() == btn) {

                String Mname = M_name_text.getText();
                String Cname = C_name_text.getText();

                ArrayList<String> info = new ArrayList<>();
                info.add(Mname);
                info.add(Cname);

                ArrayList<String> insertinto = new ArrayList<>();
                insertinto.add("moduleName");
                insertinto.add("Course");
                System.out.println("this is arraylist");
                System.out.println(info);


                try {
                    System.out.println("add");
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection(url, uname, pwd);
                    //inserting into table yr3moduels by using   arraylist  insertinto to get the column names and inserting  the values of the array list info
                    PreparedStatement st = con.prepareStatement("insert into yr3modules (" + String.join(", ", insertinto) + ") values( '" + String.join("', '", info) + "')");

                    st.executeUpdate();
                    JOptionPane.showMessageDialog(btn, "Module Added");

                } catch (Exception w1) {
                    System.out.println(w1);
                }
            }
        });
    }
}



