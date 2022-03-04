package CMS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class admin extends bodFrame implements ActionListener {



    //creating the following buttons
    private JButton button = new JButton("Add Student");
    private JButton button1 = new JButton("Del Student");
    private JButton button2 = new JButton("Add Teacher");
    private JButton button3 = new JButton("Del Teacher");
    private JButton button4 = new JButton("Add Modules");
    private JButton button5 = new JButton("Del Modules");
    private JButton button6 = new JButton("Add Courses");
    private JButton button7 = new JButton("Del Courses");
    private JButton button8 = new JButton("Report");

    private JButton button9 = new JButton("Students");
    private JButton button10 = new JButton("Teachers");



      void Admin(){

//setting up the foloowing attributes.
         bod_frame().setTitle("Course Management System - Admin");
         bod_frame().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
         bod_frame();


         //setting sizes, fonts and action listeners

         button.setBounds(160,130,140,80);
         button.setFocusable(false);
         button.addActionListener(this);
         button.setFont(new Font(" ", Font.BOLD,12));

         button1.setBounds(650,130,140,80);
         button1.setFocusable(false);
         button1.addActionListener(this);
         button1.setFont(new Font("", Font.BOLD,12));

         button2.setBounds(160,230,140,80);
         button2.setFocusable(false);
         button2.addActionListener(this);
         button2.setFont(new Font("", Font.BOLD,12));

         button3.setBounds(650,230,140,80);
         button3.setFocusable(false);
         button3.addActionListener(this);
         button3.setFont(new Font("", Font.BOLD,12));

         button4.setBounds(160,330,140,80);
         button4.setFocusable(false);
         button4.addActionListener(this);
         button4.setFont(new Font("", Font.BOLD,12));

         button5.setBounds(650,330,140,80);
         button5.setFocusable(false);
         button5.addActionListener(this);
         button5.setFont(new Font("", Font.BOLD,12));

         button6.setBounds(160,430,140,80);
         button6.setFocusable(false);
         button6.addActionListener(this);
         button6.setFont(new Font("", Font.BOLD,12));

         button7.setBounds(650,430,140,80);
         button7.setFocusable(false);
         button7.addActionListener(this);
         button7.setFont(new Font("", Font.BOLD,12));

         button8.setBounds(400,550,140,80);
         button8.setFocusable(false);
         button8.addActionListener(this);
         button8.setFont(new Font("", Font.BOLD,12));



         //
          button9.setBounds(420,130,140,80);
          button9.setFocusable(false);
          button9.addActionListener(this);
          button9.setFont(new Font("", Font.BOLD,12));

          button10.setBounds(420,230,140,80);
          button10.setFocusable(false);
          button10.addActionListener(this);
          button10.setFont(new Font("", Font.BOLD,12));



         //adding the buttons to the jframe in the class bod_frame();
         bod_frame().add(button);
         bod_frame().add(button1);
         bod_frame().add(button2);
         bod_frame().add(button3);
         bod_frame().add(button4);
         bod_frame().add(button5);
         bod_frame().add(button6);
         bod_frame().add(button7);
         bod_frame().add(button8);

          bod_frame().add(button9);
          bod_frame().add(button10);

    }




    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button) {
            add_stu obj = new add_stu();
            obj.rdBtn();  //when button is pressed rdBthn method is called

        }
        if(e.getSource()==button1) {
            del_stu obj = new del_stu();
            obj.rdBtn(); //when button is pressed rdBthn1 method is called


        }
        if(e.getSource()==button2) {
            add obj = new add();
            obj.add_teach(); //when button is pressed rdBthn2 method is called


        }
        if(e.getSource()==button3) {
            del obj = new del();
            obj.del_teach();//when button is pressed del_teach method is called
        }
        if(e.getSource()==button4) {
            add_mods obj = new add_mods();
            obj.rdBtn(); //when button is pressed rdBtn method is called from add_mods


        }
        if(e.getSource()==button5) {
            del_mod obj = new del_mod();
            obj.rdBtn(); //when button is pressed rdBtn method is called from del_mod

        }
        if(e.getSource()==button6) {
            add obj = new add();
            obj.add_Course(); //when button is pressed add_Course method is called from add

        }
        if(e.getSource()==button7) {
            del obj = new del();
            obj.del_course(); //when button is pressed del_course method is called from del
        }
        if(e.getSource()==button8) {
            report obj = new report();
            obj.result(); //when button is pressed result method is called from report

        }


        if(e.getSource()==button9) {
            jtable obj = new jtable();
            obj.student(); //when button is pressed result method is called from report

        }

        if(e.getSource()==button10) {
            jtable obj = new jtable();
            obj.teachers(); //when button is pressed result method is called from report
        }
    }
}
