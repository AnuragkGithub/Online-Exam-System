package ExamSystem;
import java.sql.*;  
class MysqlCon{  
public static void main(String args[]){  
  String Username = "anurag";
   String Password = "anu";
   String U,P;
try{  
Class.forName("com.mysql.jdbc.Driver");  
Connection con=DriverManager.getConnection
("jdbc:mysql://localhost:3306/cs433?useSSL=false","root","rock");  
Statement stmt=con.createStatement();  
ResultSet rs=stmt.executeQuery("select * from student_result");  
while(rs.next())  {
        if(Username == rs.getString(1) || Password == rs.getString(2))
            System.out.println("Correct");
       else
            System.out.println("Wrong");}
con.close();  
}catch(Exception e){ System.out.println(e);}}}  