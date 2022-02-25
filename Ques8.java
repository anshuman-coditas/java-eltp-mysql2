package MysqlAssignment2;

import com.sun.security.jgss.GSSUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Ques8 {
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/teacherDemo", "root", "root");
            System.out.println("Connected");
            Statement st=con.createStatement();
            String show="select teacher.name,student.name from teacher,student where tid=2 and teacher.id=student.tid";
            ResultSet rs=st.executeQuery(show);
            System.out.println("TEACHER-1--------------------->");
            while(rs.next()){
                System.out.print("Teacher's Name-> "+rs.getString(1));
                System.out.print(" Student's Name->"+rs.getString(2));
                System.out.println();
            }
            Statement st2=con.createStatement();
            String show2="select teacher.name,student.name from teacher,student where tid=1 and teacher.id=student.tid";
            ResultSet rs2=st2.executeQuery(show2);
            System.out.println("TEACHER-2--------------------->");
            while(rs2.next()){
                System.out.print("Teacher's Name-> "+rs2.getString(1));
                System.out.print(" Student's Name->"+rs2.getString(2));
                System.out.println();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
/*
Connected
TEACHER-1--------------------->
Teacher's Name-> Litika Student's Name->soumya
Teacher's Name-> Litika Student's Name->gaurang
Teacher's Name-> Litika Student's Name->unmesh
TEACHER-2--------------------->
Teacher's Name-> Lata Student's Name->aarti
Teacher's Name-> Lata Student's Name->kriti
Teacher's Name-> Lata Student's Name->preeti
Teacher's Name-> Lata Student's Name->dhriti
Teacher's Name-> Lata Student's Name->smriti
 */