package travel_management_system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;

public class ForgetPassword extends JFrame implements ActionListener{
	
	JTextField tfusername, tfname, tfquestion, tfanswer, tfpassword;
	JButton search, retrieve, back;
	
	ForgetPassword(){
		
		setBounds(320, 200, 750, 350);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JPanel p1 = new JPanel();
		p1.setBackground(Color.pink);
		p1.setBounds(0, 0,400, 400);
		p1.setLayout(null);
		add(p1);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/forgotpassword.jpg.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
    	ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(420, 0, 300, 300);
		getContentPane().setBackground(Color.white);
		add(image);
		
		
		JLabel lblusername = new JLabel("Username:");
		lblusername.setBounds(15, 30, 90, 15);
		lblusername.setFont(new Font("SAN SAFIF", Font.PLAIN, 16));
		p1.add(lblusername);
		
		tfusername = new JTextField();
		tfusername.setBounds(150, 30, 150, 20);
		tfusername.setBorder(BorderFactory.createEmptyBorder());
		tfusername.setBackground(Color.white);
		p1.add(tfusername);

		
		search = new JButton("Search");
		search.setBackground(Color.gray);
		search.setForeground(Color.black);
		search.setFont(new Font("Tahoma", Font.BOLD, 15));
		search.setBounds(300, 30, 100, 20);
		search.addActionListener(this);
		p1.add(search);

		
		JLabel lblname = new JLabel("Name:");
		lblname.setBounds(15, 70, 90, 15);
		lblname.setFont(new Font("SAN SAFIF", Font.PLAIN, 16));
		p1.add(lblname);
		
		tfname = new JTextField();
		tfname.setBounds(150, 70, 150, 20);
		tfname.setBorder(BorderFactory.createEmptyBorder());
		tfname.setBackground(Color.white);
		p1.add(tfname);

		
		JLabel lblquestion = new JLabel("Security Question");
		lblquestion.setBounds(15, 110, 120, 15);
		lblquestion.setFont(new Font("SAN SAFIF", Font.PLAIN, 16));
		p1.add(lblquestion);
		
		tfquestion = new JTextField();
		tfquestion.setBounds(150, 110, 150, 20);
		tfquestion.setBorder(BorderFactory.createEmptyBorder());
		tfquestion.setBackground(Color.white);
		p1.add(tfquestion);

		
		JLabel lblanswer = new JLabel("Answer: ");
		lblanswer.setBounds(15, 150, 120, 15);
		lblanswer.setFont(new Font("SAN SAFIF", Font.PLAIN, 16));
		p1.add(lblanswer);
		
		tfanswer = new JTextField();
		tfanswer.setBounds(150, 150, 150, 20);
		tfanswer.setBorder(BorderFactory.createEmptyBorder());
		tfanswer.setBackground(Color.white);
		p1.add(tfanswer);

		
		retrieve = new JButton("Retrieve");
		retrieve.setBackground(Color.gray);
		retrieve.setForeground(Color.black);
		retrieve.setFont(new Font("Tahoma", Font.BOLD, 14));
		retrieve.setBounds(300, 150, 100, 20);
		retrieve.addActionListener(this);
		p1.add(retrieve);

		
		JLabel lblpassword = new JLabel("Password: ");
		lblpassword.setBounds(15, 190, 120, 15);
		lblpassword.setFont(new Font("SAN SAFIF", Font.PLAIN, 16));
		p1.add(lblpassword);
		
		tfpassword = new JTextField();
		tfpassword.setBounds(150, 190, 150, 20);
		tfpassword.setBorder(BorderFactory.createEmptyBorder());
		tfpassword.setBackground(Color.white);
		p1.add(tfpassword);

		
		back = new JButton("Back");
		back.setBackground(Color.gray);
		back.setForeground(Color.black);
		back.setFont(new Font("Tahoma", Font.BOLD, 15));
		back.setBounds(80, 250, 100, 30);
		back.addActionListener(this);
		p1.add(back);

		setVisible(true);
		
		}
	
	

	
	public static void main(String[] args) {
		
		new ForgetPassword();
		
	}


	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource()== search) {
			try
			{	
				String query = "select * from account where username = '"+tfusername.getText()+"'";
				Conn c = new Conn();
				
			ResultSet rs =	c.s.executeQuery(query);
			while(rs.next()) {
				tfname.setText(rs.getString("name"));
				tfquestion.setText(rs.getString("security"));
			}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			
		}else if (ae.getSource()== retrieve){
			try
			{	
				String query = "select * from account where answer = '"+tfanswer.getText()+"' AND username = '"+tfusername.getText()+"'";
				Conn c = new Conn();
				
			ResultSet rs =	c.s.executeQuery(query);
			while(rs.next()) {
				tfpassword.setText(rs.getString("Password"));
			}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}else {
			
			setVisible(false);
			new Login().setVisible(true);
		}
	
		
	}



}
