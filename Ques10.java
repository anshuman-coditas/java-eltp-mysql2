package MysqlAssignment2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Ques10 {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/teacherDemo", "root", "root");
            System.out.println("Connected");
            Statement st=con.createStatement();
            String show="select s.name,teacher3.name as Teacher from student3 as s left join teacherstudent on s.id=teacherstudent.sid left join teacher3 on teacher3.id=teacherstudent.tid";
            ResultSet rs=st.executeQuery(show);
            System.out.println("TEACHER-STUDENT M:M--------------------->");
            while(rs.next()){
                System.out.print("Student's Name-> "+rs.getString(1));
                System.out.print("--->(Taught By) Teacher's Name Name->"+rs.getString(2));
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
/*
Connected
TEACHER-STUDENT M:M--------------------->
Student's Name-> Thomas--->(Taught By) Teacher's Name Name->Mike
Student's Name-> Thomas--->(Taught By) Teacher's Name Name->Jessica
Student's Name-> Arthur--->(Taught By) Teacher's Name Name->null
Student's Name-> John--->(Taught By) Teacher's Name Name->Mike
Student's Name-> John--->(Taught By) Teacher's Name Name->Jessica
Student's Name-> Michael--->(Taught By) Teacher's Name Name->null
Student's Name-> Ada--->(Taught By) Teacher's Name Name->null
Student's Name-> Alfie--->(Taught By) Teacher's Name Name->Jessica
Student's Name-> Charlie--->(Taught By) Teacher's Name Name->Jessica
Student's Name-> Winston--->(Taught By) Teacher's Name Name->Jessica
Student's Name-> Anabelle--->(Taught By) Teacher's Name Name->Alex
Student's Name-> Anabelle--->(Taught By) Teacher's Name Name->Mike
Student's Name-> Anabelle--->(Taught By) Teacher's Name Name->Harvey
 */