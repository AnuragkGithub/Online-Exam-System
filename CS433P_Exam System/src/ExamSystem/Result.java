package ExamSystem;
import javax.swing.*;
import java.sql.*;
public class Result {
    public Result(int count, String User, String Pass) {
        try { 
               String myDriver = "com.mysql.jdbc.Driver";
               String myUrl = "jdbc:mysql://localhost:3306/cs433?useSSL=false";
               Class.forName(myDriver);
               Connection conn = DriverManager.getConnection(myUrl, "root", "rock");
               String query = "update student_result set Total_marks = ? where username = ?";
               PreparedStatement preparedStmt = conn.prepareStatement(query);
               preparedStmt.setInt   (1, count);
               preparedStmt.setString(2, User);
               preparedStmt.executeUpdate();
               conn.close(); 
        } catch (Exception e) { 
            System.err.println("Got an exception! "); 
            System.err.println(e.getMessage()); 
        } 
       
        JFrame f= new JFrame("Result");
        
        JLabel l1, l2;
        l1=new JLabel(User + " your Result: ");
        l1.setBounds(30,50, 270,30);
        l2=new JLabel();
        l2.setBounds(140,50, 250,30);
        f.add(l1);f.add(l2);
        f.setSize(500,500);
        f.setLayout(null);
        f.setVisible(true);
        f.setLocation(250,100);
        l2.setText(Integer.toString(count));
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String args[])
    {
    }
}
