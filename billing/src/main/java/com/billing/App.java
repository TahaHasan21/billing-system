package com.billing;
import javax.swing.*;
import com.formdev.flatlaf.*;
import com.billing.*;
import com.billing.pages.Login;
public class App {
 public static void main(String[] args) {
 try {
 UIManager.setLookAndFeel(new FlatDarkLaf());
 } catch (Exception ex) {
 System.err.println("Failed to initialize Laf");
 }
 Login login = new Login();
 }
}
