import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.sql.*;

import javax.swing.*;

public class Login extends JFrame implements ActionListener {

    JButton login, signup, clear;
    JTextField cardJTextField;
    JPasswordField pinTextField;

    Login() {

        setTitle("AUTOMATEID TELLER MACHINE");
        setLayout(null);
        ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("icon/logo.jpg"));
        Image i2 = il.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70, 10, 100, 100);
        add(label);
        JLabel text = new JLabel("Welcome to atm");
        text.setFont(new Font("Onward", Font.BOLD, 38));
        text.setBounds(200, 40, 400, 40);
        add(text);

        JLabel cardno = new JLabel("Card NO");
        cardno.setFont(new Font("Raleway", Font.BOLD, 28));
        cardno.setBounds(120, 150, 150, 30);
        add(cardno);

        cardJTextField = new JTextField();
        cardJTextField.setBounds(300, 150, 230, 30);
        cardJTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(cardJTextField);

        JLabel pin = new JLabel("PIN");
        pin.setFont(new Font("Raleway", Font.BOLD, 28));
        pin.setBounds(120, 220, 250, 40);
        add(pin);

        pinTextField = new JPasswordField();
        pinTextField.setBounds(300, 220, 230, 30);
        pinTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(pinTextField);

        login = new JButton("SIGN IN");
        login.setBounds(300, 300, 100, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        clear = new JButton("CLEAR");
        clear.setBounds(430, 300, 100, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);

        signup = new JButton("SIGN UP");
        signup.setBounds(300, 350, 230, 30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);

        getContentPane().setBackground(Color.WHITE);

        setSize(800, 480);
        setVisible(true);
        setLocation(350, 200);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == clear) {
            cardJTextField.setText("");
            pinTextField.setText("");

        } else if (ae.getSource() == login) {
            conn conn= new conn();
            String cardnumber = cardJTextField.getText();
            String pinnumber = pinTextField.getText();
            String query ="select * from login where cardnumber='"+cardnumber+"' and pin ='"+pinnumber+"'";
            try{

                ResultSet rs=conn.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);;
                }else{
                    JOptionPane.showMessageDialog(null,"Incorrect card no or pin");
                }

            }catch(Exception e){
                System.out.println(e);
            }
            


        } else if (ae.getSource() == signup) {
            setVisible(false);
            new SignupOne().setVisible(true);

        }

    }

    public static void main(String[] args) {
        new Login();
    }

}