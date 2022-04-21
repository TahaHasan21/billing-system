package com.billing.pages;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.FontUIResource;
import java.sql.*;

public class Signup {
  JFrame signupFrame;

  public Signup() {
    JFrame signupFrame = new JFrame("Signup Page");
    JLabel userNameLabel = new JLabel("Username");
    userNameLabel.setBounds(600, 150, 80, 40);
    JLabel passwordLabel = new JLabel("Password");
    passwordLabel.setBounds(600, 200, 80, 40);
    JLabel confpasswordLabel = new JLabel("Confirm Password");
    confpasswordLabel.setBounds(600, 250, 100, 40);
    JTextField userNameText = new JTextField();
    userNameText.setBounds(750, 150, 150, 30);
    JPasswordField passwordText = new JPasswordField();
    passwordText.setBounds(750, 200, 150, 30);
    JPasswordField confpasswordText = new JPasswordField();
    confpasswordText.setBounds(750, 250, 150, 30);
    JButton signupbtn = new JButton("Signup");
    signupbtn.setBounds(700, 350, 100, 40);
    JButton cancelBttn = new JButton("Back");
    cancelBttn.setBounds(700, 400, 100, 40);
    JLabel invalid = new JLabel("");
    invalid.setBounds(675, 480, 300, 50);
    JLabel title = new JLabel("VIT Billing System");
    title.setFont(new FontUIResource("Noto Sans", FontUIResource.BOLD, 25));
    title.setBorder(new EmptyBorder(10, 10, 10, 10));
    title.setBounds(625, 25, 400, 40);
    JLabel titl = new JLabel("SignUp page");
    titl.setFont(new FontUIResource("Noto Sans", FontUIResource.BOLD, 25));
    titl.setBorder(new EmptyBorder(10, 10, 10, 10));
    titl.setBounds(660, 75, 400, 40);
    signupFrame.add(titl);
    signupFrame.add(title);
    signupFrame.add(invalid);
    signupFrame.add(userNameLabel);
    signupFrame.add(userNameText);
    signupFrame.add(passwordLabel);
    signupFrame.add(confpasswordLabel);
    signupFrame.add(passwordText);
    signupFrame.add(confpasswordText);
    signupFrame.add(signupbtn);
    signupFrame.add(cancelBttn);
    signupFrame.setSize(1650, 1080);
    signupFrame.setLayout(null);
    signupFrame.setVisible(true);
    signupbtn.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent e) {
        String userName = userNameText.getText();
        String password = passwordText.getText();
        if(checkUserName(userName)){
            invalid.setText("The UserName Already Exist");
        }
        
        try {
        
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/billing", "root", "Iamtahu321#$");

        String query = "insert into Account(uname,pwd)"+  "values(?,?)";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, userName);
        ps.setString(2, password);

        if (ps.executeUpdate() > 0){
            signupFrame.dispose();
            System.out.println("Account Created Successfully");
            new Home();
        } 
        else {
          if (userName.equals("") && password.equals("")) {
            invalid.setText("Please enter the username and password");  

       }
    } 
}
       catch (Exception ex) {
        ex.printStackTrace();
       }
        
        
      }

    });


    cancelBttn.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent e) {
        new Login();

        signupFrame.setVisible(false);
        signupFrame.dispose();

      }
    });

  }


public boolean checkUserName(String username){
    boolean checkuname = false;
  
    try {
        
        Connection connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/billing", "root", "Iamtahu321#$");

        PreparedStatement st =connection.prepareStatement("Select uname from Account where uname=? ");
    
        st.setString(1, username);

        ResultSet rs = st.executeQuery();
        if (rs.next()) {

            checkuname = true;
        }
      } catch (Exception e) {
         e.printStackTrace();
      }
    
      return checkuname;

  
  }
}
