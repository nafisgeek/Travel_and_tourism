package travel_management_system;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

import javax.swing.*;


public class AddCustomer extends JFrame implements ActionListener {
	
	JLabel labelusername, labelname;
	JComboBox comboid;
	JTextField tfnumber, tfcountry, tfadress, tfemail, tfphone;
	JRadioButton rmale, rfemale;
	JButton  add, back;
	
	public  AddCustomer(String username){
		setBounds(300,200,700,400);
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		
		JLabel lblusername = new JLabel("Username:");
		lblusername.setBounds(10, 20, 90, 20);
		lblusername.setFont(new Font("SAN SAFIF", Font.PLAIN, 18));
		add(lblusername);
		
		labelusername = new JLabel();
		labelusername.setBounds(180, 20, 90, 20);
		labelusername.setFont(new Font("SAN SAFIF", Font.PLAIN, 18));
		add(labelusername);
		
		JLabel lblid = new JLabel("ID:");
		lblid.setBounds(10, 50, 90, 20);
		lblid.setFont(new Font("SAN SAFIF", Font.PLAIN, 18));
		add(lblid);
		
		comboid = new JComboBox (new String[] {"Passport",  "Aadhar Card", "Pan Card",  "Ration Card"});
		comboid.setBounds(180, 50, 120, 20);
		comboid.setBackground(Color.WHITE);
		add(comboid);
		
		JLabel lblnumber = new JLabel("Number:");
		lblnumber.setBounds(10, 80, 90, 20);
		lblnumber.setFont(new Font("SAN SAFIF", Font.PLAIN, 18));
		add(lblnumber);
		
		tfnumber = new JTextField();
		tfnumber.setBounds(180, 80, 120, 20);
		add(tfnumber);
		
		JLabel lblname = new JLabel("Name:");
		lblname.setBounds(10, 110, 90, 20);
		lblname.setFont(new Font("SAN SAFIF", Font.PLAIN, 18));
		add(lblname);
		
		labelname = new JLabel();
		labelname.setBounds(180, 100, 200, 35);
		labelname.setFont(new Font("SAN SAFIF", Font.BOLD, 12));
		add(labelname);
		
		JLabel lblgender = new JLabel("Gender:");
		lblgender.setBounds(10, 140, 90, 20);
		lblgender.setFont(new Font("SAN SAFIF", Font.PLAIN, 18));
		add(lblgender);
		
		rmale = new JRadioButton("Male");
		rmale.setBounds(180, 140, 55, 20);
		rmale.setBackground(Color.WHITE);
		add(rmale);
		
		rfemale = new JRadioButton("Female");
		rfemale.setBounds(235, 140, 70, 20);
		rfemale.setBackground(Color.WHITE);
		add(rfemale);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rmale);
		bg.add(rfemale);
		
		JLabel lblcountry = new JLabel("Country:");
		lblcountry.setBounds(10, 170, 90, 20);
		lblcountry.setFont(new Font("SAN SAFIF", Font.PLAIN, 18));
		add(lblcountry);
		
		tfcountry = new JTextField();
		tfcountry.setBounds(180, 170, 120, 20);
		add(tfcountry);
		
		JLabel lbladress = new JLabel("Adress:");
		lbladress.setBounds(10, 200, 90, 20);
		lbladress.setFont(new Font("SAN SAFIF", Font.PLAIN, 18));
		add(lbladress);
		
		tfadress = new JTextField();
		tfadress.setBounds(180, 200, 120, 20);
		add(tfadress);
		
		JLabel lblemail = new JLabel("Email:");
		lblemail.setBounds(10, 230, 90, 20);
		lblemail.setFont(new Font("SAN SAFIF", Font.PLAIN, 18));
		add(lblemail);
		
		tfemail = new JTextField();
		tfemail.setBounds(180, 230, 120, 20);
		add(tfemail);
		
		JLabel lblphone = new JLabel("Phone:");
		lblphone.setBounds(10, 260, 90, 20);
		lblphone.setFont(new Font("SAN SAFIF", Font.PLAIN, 18));
		add(lblphone);
		
		tfphone = new JTextField();
		tfphone.setBounds(180, 260, 120, 20);
		add(tfphone);
		
		add = new JButton("Add");
		add.setBackground(Color.BLACK);
		add.setForeground(Color.WHITE);
		add.setFont(new Font("Tahoma", Font.BOLD, 15));
		add.setBounds(40, 300, 80, 20);
		add.addActionListener(this);
		add(add);

		back = new JButton("Back");
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.setFont(new Font("Tahoma", Font.BOLD, 15));
		back.setBounds(160, 300, 80, 20);
		back.addActionListener(this);
		add(back);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/newcustomer.jpg"));
		Image i2 = i1.getImage().getScaledInstance(400, 400, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(235, 0, 530, 400);
		add(image);
		
		try {
			Conn c = new Conn();
		ResultSet rs =	c.s.executeQuery("select * from account where username = '"+username+"' ");
		while(rs.next()) {
			labelusername.setText(rs.getString("username"));
			labelname.setText(rs.getString("name"));
		}
		}
		catch(Exception e)
		{ e.printStackTrace();
			
		}
		
		
		
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == add) {
			String username = labelusername.getText();
			String id = (String) comboid.getSelectedItem();
			String number = tfnumber.getText();
			String name = labelname.getText();
			String gender = null;
			
			if(rmale.isSelected())
			{
				gender = "Male";
			}
			else
			   {
				gender = "Female";				
				
			   }
			String country = tfcountry.getText();
			String adress = tfadress.getText();
			String phone = tfphone.getText();
			String email = tfemail.getText();
			
			try {
				Conn c = new Conn();
				String query = "insert into customer values('"+username+"','"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+adress+"','"+phone+"','"+email+"')";
				c.s.executeUpdate(query);
				
				JOptionPane.showMessageDialog(null, "Custmor Details Added Successfully");
				setVisible(false);
			}
			catch (Exception e){
				
			}

			}
		    else
			{
				
				
			setVisible(false);
		   }
	}
	
	public static void main(String[] args) {
		new AddCustomer("nafisgeek");
	}

}
