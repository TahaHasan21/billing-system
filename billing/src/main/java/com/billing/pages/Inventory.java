package com.billing.pages;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
public class Inventory {
 private JFrame frame;
 private JPanel mainPane;
 private JPanel topPane;
 private JPanel tablePane;
 private JLabel selectAccountLabel;
 private JButton addButton;
 private JButton deleteButton;
 private JButton backButton;
 private JButton logoutButton;
 private JTable table;
 private JScrollPane scroll;
 public void createAndShowGui() {
 frame = new JFrame(getClass().getSimpleName());
 String[][] data = { { "1", "Wheat", "1000", "80", "100" }, { "2", "Rice", "700", "42", "50" },
 { "3", "Sugar", "1200", "14", "20" }, { "4", "Oil", "1100", "38", "50" },
 { "5", "Cereals", "850", "22", "30" } };
 String[] columnNames = { "S.No", "Product Name", "Quantity", "Purchase Price", "Selling Price" };
 table = new JTable(data, columnNames);
 scroll = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
 table.setPreferredScrollableViewportSize(new Dimension(420, 250));
 table.setFillsViewportHeight(true);
 selectAccountLabel = new JLabel("VIT Billing System | Inventory");
 selectAccountLabel.setFont(new Font("Verdana", Font.PLAIN, 20));
 addButton = new JButton("Add");
 addButton.setBounds(1000, 400, 200, 30);
 deleteButton = new JButton("Delete");
 deleteButton.setBounds(1000, 450, 200, 30);
 backButton = new JButton("Back");
 backButton.setBounds(1100, 20, 100, 40);
 logoutButton = new JButton("Logout");
 logoutButton.setBounds(1100, 70, 100, 40);
 backButton.addActionListener(new java.awt.event.ActionListener() {
 public void actionPerformed(java.awt.event.ActionEvent e) {
 new Home();
 frame.setVisible(false);
 frame.dispose();
 }
 });
 logoutButton.addActionListener(new java.awt.event.ActionListener() {
 public void actionPerformed(java.awt.event.ActionEvent e) {
 new Login();
 frame.setVisible(false);
 frame.dispose();
 System.out.println("Logout sucessful");
 }
 });
 topPane = new JPanel();
 topPane.setLayout(new BorderLayout());
 topPane.add(selectAccountLabel, BorderLayout.WEST);
 tablePane = new JPanel();
 tablePane.add(scroll);
 mainPane = new JPanel();
 mainPane.setLayout(new BoxLayout(mainPane, BoxLayout.PAGE_AXIS));
 frame.add(addButton);
 frame.add(deleteButton);
 frame.add(backButton);
 frame.add(logoutButton);
 frame.add(topPane, BorderLayout.NORTH);
 frame.add(tablePane, BorderLayout.CENTER);
 frame.setSize(1080, 900);
 frame.pack();
 frame.setVisible(true);
 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 }
}