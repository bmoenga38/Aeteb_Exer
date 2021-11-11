package com.aetebexams.app;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.*;

public class PersonalDetails extends JFrame implements KeyListener {

        JLabel lblID,lblFirstName,lbl_mid,lblLastName,lblGender,lblDOB,lblPIN,lblPhoto;
        JTextField txtID,txtFirstName,txt_mid,txtLastName,txtGender,txtDOB,txtPIN;
        JPanel panTop, panBot;
        GridBagLayout gbl;
        GridBagConstraints c;
        Border b;
        Connection con;
        String db_url = "jdbc:mysql://localhost:3306/exams";
        String db_username = "root";
        String db_password = "";
        Statement st;
        ResultSet rs;

        public PersonalDetails(){

            super("Personal Details");
            setSize(800, 800);


            setLocationRelativeTo(null);
            setDefaultCloseOperation(3);

            gbl = new GridBagLayout();
            c = new GridBagConstraints();
            try {
                UIManager.setLookAndFeel(new NimbusLookAndFeel());
            } catch (UnsupportedLookAndFeelException e) {
                e.printStackTrace();
            }

            //implementing top panel:
            panTop = new JPanel();
            panTop.setBorder(BorderFactory.createTitledBorder(b, "Enter Personal ID for Search", TitledBorder.CENTER, TitledBorder.TOP, new Font("Monotype Corsiva", Font.PLAIN, 25), Color.red));
            panTop.setBackground(Color.ORANGE);
            panTop.setLayout(gbl);

            lblID = new JLabel("Personal ID");
            lblID.setFont(new Font("Times New Roman", Font.BOLD, 30));
            c.anchor = GridBagConstraints.CENTER;
            c.fill = GridBagConstraints.BOTH;
            c.gridx = 0;
            c.gridy = 0;
            c.insets = new Insets(10, 10, 10, 10);
            panTop.add(lblID, c);

            txtID = new JTextField();
            txtID.setFont(new Font("Times New Roman", Font.BOLD, 30));
            c.anchor = GridBagConstraints.CENTER;
            c.fill = GridBagConstraints.BOTH;
            c.gridx = 1;
            c.gridy = 0;
            c.weightx = 5.0;
            c.insets = new Insets(10, 10, 10, 10);
            panTop.add(txtID, c);


            //implementing the Bottom Panel:
            panBot = new JPanel();
            panBot.setBackground(Color.YELLOW);
            panBot.setLayout(gbl);


            lblFirstName = new JLabel("First Name");
            lblFirstName.setFont(new Font("Times New Roman", Font.PLAIN, 30));
            c.anchor = GridBagConstraints.CENTER;
            c.fill = GridBagConstraints.BOTH;
            c.gridx = 0;
            c.gridy = 1;
            c.insets = new Insets(10, 10, 10, 10);
            panBot.add(lblFirstName, c);

            txtFirstName = new JTextField();
            txtFirstName.setFont(new Font("comics", Font.PLAIN, 30));
            c.anchor = GridBagConstraints.CENTER;
            c.fill = GridBagConstraints.BOTH;
            c.gridx = 1;
            c.gridy = 1;
            c.weightx = 5.0;
            c.insets = new Insets(10, 10, 10, 10);
            panBot.add(txtFirstName, c);

            lbl_mid = new JLabel("Middle Name");
            lbl_mid.setFont(new Font("Times New Roman", Font.PLAIN, 30));
            c.anchor = GridBagConstraints.CENTER;
            c.fill = GridBagConstraints.BOTH;
            c.gridx = 0;
            c.gridy = 2;
            c.insets = new Insets(10, 10, 10, 10);
            panBot.add(lbl_mid, c);

            txtFirstName = new JTextField();
            txtFirstName.setFont(new Font("comics", Font.PLAIN, 30));
            c.anchor = GridBagConstraints.CENTER;
            c.fill = GridBagConstraints.BOTH;
            c.gridx = 1;
            c.gridy = 2;
            c.insets = new Insets(10, 10, 10, 10);
            panBot.add(txtFirstName, c);

            lblLastName = new JLabel("Last Name");
            lblLastName.setFont(new Font("Times New Roman", Font.PLAIN, 30));
            c.anchor = GridBagConstraints.CENTER;
            c.fill = GridBagConstraints.BOTH;
            c.gridx = 0;
            c.gridy = 3;
            c.insets = new Insets(10, 10, 10, 10);
            panBot.add(lblLastName, c);

            txtLastName = new JTextField();
            txtLastName.setFont(new Font("comics", Font.PLAIN, 30));
            c.anchor = GridBagConstraints.CENTER;
            c.fill = GridBagConstraints.BOTH;
            c.gridx = 1;
            c.gridy = 3;
            c.insets = new Insets(10, 10, 10, 10);
            panBot.add(txtLastName, c);

            lblGender = new JLabel("Gender");
            lblGender.setFont(new Font("Times New Roman", Font.PLAIN, 30));
            c.anchor = GridBagConstraints.CENTER;
            c.fill = GridBagConstraints.BOTH;
            c.gridx = 0;
            c.gridy = 4;
            c.insets = new Insets(10, 10, 10, 10);
            panBot.add(lblGender, c);

            txtGender = new JTextField();
            txtGender.setFont(new Font("comics", Font.PLAIN, 30));
            c.anchor = GridBagConstraints.CENTER;
            c.fill = GridBagConstraints.BOTH;
            c.gridx = 1;
            c.gridy = 4;
            c.insets = new Insets(10, 10, 10, 10);
            panBot.add(txtGender, c);

            lblDOB = new JLabel("Date Of Birth");
            lblDOB.setFont(new Font("Times New Roman", Font.PLAIN, 30));
            c.anchor = GridBagConstraints.CENTER;
            c.fill = GridBagConstraints.BOTH;
            c.gridx = 0;
            c.gridy = 5;
            c.insets = new Insets(10, 10, 10, 10);
            panBot.add(lblDOB, c);

            txtDOB = new JTextField();
            txtDOB.setFont(new Font("comics", Font.PLAIN, 30));
            c.anchor = GridBagConstraints.CENTER;
            c.fill = GridBagConstraints.BOTH;
            c.gridx = 1;
            c.gridy = 5;
            c.insets = new Insets(10, 10, 10, 10);
            panBot.add(txtDOB, c);

            lblPIN = new JLabel("PIN");
            lblPIN.setFont(new Font("Times New Roman", Font.PLAIN, 30));
            c.anchor = GridBagConstraints.CENTER;
            c.fill = GridBagConstraints.BOTH;
            c.gridx = 0;
            c.gridy = 6;
            c.insets = new Insets(10, 10, 10, 10);
            panBot.add(lblPIN, c);

            txtDOB = new JTextField();
            txtDOB.setFont(new Font("comics", Font.PLAIN, 30));
            c.anchor = GridBagConstraints.CENTER;
            c.fill = GridBagConstraints.BOTH;
            c.gridx = 1;
            c.gridy = 6;
            c.insets = new Insets(10, 10, 10, 10);
            panBot.add(txtDOB, c);

            lblPhoto=new JLabel();
            c.anchor = GridBagConstraints.CENTER;
            c.fill = GridBagConstraints.BOTH;
            c.gridx = 0;
            c.gridy = 7;
            c.insets = new Insets(10, 10, 10, 10);
            panBot.add(lblPhoto, c);


            add(panTop, BorderLayout.NORTH);
            add(panBot, BorderLayout.CENTER);
            setVisible(true);
        }

    public PersonalDetails(Connection con) {
        new Login();
    }

    public static void main(String[] args) {
        new PersonalDetails();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        String id = txtID.getText();


            try {


                con = DriverManager.getConnection(db_url, db_username, db_password);

                st = con.createStatement();
                /*insert into Persons values("001","John","don","doe","Male","1998","123","C:/Users/user/Pictures/ADOBE/1.jpg");*/

                String q = "select * from persons where ID = '"+id+"'   ";

                rs = st.executeQuery(q);

                while(rs.next()){
                    lblPhoto.setIcon(new ImageIcon(rs.getString("photo")));

                    String fn = rs.getString(2);
                    String md = rs.getString(3);
                    String ln = rs.getString(4);
                    String g = rs.getString(5);
                    String d = rs.getString(6);
                    String pin = rs.getString(7);

                    txtFirstName.setText(fn);
                    txt_mid.setText(md);
                    txtLastName.setText(ln);
                    txtGender.setText(g);
                    txtDOB.setText(g);
                    txtPIN.setText(g);
                }

                st.close();
                con.close();

            } catch (SQLException ce) {
                ce.printStackTrace();
            }
        }
    }






