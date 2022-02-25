package MysqlAssignment2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Ques9 {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/teacherDemo", "root", "root");
            System.out.println("Connected");
            Statement st=con.createStatement();
            String show="select teacher1.name,student1.name from teacher1,student1 where teacher1.id=student1.tid;";
            ResultSet rs=st.executeQuery(show);
            System.out.println("TEACHER-STUDENT 1:1--------------------->");
            while(rs.next()){
                System.out.print("Teacher's Name-> "+rs.getString(1));
                System.out.print("---> Student's Name->"+rs.getString(2));
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
/*
Connected
TEACHER-STUDENT 1:1--------------------->
Teacher's Name-> Alex---> Student's Name->sk
Teacher's Name-> Jessica---> Student's Name->dk
Teacher's Name-> Alicia---> Student's Name->Ak
Teacher's Name-> Emily---> Student's Name->kk
Teacher's Name-> Thomas Shelby---> Student's Name->pk
 */