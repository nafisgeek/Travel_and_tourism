package travel_management_system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
	JButton Login, signup, password;
	JTextField tfusername, tfpassword;
	String username;
	public Login() {
		
		setSize(600,360);
		setLocation(400,200);
		setLayout(null);
		
		getContentPane().setBackground(Color.WHITE);
		
		JPanel p1 = new JPanel();
		p1.setBackground(Color.WHITE);
		p1.setBounds(0, 0,300, 400);
		p1.setLayout(null);
		add(p1);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
    	ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 300, 300);
		getContentPane().setBackground(Color.white);
		p1.add(image);
		
		JPanel p2 = new JPanel();
		p2.setBackground(Color.lightGray);
		p2.setBounds(300, 0, 300, 400);
		p2.setLayout(null);
		add(p2);
		
		JLabel lblusername = new JLabel("Username");
		lblusername.setBounds(20, 30, 100, 25);
		lblusername.setFont(new Font("SAN SAFIF", Font.PLAIN, 18));
		p2.add(lblusername);
		
		tfusername = new JTextField();
		tfusername.setBounds(20, 60, 240, 20);
		tfusername.setBorder(BorderFactory.createEmptyBorder());
		tfusername.setBackground(Color.white);
		p2.add(tfusername);
		
		
		JLabel lblpassword = new JLabel("Password");
		lblpassword.setBounds(20, 100, 100, 25);
		lblpassword.setFont(new Font("SAN SAFIF", Font.PLAIN, 18));
		p2.add(lblpassword);
		
		tfpassword = new JTextField();
		tfpassword.setBounds(20, 130, 240, 20);
		tfpassword.setBorder(BorderFactory.createEmptyBorder());
		tfpassword.setBackground(Color.white);
		p2.add(tfpassword);
		
		Login = new JButton("Login");
		Login.setBackground(Color.WHITE);
		Login.setForeground(Color.LIGHT_GRAY);
		Login.setFont(new Font("Tahoma", Font.BOLD, 15));
		Login.setBounds(20, 180, 100, 25);
		Login.addActionListener(this);
		p2.add(Login);
		
		signup = new JButton("Signup");
		signup.setBackground(Color.WHITE);
		signup.setForeground(Color.LIGHT_GRAY);
		signup.setFont(new Font("Tahoma", Font.BOLD, 15));
		signup.setBounds(140, 180, 100, 25);
		signup.addActionListener(this);
		p2.add(signup);
		
		
		password = new JButton("Forget Password");
		password.setBackground(Color.WHITE);
		password.setForeground(Color.LIGHT_GRAY);
		password.setFont(new Font("Tahoma", Font.BOLD, 15));
		password.setBounds(50, 230, 160, 25);
		password.addActionListener(this);
		p2.add(password);
		
		
		JLabel text = new JLabel("Trouble in Login....");
		text.setBounds(70, 250, 180, 25);
		text.setForeground(Color.RED);
		p2.add(text);


		
		setVisible(true);
	}
	
	public void actionPerformed (ActionEvent ae)
	{
		if (ae.getSource()==Login)
		{	
			try {
				String username = tfusername.getText();
				String password = tfpassword.getText();
				
				String query = "select * from account where username = '"+username+"' AND password = '"+password+"'";
				Conn c = new Conn();
				ResultSet rs = c.s.executeQuery(query);
				if(rs.next()) {
					setVisible(false);
					new Loading(username);
				}else {
					JOptionPane.showMessageDialog(null, "Incorrect username or password");
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}else if (ae.getSource()== signup){
			setVisible(false);
			new Signup();
		}else {
			setVisible(false);
			new ForgetPassword();
		}
	}
	
	public static void main(String[] args) {
	    new Login();
	}
	
}
