package ExamSystem;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.*;
import java.sql.*;  

public class Main extends JFrame implements ActionListener {
    JPanel panel;
    JLabel user_label, password_label, message, heading;
    JTextField userName_text;
    JPasswordField password_text;
    JButton submit;
    Main() {
        heading = new JLabel("Login");
        heading.setBounds(110,95,80,30);
        heading.setFont(new Font("Segoe UI", Font.BOLD, 25));
        user_label = new JLabel("User Name :");
        user_label.setBounds(130,150,80,30);
        userName_text = new JTextField();
        userName_text.setBounds(220,150, 100,30);    
        password_label = new JLabel("Password :");
        password_label.setBounds(130,190, 80,30);       
        password_text = new JPasswordField();
        password_text.setBounds(220,190,100,30);   
        submit = new JButton("SUBMIT");
        submit.setBounds(178,270, 100,30); 
        message = new JLabel();
        message.setBounds(190,310, 120,30);   
        add(heading);
        add(user_label);
        add(userName_text);
        add(password_label);
        add(password_text);
        add(message);
        add(submit);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        submit.addActionListener(this);
        setTitle("Login ");
        setSize(500,500);    
        setLayout(null);    
        setVisible(true);
        setLocation(250,100);

    }
    public static void main(String[] args) {
        new Main();
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
    String userName = userName_text.getText();
    String password = password_text.getText();
    try {
    Connection connection =(Connection) DriverManager.getConnection
    ("jdbc:mysql://localhost:3306/cs433?useSSL=false","root", "rock");
    PreparedStatement st = (PreparedStatement) connection.prepareStatement
    ("Select username, password from student_result where username=? and password=?");
    st.setString(1, userName);
    st.setString(2, password);
    ResultSet rs = st.executeQuery();
    if (rs.next()) {
    new OnlineTest(userName,password);
    dispose();
    } else {
     message.setText(" Invalid user.. ");
     }
     } catch (SQLException sqlException) {
       sqlException.printStackTrace();}

    }
}

