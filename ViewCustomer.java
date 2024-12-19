package travel_management_system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class ViewCustomer extends JFrame implements ActionListener{
	JButton back;
	
	ViewCustomer(String username){
		
		setBounds(300,150,800,514);
		getContentPane().setBackground(Color.white);
		setLayout(null);
		

		JLabel lblusername = new JLabel("Username:");
		lblusername.setBounds(10, 20, 90, 20);
		lblusername.setFont(new Font("SAN SAFIF", Font.PLAIN, 14));
		add(lblusername);
		
		JLabel labelusername = new JLabel();
		labelusername.setBounds(120, 20, 90, 20);
		labelusername.setFont(new Font("SAN SAFIF", Font.BOLD, 15));
		add(labelusername);
		
		JLabel lblid = new JLabel("Id:");
		lblid.setBounds(10, 80, 90, 20);
		lblid.setFont(new Font("SAN SAFIF", Font.PLAIN, 14));
		add(lblid);
		
		JLabel labelid = new JLabel();
		labelid.setBounds(120, 80, 250, 20);
		labelid.setFont(new Font("SAN SAFIF", Font.BOLD, 15));
		add(labelid);
		
		JLabel lblnumber = new JLabel("Number:");
		lblnumber.setBounds(10, 140, 150, 20);
		lblnumber.setFont(new Font("SAN SAFIF", Font.PLAIN, 14));
		add(lblnumber);
		
		JLabel labelnumber = new JLabel();
		labelnumber.setBounds(120, 140, 250, 20);
		labelnumber.setFont(new Font("SAN SAFIF", Font.BOLD, 14));
		add(labelnumber);
		
		JLabel lblname = new JLabel("Name:");
		lblname.setBounds(10, 200, 90, 20);
		lblname.setFont(new Font("SAN SAFIF", Font.PLAIN, 14));
		add(lblname);
		
		JLabel labelname = new JLabel();
		labelname.setBounds(120, 200, 180, 20);
		labelname.setFont(new Font("SAN SAFIF", Font.BOLD, 14));
		add(labelname);
		
		JLabel lblgrnder = new JLabel("Gender:");
		lblgrnder.setBounds(10, 260, 90, 20);
		lblgrnder.setFont(new Font("SAN SAFIF", Font.PLAIN, 14));
		add(lblgrnder);
		
		JLabel labelgender = new JLabel();
		labelgender.setBounds(120, 260, 90, 20);
		labelgender.setFont(new Font("SAN SAFIF", Font.BOLD, 14));
		add(labelgender);
		
		JLabel lblcountry = new JLabel("Country:");
		lblcountry.setBounds(450, 20, 120, 20);
		lblcountry.setFont(new Font("SAN SAFIF", Font.PLAIN, 14));
		add(lblcountry);
		
		JLabel labelcountry = new JLabel();
		labelcountry.setBounds(520, 20, 90, 20);
		labelcountry.setFont(new Font("SAN SAFIF", Font.BOLD, 14));
		add(labelcountry);
		
		JLabel lbladress = new JLabel("Adress:");
		lbladress.setBounds(450, 80, 90, 20);
		lbladress.setFont(new Font("SAN SAFIF", Font.PLAIN, 14));
		add(lbladress);
		
		JLabel labeladress = new JLabel();
		labeladress.setBounds(520, 80, 90, 20);
		labeladress.setFont(new Font("SAN SAFIF", Font.BOLD, 14));
		add(labeladress);
		
		JLabel lblphone = new JLabel("Phone:");
		lblphone.setBounds(450, 140, 90, 20);
		lblphone.setFont(new Font("SAN SAFIF", Font.PLAIN, 14));
		add(lblphone);
		
		JLabel labelphone = new JLabel();
		labelphone.setBounds(520, 140, 90, 20);
		labelphone.setFont(new Font("SAN SAFIF", Font.BOLD, 14));
		add(labelphone);
		
		JLabel lblemail = new JLabel("Email:");
		lblemail.setBounds(450, 200, 90, 20);
		lblemail.setFont(new Font("SAN SAFIF", Font.PLAIN, 14));
		add(lblemail);
		
		JLabel labelemail = new JLabel();
		labelemail.setBounds(520, 200, 200, 20);
		labelemail.setFont(new Font("SAN SAFIF", Font.BOLD, 14));
		add(labelemail);
		
		back = new JButton("Back");
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.setFont(new Font("Tahoma", Font.BOLD, 15));
		back.setBounds(450, 260, 100, 30);
		back.addActionListener(this);
		add(back);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
        Image i2 = i1.getImage().getScaledInstance(730, 200, Image.SCALE_DEFAULT);
    	ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(20, 250, 700, 300);
		getContentPane().setBackground(Color.white);
		add(image);
		
		try {
			Conn c = new Conn();
			String query = "select * from customer where username = '"+username+"'"; 
			ResultSet rs = c.s.executeQuery(query);
			while(rs.next()) {
				labelusername.setText(rs.getString("username"));
				labelid.setText(rs.getString("id"));
				labelnumber.setText(rs.getString("number"));
				labelname.setText(rs.getString("name"));
				labelgender.setText(rs.getString("gender"));
				labelcountry.setText(rs.getString("country"));
				labeladress.setText(rs.getString("adress"));
				labelphone.setText(rs.getString("phone"));
				labelemail.setText(rs.getString("email"));
			}
			
		}catch(Exception e){
			
		}
		
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae) {
		setVisible(false);
	}

	public static void main(String[] args) {
		new ViewCustomer("nafisgeek");
	
	}

}
