package MysqlAssignment2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Ques6 {
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.jdbc.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Employee", "root", "root");
            System.out.println("Connected");
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            String show="select * from teacher";
            ResultSet rs=st.executeQuery(show);
           /* rs.last();
            rs.moveToInsertRow();
            rs.updateInt(1,6);
            rs.updateString(2,"PQR");
            rs.updateString(3,"Lead");
            rs.insertRow();*/
            System.out.println("Contents:: ");
            rs.absolute(0);
            while(rs.next()){
                System.out.print("id-> "+rs.getInt(1));
                System.out.print(" Name-> "+rs.getString(2));
                System.out.print(" Designation-> "+rs.getString(3));
                System.out.println();
            }

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
/*
Connected
Contents::
id-> 1 Name-> ABC Designation-> Associate
id-> 2 Name-> DEF Designation-> Associate
id-> 3 Name-> GHI Designation-> Head
id-> 4 Name-> JKL Designation-> Head
id-> 5 Name-> MNO Designation-> Lead
id-> 6 Name-> PQR Designation-> Lead
 */