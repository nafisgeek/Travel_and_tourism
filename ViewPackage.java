package travel_management_system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class ViewPackage extends JFrame implements ActionListener{
	JButton back;
	
	ViewPackage(String username){
		
		setBounds(300,150,800,514);
		getContentPane().setBackground(Color.white);
		setLayout(null);
		
		JLabel text = new JLabel ("VIEW PACKAGE DETAILS");
		text.setFont(new Font("Tahoma", Font.BOLD, 20));
		text.setBounds(5, 5, 280, 20);
		add(text);
		

		JLabel lblusername = new JLabel("Username:");
		lblusername.setBounds(10, 50, 90, 20);
		lblusername.setFont(new Font("SAN SAFIF", Font.PLAIN, 16));
		add(lblusername);
		
		JLabel labelusername = new JLabel();
		labelusername.setBounds(170, 50, 90, 20);
		labelusername.setFont(new Font("SAN SAFIF", Font.BOLD, 16));
		add(labelusername);
		
		JLabel lblpackage = new JLabel("Package:");
		lblpackage.setBounds(10, 100, 90, 20);
		lblpackage.setFont(new Font("SAN SAFIF", Font.PLAIN, 16));
		add(lblpackage);
		
		JLabel labelpackage = new JLabel();
		labelpackage.setBounds(170, 100, 250, 20);
		labelpackage.setFont(new Font("SAN SAFIF", Font.BOLD, 16));
		add(labelpackage);
		
		JLabel lblperson = new JLabel("Total Person:");
		lblperson.setBounds(10, 150, 150, 20);
		lblperson.setFont(new Font("SAN SAFIF", Font.PLAIN, 16));
		add(lblperson);
		
		JLabel labelperson = new JLabel();
		labelperson.setBounds(170, 150, 250, 20);
		labelperson.setFont(new Font("SAN SAFIF", Font.BOLD, 16));
		add(labelperson);
		
		JLabel lblid = new JLabel("Id:");
		lblid.setBounds(10, 200, 90, 20);
		lblid.setFont(new Font("SAN SAFIF", Font.PLAIN, 16));
		add(lblid);
		
		JLabel labelid = new JLabel();
		labelid.setBounds(170, 200, 150, 20);
		labelid.setFont(new Font("SAN SAFIF", Font.BOLD, 16));
		add(labelid);
		
		JLabel lblnumber = new JLabel("Number:");
		lblnumber.setBounds(10, 250, 90, 20);
		lblnumber.setFont(new Font("SAN SAFIF", Font.PLAIN, 16));
		add(lblnumber);
		
		JLabel labelnumber = new JLabel();
		labelnumber.setBounds(170, 250, 150, 20);
		labelnumber.setFont(new Font("SAN SAFIF", Font.BOLD, 16));
		add(labelnumber);
		
		JLabel lblphone = new JLabel("Phone:");
		lblphone.setBounds(10, 300, 120, 20);
		lblphone.setFont(new Font("SAN SAFIF", Font.PLAIN, 16));
		add(lblphone);
		
		JLabel labelphone = new JLabel();
		labelphone.setBounds(170, 300, 90, 20);
		labelphone.setFont(new Font("SAN SAFIF", Font.BOLD, 16));
		add(labelphone);
		
		JLabel lblprice = new JLabel("Price:");
		lblprice.setBounds(10, 350, 90, 20);
		lblprice.setFont(new Font("SAN SAFIF", Font.PLAIN, 16));
		add(lblprice);
		
		JLabel labelprice = new JLabel();
		labelprice.setBounds(170, 350, 90, 20);
		labelprice.setFont(new Font("SAN SAFIF", Font.BOLD, 16));
		add(labelprice);
		
		back = new JButton("Back");
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.setFont(new Font("Tahoma", Font.BOLD, 15));
		back.setBounds(80, 400, 100, 30);
		back.addActionListener(this);
		add(back);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookedDetails.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 450, Image.SCALE_DEFAULT);
    	ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(320, 10, 450, 450);
		getContentPane().setBackground(Color.white);
		add(image);
		
		try {
			Conn c = new Conn();
			String query = "select * from bookpackage where username = '"+username+"'"; 
			ResultSet rs = c.s.executeQuery(query);
			while(rs.next()) {
				labelusername.setText(rs.getString("username"));
				labelpackage.setText(rs.getString("package"));
				labelperson.setText(rs.getString("person"));
				labelid.setText(rs.getString("id"));
				labelnumber.setText(rs.getString("number"));
				labelphone.setText(rs.getString("phone"));
				labelprice.setText(rs.getString("price"));
			}
			
		}catch(Exception e){
			
		}
		
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae) {
		setVisible(false);
	}

	public static void main(String[] args) {
		new ViewPackage("itsuhel");
	
	}

}
