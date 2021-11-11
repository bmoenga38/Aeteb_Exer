package com.aetebexams.app;

import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements KeyListener{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    JTextField txtUser;
    JPasswordField txtPass;
    Pool p;

    public Login() {
        setUndecorated(true);
        setExtendedState(MAXIMIZED_BOTH);

        setLayout(null);


        txtUser = new JTextField();
        txtUser.setToolTipText("Enter your username");
        txtUser.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        txtUser.setBounds(400, 390, 218, 30);
        add(txtUser);

        txtPass = new JPasswordField();
        txtPass.setToolTipText("Enter your password");
        txtPass.setBounds(400, 430, 218, 30);
        txtPass.addKeyListener(this);
        add(txtPass);

        setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {
        String user = txtUser.getText();
        String password = String.valueOf(txtPass.getPassword());

        if(e.getKeyCode() == KeyEvent.VK_ENTER){

            p = new Pool(user, password, "healthelic_pharmacy");

            if(p.connectTwo()){

                JOptionPane.showMessageDialog(null, "Logged in");

                dispose();

                /*
                 * This constructor receives a connection
                 * from the Pool class
                 * We are using the object of Pool to call a connection
                 */
                new PersonalDetails(p.con);

            }else{
                JOptionPane.showMessageDialog(null, "Access Denied!");
                txtUser.setText("");
                txtPass.setText("");
            }
        }
    }//keyReleased()

}//class



