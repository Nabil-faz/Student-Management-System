import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JFrame implements ActionListener {

    private JPanel contentPane;
    JButton loginBtn;
    JLabel userLabel, passLable;
    JTextField textField1, textField2;

    /**Class constructor**/
    LoginForm(){

        /**JFrame**/
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);


        /**username JLable**/
        userLabel = new JLabel("Username");
        userLabel.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        userLabel.setBounds(190, 51, 96, 16);
        contentPane.add(userLabel);

        /**username JTextField**/
        textField1 = new JTextField();
        textField1.setBounds(156, 79, 130, 26);
        contentPane.add(textField1);
        textField1.setColumns(10);


        /**password JLable**/
        passLable = new JLabel("Password");
        passLable.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        passLable.setBounds(190, 117, 96, 16);
        contentPane.add(passLable);

        /**password JTextField**/
        textField2 = new JPasswordField();
        textField2.setBounds(156, 145, 130, 26);
        contentPane.add(textField2);

        /**Login JButton**/
        loginBtn = new JButton("Login");
        loginBtn.addActionListener(this);
        loginBtn.setBackground(Color.GRAY);
        loginBtn.setBounds(181, 183, 85, 26);
        contentPane.add(loginBtn);


    }


    /**Login button functionality**/
    @Override
    public void actionPerformed(ActionEvent e) {

        String userValue = textField1.getText();
        String passValue = textField2.getText();


            if (userValue.equals("admin") && passValue.equals("admin")) {



                MainPage mp = new MainPage();
                mp.setVisible(true);
                dispose();



            } else {
            JOptionPane.showMessageDialog(LoginForm.this,"User or Password Invalid","Try agin", JOptionPane.ERROR_MESSAGE);

        }

    }
}
