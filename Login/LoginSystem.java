import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public Class Login extends JFrame implements ActionListener {

    JLabel lblUserName, lblPassword;
    JTextField txtuser;
    JPasswordField pass;
    JButton btnLogin, btnCancel;

    //String arrays to display user_name and password(Array):
    String[][] names = {
            {"User1", "user2"},
            {"1234", "ABCD"}
    };


    public Login() {
        setTitle("Login System");
        setDefaultCloseOperation(3);
        setSize(500, 200);
        setLayout(new GridLayout(3, 2));
        setLocationRelativeTo(null);
        setVisible(true);


        lblUserName = new JLabel("Enter User Name");
        lblPassword = new JLabel("Enter password");
        txtuser = new JTextField();
        pass = new JPasswordField();
        btnLogin = new JButton("Login");
        btnCancel = new JButton("Cancel");

        add(lblUserName);
        add(lblPassword);
        add(txtuser);
        add(pass);
        add(btnLogin);
        add(btnCancel);
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = txtuser.getText();
                String passText = String.valueOf(pass.getPassword());
                for (int i = 0; i < names.length; i++) {
                   // for (int j = 0; j < names[i].length; j++) {
                        if (user.equals(names[i][0]) && passText.equals(names[i][1])) {
                            JOptionPane.showMessageDialog(null, "Welcome");
                        } else {
                            JOptionPane.showMessageDialog(null, "Wrong cridentials");
                        }
                    //}
                }
            }
        });
    }


    public static void main(String[] args) {

        new Login();
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
   @Override
   public void actionPerformed(ActionEvent e) {
       if (e.getSource()==btnLogin){
           for(int i=0; i<names.length;i++){
               for (int j = 0;j<names[i].length; j++){
                   if (txtuser.getText().toString().equals(names[i][j])){
                       JOptionPane.showMessageDialog(null,"Welcome");
                   }
                   else
                       JOptionPane.showMessageDialog(null,"Wrong cridentials");


               }

           }

       }

   }



