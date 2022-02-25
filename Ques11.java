package MysqlAssignment2;

import java.sql.*;

public class Ques11 {
    public static void main(String[] args) {
    try
    {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdemo", "root", "root");
        System.out.println("Connected");
        con.setAutoCommit(false);
        String ins="update student set name='ak' where id=4";
            PreparedStatement ps= con.prepareStatement(ins);
            ps.execute();
         System.out.println("Updated");
         Savepoint sp1=con.setSavepoint();
        /*String ins1="update student set name='ak' where id=7";
        PreparedStatement ps1= con.prepareStatement(ins1);
        ps1.execute();
        System.out.println("Updated");*/
        con.rollback(sp1);
        Statement st2= con.createStatement();
        String show="select * from student";
        ResultSet rs=st2.executeQuery(show);
        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%15s %15s %15s %15s %15s %15s ","ID","NAME","YEAR","PERCENTAGE","CITY","GENDER");
        System.out.println();
        System.out.println("---------------------------------------------------------------------------------------------------------------------------");
        while(rs.next()){
            System.out.printf("%14s %17s %14s %15s %14s %15s ",rs.getInt(1),rs.getString(2),rs.getInt(3),
                    rs.getString(4),rs.getFloat(5),rs.getString(6));
            System.out.println();
        }
    }catch(Exception e){
        e.printStackTrace();
    }
}
}
/*

CConnected
Updated
Updated
BEFORE ROLLBACK(SAVEPOINT)
--------------------------------------------------------------------------------------------------------------------------
             ID            NAME            YEAR      PERCENTAGE            CITY          GENDER
---------------------------------------------------------------------------------------------------------------------------
             1                ak              1           Delhi           90.0               M
             2      Mr. Mr. Mike              2           Delhi           89.0               M
             4                ak              3          Mumbai           96.0               M
             7                ak              2           Delhi           79.0               M
             8    Mr. Mr. Arthur              3       Bangalore           95.0               M
             9          Anshuman              4           Delhi           98.0               M
            10          Anshuman              3          Mumbai           93.0               M


            AFTER ROLLBACK(SAVEPOINT)
            Connected
Updated
--------------------------------------------------------------------------------------------------------------------------
             ID            NAME            YEAR      PERCENTAGE            CITY          GENDER
---------------------------------------------------------------------------------------------------------------------------
             1                ak              1           Delhi           90.0               M
             2      Mr. Mr. Mike              2           Delhi           89.0               M
             4                ak              3          Mumbai           96.0               M
             7    Mr. Mr. Thomas              2           Delhi           79.0               M
             8    Mr. Mr. Arthur              3       Bangalore           95.0               M
             9          Anshuman              4           Delhi           98.0               M
            10          Anshuman              3          Mumbai           93.0               M
 */