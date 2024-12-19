package travel_management_system;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;


public class UpdateCustomer extends JFrame implements ActionListener {
	
	JLabel labelusername, labelname;
	//JComboBox comboid;
	JTextField tfnumber, tfcountry, tfadress, tfemail, tfphone, tfid, tfgender;
	JRadioButton rmale, rfemale;
	JButton  update, back;
	
	public UpdateCustomer(String username){
		setBounds(300,200,700,400);
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		
		JLabel text = new JLabel("UPDATE CUSTOMER DETAILES");
		text.setBounds(150, 0, 300, 20);
		text.setFont(new Font("Tahoma ", Font.BOLD, 16));
		add(text);
		
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
		
		tfid = new JTextField();
		tfid.setBounds(180, 50, 120, 20);
		add(tfid);
		
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
		
		tfgender = new JTextField();
		tfgender.setBounds(180, 140, 120, 20);
		add(tfgender);	
		
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
		
		update = new JButton("Update");
		update.setBackground(Color.BLACK);
		update.setForeground(Color.WHITE);
		update.setFont(new Font("Tahoma", Font.BOLD, 14));
		update.setBounds(30, 300, 100, 20);
		update.addActionListener(this);
		add(update);

		back = new JButton("Back");
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.setFont(new Font("Tahoma", Font.BOLD, 15));
		back.setBounds(160, 300, 80, 20);
		back.addActionListener(this);
		add(back);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/update.png"));
		Image i2 = i1.getImage().getScaledInstance(300, 320, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(235, 0, 500, 380);
		add(image);
		
		try {
			Conn c = new Conn();
		ResultSet rs =	c.s.executeQuery("select * from customer where username = '"+username+"'");
		while(rs.next()) {
			labelusername.setText(rs.getString("username"));
			labelname.setText(rs.getString("name"));
			tfid.setText(rs.getString("id"));
			tfnumber.setText(rs.getString("number"));
			tfgender.setText(rs.getString("gender"));
			tfcountry.setText(rs.getString("country"));
			tfadress.setText(rs.getString("adress"));
			tfphone.setText(rs.getString("phone"));
			tfemail.setText(rs.getString("email"));
		}
		}
		catch(Exception e)
		{ e.printStackTrace();
			
		}
		
		
		
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == update) {
			String username = labelusername.getText();
			String id = tfid.getText();
			String number = tfnumber.getText();
			String name = labelname.getText();
			String gender = tfgender.getText();
			
			
			String country = tfcountry.getText();
			String adress = tfadress.getText();
			String phone = tfphone.getText();
			String email = tfemail.getText();
			
			try {
				Conn c = new Conn();
				String query = "update customer set username = '"+username+"', id = '"+id+"', number = '"+number+"', name = '"+name+"', gender = '"+gender+"', country = '"+country+"', adress = '"+adress+"', phone = '"+phone+"', email = '"+email+"'";
				c.s.executeUpdate(query);
				
				JOptionPane.showMessageDialog(null, "Custmor Details Updated Successfully");
				setVisible(false);
			}
			catch (Exception e){
				e.printStackTrace();
			}

			}
		    else
			{
				
				
			setVisible(false);
		   }
	}
	
	public static void main(String[] args) {
		new UpdateCustomer("nafisgeek");
	}

}
