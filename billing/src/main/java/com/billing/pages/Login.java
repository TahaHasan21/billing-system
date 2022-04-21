package com.billing.pages;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.FontUIResource;

public class Login {
  JFrame loginFrame;
  JButton loginBttn;
  JButton signupBttn;
  JButton cancelBttn;

  public Login() {
    loginFrame = new JFrame("Login | VIT Billing System");
    loginBttn = new JButton("Login"); 
    loginBttn.setBounds(660, 150, 100, 40);
    signupBttn = new JButton("Signup"); 
    signupBttn.setBounds(660, 200, 100, 40);
    cancelBttn = new JButton("Exit");
    cancelBttn.setBounds(660, 250, 100, 40);
    loginBttn.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent e) {

        loginFrame.dispose();
        Signin signin = new Signin();

      }

    });
    signupBttn.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent e) {

        loginFrame.dispose();
        Signup signin = new Signup();

      }

    });

    cancelBttn.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent e) {
        System.exit(0);
      }
    });

    JLabel loginTitle = new JLabel("VIT Billing System");
    loginTitle.setFont(new FontUIResource("Noto Sans", FontUIResource.BOLD, 25));
    loginTitle.setBorder(new EmptyBorder(10, 10, 10, 10));
    loginTitle.setBounds(600, 25, 400, 40);
    JLabel Title = new JLabel("Welcomes You");
    Title.setFont(new FontUIResource("Noto Sans", FontUIResource.BOLD, 25));
    Title.setBorder(new EmptyBorder(10, 10, 10, 10));
    Title.setBounds(620, 85, 400, 40);
    loginFrame.add(loginTitle);
    loginFrame.add(Title);

    loginFrame.add(loginBttn);
    loginFrame.add(signupBttn);
    loginFrame.add(cancelBttn);
    loginFrame.setSize(1650, 1080);

    loginFrame.setLayout(null);
    loginFrame.setVisible(true);
  }
}