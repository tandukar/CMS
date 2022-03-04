package CMS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class launch extends bodFrame implements ActionListener {

    //encapsulating
    private JLabel label1 = new JLabel("Login as: ");
    private JButton button  = new JButton("Login!");
    String launch[]={"Student","Teacher","Admin",};

    private JComboBox cb=new JComboBox(launch);
    //constructor
    launch(){
        button(); //calling the methods
        run();
    }

    public void button() {
//setting button sizes and adding action listeners
        button.setBounds(200, 360, 80, 25);
        button.setFocusable(false);
        button.addActionListener(this);
    }

    public void frame() {
        bod_frame().setTitle("Course Management System ");
        bod_frame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //adding components to the JFrame frame
        label1.setBounds(120, 230, 80, 25);
        label1.setFont(new Font("Helvetica Neue", Font.BOLD, 16));
        cb.setBounds(200, 230,100,25);
        bod_frame().add(label1);
        bod_frame().add(cb);
        bod_frame().add(button);

    }

    void run(){
        frame();
        bod_frame().setSize(500,700);
    }
    @Override
    //Action listeners, for when a button is pressed
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button) {
            String log = (String) cb.getItemAt(cb.getSelectedIndex());  //this reads the selectedindex from the combobox
            System.out.println(log);
            if ("Student".equals(log)) {
                Login obj  = new Login();
               obj.radioBtn(); //calls  radioBtn From login
            }
            if ("Teacher".equals(log)) {
                Login obj  = new Login();
                obj.loginTeach();  //calls  loginTeach From login
            }
            if ("Admin".equals(log)) {
                Login obj  = new Login();
                obj.loginAdmin(); //calls  loginAdmin From login
            }
            }

        }



}