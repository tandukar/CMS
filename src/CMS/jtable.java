package CMS;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
public class jtable
{
        public void yrmod1(String mods){
        try
        {
            String url = "jdbc:mysql://localhost:3306/CMS";
            String uname = "root";
            String pwd = "";

            Connection con = DriverManager.getConnection(url, uname, pwd);

            PreparedStatement st = con.prepareStatement("SELECT * FROM students where module1 =? ");
            st.setString(1, mods);

            System.out.println(mods);


            ResultSet res = st.executeQuery();
            //the prepared statement is executed
//this column is used for displaying the rows

            String[] columns = { "ID","Year","First Name","Last Name","Module"}; //This uses the passed parameter "mods" to find the module and then retrieve those rows and then store in the data
            String[][] data = new String[50][5];
           //the rows with the same mods as the statement are  fetched and stored in the variables

            int i = 0;
            while (res.next()) {
                int id = res.getInt("studentID");
                int year = res.getInt("year");
                String Fnam = res.getString("firstName");
                String Lnam = res.getString("lastName");
                String mod = res.getString("module1");
                //storing in the data



                data[i][0] = id + "";
                data[i][1] = year +"";
                data[i][2] = Fnam;
                data[i][3] = Lnam;
                data[i][4] = mod;
                i++; //keeps on adding in data untill the interation is matched
            }

            DefaultTableModel model = new DefaultTableModel(data, columns);//This is an implementation of TableModel that uses a Vector of Vectors to store the cell value objects.
            JTable table = new JTable(model);
            table.setShowGrid(true);
            table.setShowVerticalLines(true);
            table.setEnabled(false);

            JScrollPane pane = new JScrollPane(table);
            JFrame f = new JFrame("Students");
            JPanel panel = new JPanel();
            panel.add(pane);
            f.add(panel);
            f.setSize(500, 350);
            f.setLocationRelativeTo(null);
            f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            f.setVisible(true);

        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void yrmod2(String mods) {
        try {
            String url = "jdbc:mysql://localhost:3306/CMS";
            String uname = "root";
            String pwd = "";

            Connection con = DriverManager.getConnection(url, uname, pwd);

            PreparedStatement st = con.prepareStatement("SELECT * FROM students where module2 =?");
            st.setString(1, mods);
            System.out.println(mods);
            //This uses the passed parameter "mods" to find the module and then retrieve those rows and then store in the data


            ResultSet res = st.executeQuery();
            //the prepared statement is executed
            //this column is used for displaying the rows

            String[] columns = {"ID", "Year", "First Name", "Last Name ", "Module"};
            //the rows with the same mods as the statement are  fetched and stored in the variables
            String[][] data = new String[50][5];

            int i = 0;
            while (res.next()) {
                int id = res.getInt("studentID");
                int year = res.getInt("year");
                String Fnam = res.getString("firstName");
                String Lnam = res.getString("lastName");
                String mod = res.getString("module2");

                //the rows with the same mods as the statement are  fetched and stored in the variables

                //storing in the data
                data[i][0] = id + "";
                data[i][1] = year + "";
                data[i][2] = Fnam;
                data[i][3] = Lnam;
                data[i][4] = mod;
                i++;  //keeps on adding in data untill the interation is matched
            }

            DefaultTableModel model = new DefaultTableModel(data, columns); ////This is an implementation of TableModel that uses a Vector of Vectors to store the cell value objects.
            JTable table = new JTable(model);
            table.setShowGrid(true);
            table.setShowVerticalLines(true);
            table.setEnabled(false);

            JScrollPane pane = new JScrollPane(table);
            JFrame f = new JFrame("Students");
            JPanel panel = new JPanel();
            panel.add(pane);
            f.add(panel);
            f.setSize(500, 350);
            f.setLocationRelativeTo(null);
            f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            f.setVisible(true);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void yrmod3(String mods) {
        try {
            String url = "jdbc:mysql://localhost:3306/CMS";
            String uname = "root";
            String pwd = "";

            Connection con = DriverManager.getConnection(url, uname, pwd);

            PreparedStatement st = con.prepareStatement("SELECT * FROM students where module3 =?");
            //This uses the passed parameter "mods" to find the module and then retrieve those rows and then store in the data
            st.setString(1, mods);
            System.out.println(mods);

            Statement stm = con.createStatement();
            ResultSet res = st.executeQuery();

            String[] columns = {"ID", "Year", "First Name", "Last Name", "Module"};
            String[][] data = new String[50][5];

            int i = 0;
            while (res.next()) {
                int id = res.getInt("studentID");
                int year = res.getInt("year");
                String Fnam = res.getString("firstName");
                String Lnam = res.getString("lastName");
                String mod = res.getString("module3");


                data[i][0] = id + "";
                data[i][1] = year + "";
                data[i][2] = Fnam;
                data[i][3] = Lnam;
                data[i][4] = mod;
                i++;
            }

            DefaultTableModel model = new DefaultTableModel(data, columns); //This is an implementation of TableModel that uses a Vector of Vectors to store the cell value objects.
            JTable table = new JTable(model);
            table.setShowGrid(true);
            table.setShowVerticalLines(true);
            table.setEnabled(false);

            JScrollPane pane = new JScrollPane(table);
            JFrame f = new JFrame("Students");
            JPanel panel = new JPanel();
            panel.add(pane);
            f.add(panel);
            f.setSize(500, 350);
            f.setLocationRelativeTo(null);
            f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            f.setVisible(true);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void yrmod4(String mods) {  //this is for module4
        try {
            String url = "jdbc:mysql://localhost:3306/CMS";
            String uname = "root";
            String pwd = "";

            Connection con = DriverManager.getConnection(url, uname, pwd);

            PreparedStatement st = con.prepareStatement("SELECT * FROM students where module4 =?");
            //This uses the passed parameter "mods" to find the module and then retrieve those rows and then store in the data
            st.setString(1, mods);
            System.out.println(mods);

            ResultSet res = st.executeQuery();  //statement is executed

            String[] columns = {"ID", "Year", "First Name", "Last Name", "Module"};
            //this column is used for displaying the rows
            String[][] data = new String[50][5];

            int i = 0;
            while (res.next()) {
                int id = res.getInt("studentID");
                int year = res.getInt("year");
                String Fnam = res.getString("firstName");
                String Lnam = res.getString("lastName");
                String mod = res.getString("module4");
                //the rows with the same mods as the statement are  fetched and stored in the variables

                //storing in the data
                data[i][0] = id + "";
                data[i][1] = year + "";
                data[i][2] = Fnam;
                data[i][3] = Lnam;
                data[i][4] = mod;
                i++; //keeps on adding in data untill the interation is matched
            }

            DefaultTableModel model = new DefaultTableModel(data, columns); //This is an implementation of TableModel that uses a Vector of Vectors to store the cell value objects.
            JTable table = new JTable(model);
            table.setShowGrid(true);
            table.setShowVerticalLines(true);
            table.setEnabled(false);  //adding attributes

            JScrollPane pane = new JScrollPane(table);
            JFrame f = new JFrame("Students");
            JPanel panel = new JPanel();
            panel.add(pane);
            f.add(panel);
            f.setSize(500, 350);
            f.setLocationRelativeTo(null);
            f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            f.setVisible(true);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void yrmodst1(String mods){ //this is for teachers
        try
        {
            String url = "jdbc:mysql://localhost:3306/CMS";
            String uname = "root";
            String pwd = "";

            Connection con = DriverManager.getConnection(url, uname, pwd);

            PreparedStatement st = con.prepareStatement("SELECT * FROM teachers where modules1 =?");
            //This uses the passed parameter "mods" to find the module and then retrieve those rows and then store in the data
            st.setString(1, mods);

            ResultSet res = st.executeQuery();

            String[] columns = { "ID","First Name","Last Name","Module"};
            String[][] data = new String[50][5];

            int i = 0;
            while (res.next()) {
                int id = res.getInt("teachID");
                String Fnam = res.getString("firstName");
                String Lnam = res.getString("lastName");
                String mod = res.getString("modules1");

                data[i][0] = id + "";
                data[i][1] = Fnam;
                data[i][2] = Lnam;
                data[i][3] = mod;
                i++;
            }
            System.out.println(mods);

            DefaultTableModel model = new DefaultTableModel(data, columns);//This is an implementation of TableModel that uses a Vector of Vectors to store the cell value objects.
            JTable table = new JTable(model);
            table.setShowGrid(true);
            table.setShowVerticalLines(true);
            table.setEnabled(false);

            JScrollPane pane = new JScrollPane(table);
            JFrame f = new JFrame("Teachers");
            JPanel panel = new JPanel();
            panel.add(pane);
            f.add(panel);
            f.setSize(500, 350);
            f.setLocationRelativeTo(null);
            f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            f.setVisible(true);

        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void yrmodst2(String mods){
        try
        {
            String url = "jdbc:mysql://localhost:3306/CMS";
            String uname = "root";
            String pwd = "";

            Connection con = DriverManager.getConnection(url, uname, pwd);

            PreparedStatement st = con.prepareStatement("SELECT * FROM teachers where modules2 =?");
            //This uses the passed parameter "mods" to find the module and then retrieve those rows and then store in the data
            st.setString(1, mods);


            ResultSet res = st.executeQuery();

            String[] columns = { "ID","First Name","Last Name","Module"};
            String[][] data = new String[50][5];

            int i = 0;
            while (res.next()) {
                int id = res.getInt("teachID");
                String Fnam = res.getString("firstName");
                String Lnam = res.getString("lastName");
                String mod = res.getString("modules2");

                data[i][0] = id + "";
                data[i][1] = Fnam;
                data[i][2] = Lnam;
                data[i][3] = mod;
                i++;
            }

            DefaultTableModel model = new DefaultTableModel(data, columns);  //his is an implementation of TableModel that uses a Vector of Vectors to store the cell value objects.
            JTable table = new JTable(model);
            table.setShowGrid(true);
            table.setShowVerticalLines(true);
            table.setEnabled(false);

            JScrollPane pane = new JScrollPane(table);
            JFrame f = new JFrame("Teachers");
            JPanel panel = new JPanel();
            panel.add(pane);
            f.add(panel);
            f.setSize(500, 350);
            f.setLocationRelativeTo(null);
            f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            f.setVisible(true);

        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void yrmodst3(String mods){
        try
        {
            String url = "jdbc:mysql://localhost:3306/CMS";
            String uname = "root";
            String pwd = "";

            Connection con = DriverManager.getConnection(url, uname, pwd);

            PreparedStatement st = con.prepareStatement("SELECT * FROM teachers where modules3 =?");
            //This uses the passed parameter "mods" to find the module and then retrieve those rows and then store in the data
            st.setString(1, mods);

            ResultSet res = st.executeQuery();
            //the prepared statement is executed
            //this column is used for displaying the rows

            String[] columns = { "ID","First Name","Last Name","Module"};
            String[][] data = new String[50][5];

            int i = 0;
            while (res.next()) {
                int id = res.getInt("teachID");
                String Fnam = res.getString("firstName");
                String Lnam = res.getString("lastName");
                String mod = res.getString("modules3");
                //the rows with the same mods as the statement are  fetched and stored in the variables

                //storing in the data

                data[i][0] = id + "";
                data[i][1] = Fnam;
                data[i][2] = Lnam;
                data[i][3] = mod;
                i++;           //keeps on adding in data untill the interation is matched

            }

            DefaultTableModel model = new DefaultTableModel(data, columns); //This is an implementation of TableModel that uses a Vector of Vectors to store the cell value objects.
            JTable table = new JTable(model);
            table.setShowGrid(true);
            table.setShowVerticalLines(true);
            table.setEnabled(false);

            JScrollPane pane = new JScrollPane(table);
            JFrame f = new JFrame("Teachers");
            JPanel panel = new JPanel();
            panel.add(pane);
            f.add(panel);
            f.setSize(500, 350);
            f.setLocationRelativeTo(null);
            f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            f.setVisible(true);

        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void yrmodst4(String mods){
        try
        {
            String url = "jdbc:mysql://localhost:3306/CMS";
            String uname = "root";
            String pwd = "";

            Connection con = DriverManager.getConnection(url, uname, pwd);

            PreparedStatement st = con.prepareStatement("SELECT * FROM teachers where modules4 =?");
            st.setString(1, mods);


            ResultSet res = st.executeQuery(); //the prepared statement is executed

            String[] columns = { "ID","First Name","Last Name","Module"}; //this column is used for displaying the rows
            String[][] data = new String[50][5];
//This uses the passed parameter "mods" to find the module and then retrieve those rows and then store in the data
            int i = 0;
            while (res.next()) {
                int id = res.getInt("teachID");
                String Fnam = res.getString("firstName");
                String Lnam = res.getString("lastName");
                String mod = res.getString("modules4");
//the rows with the same mods as the statement are  fetched and stored in the variables
                //storing in the data
                data[i][0] = id + "";
                data[i][1] = Fnam;
                data[i][2] = Lnam;
                data[i][3] = mod;
                i++; //keeps on adding in data untill the interation is matched
            }

            DefaultTableModel model = new DefaultTableModel(data, columns);//This is an implementation of TableModel that uses a Vector of Vectors to store the cell value objects.
            JTable table = new JTable(model);
            table.setShowGrid(true);
            table.setShowVerticalLines(true);
            table.setEnabled(false);

            JScrollPane pane = new JScrollPane(table);
            JFrame f = new JFrame("Teachers");
            JPanel panel = new JPanel();
            panel.add(pane);
            f.add(panel);
            f.setSize(500, 350);
            f.setLocationRelativeTo(null);
            f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            f.setVisible(true);

        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void teachers( ){
        try
        {
            String url = "jdbc:mysql://localhost:3306/CMS";
            String uname = "root";
            String pwd = "";
            Connection con = DriverManager.getConnection(url, uname, pwd);
            PreparedStatement st = con.prepareStatement("SELECT * FROM teachers ");
            ResultSet res = st.executeQuery();
            //the prepared statement is executed
//this column is used for displaying the rows

            String[] columns = { "ID","First Name","Last Name","Module1","Module2","Module3","Module4"}; //This uses the passed parameter "mods" to find the module and then retrieve those rows and then store in the data
            String[][] data = new String[50][7];
            //the rows with the same mods as the statement are  fetched and stored in the variables

            int i = 0;
            while (res.next()) {
                int id = res.getInt("teachID");
                String Fnam = res.getString("firstName");
                String Lnam = res.getString("lastName");
                String mod1 = res.getString("modules1");
                String mod2 = res.getString("modules2");
                String mod3 = res.getString("modules3");
                String mod4 = res.getString("modules4");

                //storing in the data



                data[i][0] = id + "";
                data[i][1] = Fnam;
                data[i][2] = Lnam;
                data[i][3] = mod1;
                data[i][4] = mod2;
                data[i][5] = mod3;
                data[i][6] = mod4;
                i++; //keeps on adding in data untill the interation is matched
            }

            DefaultTableModel model = new DefaultTableModel(data, columns);//This is an implementation of TableModel that uses a Vector of Vectors to store the cell value objects.
            JTable table = new JTable(model);
            table.setShowGrid(true);
            table.setShowVerticalLines(true);
            table.setEnabled(false);

            JScrollPane pane = new JScrollPane(table);
            JFrame f = new JFrame("Teachers");
            JPanel panel = new JPanel();
            panel.add(pane);
            f.add(panel);
            f.setSize(800, 350);
            f.setLocationRelativeTo(null);
            f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            f.setVisible(true);

        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void student( ){
        try
        {
            String url = "jdbc:mysql://localhost:3306/CMS";
            String uname = "root";
            String pwd = "";

            Connection con = DriverManager.getConnection(url, uname, pwd);

            PreparedStatement st = con.prepareStatement("SELECT * FROM students");



            ResultSet res = st.executeQuery();
            //the prepared statement is executed
//this column is used for displaying the rows

            String[] columns = { "ID","Year","First Name","Last Name","Module1","Module2","Module3","Module4"}; //This uses the passed parameter "mods" to find the module and then retrieve those rows and then store in the data
            String[][] data = new String[50][8];
            //the rows with the same mods as the statement are  fetched and stored in the variables

            int i = 0;
            while (res.next()) {
                int id = res.getInt("studentID");
                int year = res.getInt("year");
                String Fnam = res.getString("firstName");
                String Lnam = res.getString("lastName");
                String mod1 = res.getString("module1");
                String mod2 = res.getString("module2");
                String mod3 = res.getString("module3");
                String mod4 = res.getString("module4");

                //storing in the data



                data[i][0] = id + "";
                data[i][1] = year +"";
                data[i][2] = Fnam;
                data[i][3] = Lnam;
                data[i][4] = mod1;
                data[i][5] = mod2;
                data[i][6] = mod3;
                data[i][7] = mod4;
                i++; //keeps on adding in data untill the interation is matched
            }

            DefaultTableModel model = new DefaultTableModel(data, columns);//This is an implementation of TableModel that uses a Vector of Vectors to store the cell value objects.
            JTable table = new JTable(model);
            table.setShowGrid(true);
            table.setShowVerticalLines(true);
            table.setEnabled(false);

            JScrollPane pane = new JScrollPane(table);
            JFrame f = new JFrame("Students");
            JPanel panel = new JPanel();
            panel.add(pane);
            f.add(panel);
            f.setSize(800, 350);
            f.setLocationRelativeTo(null);
            f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            f.setVisible(true);

        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

}