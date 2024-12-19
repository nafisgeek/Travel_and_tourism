package travel_management_system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;


public class Signup extends JFrame implements ActionListener {
	
	JButton create, back;
	JTextField tfname, tfusername, tfanswer;
	Choice security;
	JPasswordField tfpassword;
	
	Signup(){
		
		setBounds(320, 200, 750, 350);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JPanel p1 = new JPanel();
		p1.setBackground(Color.pink);
		p1.setBounds(0, 0, 400, 400);
		p1.setLayout(null);
		add(p1);
		
		JLabel lblusername = new JLabel("Username");
		lblusername.setBounds(10, 30, 90, 15);
		lblusername.setFont(new Font("SAN SAFIF", Font.PLAIN, 18));
		p1.add(lblusername);
		
	    tfusername = new JTextField();
		tfusername.setBounds(110, 30, 150, 20);
		tfusername.setBorder(BorderFactory.createEmptyBorder());
		tfusername.setBackground(Color.white);
		p1.add(tfusername);
		
		JLabel lblname = new JLabel("Name");
		lblname.setBounds(11, 60, 90, 15);
		lblname.setFont(new Font("SAN SAFIF", Font.PLAIN, 18));
		p1.add(lblname);
		
		tfname = new JTextField();
		tfname.setBounds(110, 60, 150, 15);
		tfname.setBorder(BorderFactory.createEmptyBorder());
		tfname.setBackground(Color.white);
		p1.add(tfname);
		
		JLabel lblpassword = new JLabel("Password");
		lblpassword.setBounds(11, 90, 90, 15);
		lblpassword.setFont(new Font("SAN SAFIF", Font.PLAIN, 18));
		p1.add(lblpassword);
		
        tfpassword = new JPasswordField();
		tfpassword.setBounds(110, 90, 150, 15);
		tfpassword.setBorder(BorderFactory.createEmptyBorder());
		tfpassword.setBackground(Color.white);
		p1.add(tfpassword);
		
		JLabel lblsecurity = new JLabel("Security Question");
		lblsecurity.setBounds(11, 120, 90, 15);
		lblsecurity.setFont(new Font("SAN SAFIF", Font.PLAIN, 18));
		p1.add(lblsecurity);
		
		security = new Choice();
		security.add("Fav Friend");
		security.add("Fav Food");
		security.add("Fav Game");
		security.add("Fav Color");
		security.setBounds(110, 118, 150, 15);
		p1.add(security);
		
		JLabel lblanswer = new JLabel("Answer");
		lblanswer.setBounds(12, 148, 90, 15);
		lblanswer.setFont(new Font("SAN SAFIF", Font.PLAIN, 18));
		p1.add(lblanswer);
		
		tfanswer = new JTextField();
		tfanswer.setBounds(110, 150, 150, 15);
		tfanswer.setBorder(BorderFactory.createEmptyBorder());
		tfanswer.setBackground(Color.white);
		p1.add(tfanswer);
		
		create = new JButton("Create");
		create.setBackground(Color.PINK);
		create.setForeground(Color.black);
		create.setFont(new Font("Tahoma", Font.BOLD, 15));
		create.setBounds(20, 200, 100, 20);
		create.addActionListener(this);
		p1.add(create);
		

		back = new JButton("Back");
		back.setBackground(Color.PINK);
		back.setForeground(Color.black);
		back.setFont(new Font("Tahoma", Font.BOLD, 15));
		back.setBounds(150, 200, 100, 20);
		back.addActionListener(this);
		p1.add(back);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/signup.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
    	ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(300, 0, 500, 300);
		getContentPane().setBackground(Color.white);
		add(image);
		
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource()==create)
		{
			String username = tfusername.getText();
			String name = tfname.getText();
			String password = tfpassword.getText();
			String question = security.getSelectedItem();
			String answer = tfanswer.getText();
			
			String query = "insert into account values ('"+username+"','"+name+"','"+password+"','"+question+"','"+answer+"')";
			try
			{
				
				Conn c = new Conn();
				
				
				c.s.executeUpdate(query);
				
				JOptionPane.showMessageDialog(null, "Account created successfully.");
				setVisible(false);
				new Login().setVisible(true);
			}
			catch (Exception e)
			{
				System.out.println(e);
			}
		}
		else if(ae.getSource()==back)
		{
			setVisible(false);
			new Login().setVisible(true);
		}
	}
	
	

	public static void main(String[] args) {
		new Signup();
	}
}