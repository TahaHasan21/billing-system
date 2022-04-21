package com.billing.pages;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.FontUIResource;
import java.sql.*;

public class Signin {
  JFrame signInFrame;

  public Signin() {
    JFrame signInFrame = new JFrame("Signin Page");
    JLabel userNameLabel = new JLabel("Username");
    userNameLabel.setBounds(600, 150, 80, 40);
    JLabel passwordLabel = new JLabel("Password");
    passwordLabel.setBounds(600, 200, 80, 40);
    JTextField userNameText = new JTextField();
    userNameText.setBounds(700, 150, 150, 30);
    JPasswordField passwordText = new JPasswordField();
    passwordText.setBounds(700, 200, 150, 30);
    JButton submitBttn = new JButton("Submit");
    submitBttn.setBounds(700, 250, 100, 40);
    JButton cancelBttn = new JButton("Back");
    cancelBttn.setBounds(700, 300, 100, 40);
    JLabel invalid = new JLabel("");
    invalid.setBounds(675, 360, 300, 50);
    JLabel title = new JLabel("VIT Billing System");
    title.setFont(new FontUIResource("Noto Sans", FontUIResource.BOLD, 25));
    title.setBorder(new EmptyBorder(10, 10, 10, 10));
    title.setBounds(625, 25, 400, 40);
    JLabel titl = new JLabel("Signin page");
    titl.setFont(new FontUIResource("Noto Sans", FontUIResource.BOLD, 25));
    titl.setBorder(new EmptyBorder(10, 10, 10, 10));
    titl.setBounds(660, 75, 400, 40);
    signInFrame.add(titl);
    signInFrame.add(title);
    signInFrame.add(invalid);
    signInFrame.add(userNameLabel);
    signInFrame.add(userNameText);
    signInFrame.add(passwordLabel);
    signInFrame.add(passwordText);
    signInFrame.add(submitBttn);
    signInFrame.add(cancelBttn);
    signInFrame.setSize(1650, 1080);
    signInFrame.setLayout(null);
    signInFrame.setVisible(true);
    submitBttn.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent e) {
        String userName = userNameText.getText();
        String password = passwordText.getText();
        try {
          Connection connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/billing", "root", "Iamtahu321#$");

          PreparedStatement st = (PreparedStatement) connection.prepareStatement("Select uname, pwd from Account where uname=? and pwd=?");

          st.setString(1, userName);
          st.setString(2, password);
          ResultSet rs = st.executeQuery();
          if (rs.next()) {
          signInFrame.dispose();
          System.out.println("Login Successful");
          new Home();
        } else {
          if (userName.equals("") && password.equals("")) {
            invalid.setText("Please enter the username and password");
          } else {
            invalid.setText("Invalid username or password");
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

        signInFrame.setVisible(false);
        signInFrame.dispose();

      }
    });

  }
}
