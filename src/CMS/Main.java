package CMS;

public class Main {

    public static void main(String[] args) {

        CreateDB obj = new CreateDB();
        obj.createDB(); //executes from createDB method

        CreateTable obj1 = new CreateTable();
        obj1.createTable_CMS(); //executes from createTable_CMS method

//        //executes from insert_Admin method


        new launch();



    }
}
