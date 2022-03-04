package CMS;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class mod4 extends Component  {

     String url = "jdbc:mysql://localhost:3306/CMS";
     String uname = "root";
     String pwd = "";
     JFrame frame = new JFrame(); //creating a new frame
     JLabel l = new JLabel("Change or Add modules:");
    JComboBox<String> box1 = new JComboBox<>(); //creating a new jcombobox


    public void body() {
        //setting   the  attributes for the frame
        l.setBounds(90, 60,200,30);
        l.setFont(new Font("", Font.BOLD,15));
        box1.setBounds(110, 100,120,30);
        frame.setSize(350, 250);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.getContentPane().setBackground(new Color(40, 170, 150));
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.add(box1);
        frame.add(l);
    }

    public  void selectmodules(String id, String course) {
        body();


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");//loading the driver
            Connection con = DriverManager.getConnection(url, uname, pwd);  //creating a connection
            PreparedStatement pst = con.prepareStatement("SELECT * FROM yr3modules where Course =?"); //selcting from yr3modules table
            pst.setString(1,course);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {  //if result set runs without any hitch it runs the following code
                String Mname = rs.getString("moduleName");
                box1.addItem(Mname);  //gets the strings stored in moduleName column and adds then into the combo box.

            }


            box1.addActionListener(e -> {
                System.out.println("Value: " + box1.getSelectedItem());
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    PreparedStatement st = con.prepareStatement("Update students set module4=?  where  studentID=?"); //updating students where the module 4 and the studentID are received from the parameter passed
                    st.setString(1, (String) box1.getSelectedItem());  //adds the selected item from the combobox in the form of string
                    st.setString(2, id); //checks the students by using id


                    st.executeUpdate(); //executes
                } catch (SQLException | ClassNotFoundException ex) { //catches and prints out he error in the console
                    ex.printStackTrace();
                }

            });
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();//catches and prints out he error in the console
        }
    }


}
