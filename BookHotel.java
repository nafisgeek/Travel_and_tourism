package travel_management_system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;


public class BookHotel extends JFrame implements ActionListener {

	
	Choice chotel, cac, cfood;
	JTextField tfperson, tfdays;
	String username;
	JLabel labelusername, labelid, labelnumber,labelphone, labelprice;
	JButton checkprice, bookpackage, back;
	BookHotel(String username){
		this.username = username;
		setBounds(250, 50, 1000, 680);
		getContentPane().setBackground(Color.white);
		setLayout(null);
		
		JLabel text = new JLabel("BOOK HOTEL");
		text.setBounds(100, 0, 300, 30);
		text.setFont(new Font("Tahoma", Font.BOLD, 25));
		add(text);
		
		JLabel lblusername = new JLabel("Username:");
		lblusername.setBounds(20, 50, 90, 20);
		lblusername.setFont(new Font("SAN SAFIF", Font.PLAIN, 14));
		add(lblusername);
		
		labelusername = new JLabel();
		labelusername.setBounds(150, 50, 90, 20);
		labelusername.setFont(new Font("SAN SAFIF", Font.BOLD, 15));
		add(labelusername);
		
		JLabel lblpackage = new JLabel("Select Hotel:");
		lblpackage.setBounds(20, 100, 120, 20);
		lblpackage.setFont(new Font("SAN SAFIF", Font.PLAIN, 16));
		add(lblpackage);
		
		chotel = new Choice();
		chotel.setBounds(150, 100, 150, 20);
		add(chotel);
		
		try {
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("Select * from hotel ");
			while(rs.next()) {
				chotel.add(rs.getString("name"));
			}
			
		} catch (Exception e){
			e.printStackTrace();
		}
		
		JLabel lblperson = new JLabel("Total Person:");
		lblperson.setBounds(20, 150, 150, 20);
		lblperson.setFont(new Font("SAN SAFIF", Font.PLAIN, 16));
		add(lblperson);
		
		tfperson = new JTextField("1");
		tfperson.setBounds(150, 150, 150, 20);
		add(tfperson);
		
		JLabel lbldays = new JLabel("No. of Days:");
		lbldays.setBounds(20, 200, 150, 20);
		lbldays.setFont(new Font("SAN SAFIF", Font.PLAIN, 16));
		add(lbldays);
		
		tfdays = new JTextField("1");
		tfdays.setBounds(150, 200, 150, 20);
		add(tfdays);
		
		JLabel lblac = new JLabel("AC/Non-Ac:");
		lblac.setBounds(20, 250, 120, 20);
		lblac.setFont(new Font("SAN SAFIF", Font.PLAIN, 15));
		add(lblac);
		
		cac = new Choice();
		cac.add("AC");
		cac.add("Non-AC");
		cac.setBounds(150, 250, 150, 20);
		add(cac);
		
		JLabel lblfood = new JLabel("Food Included:");
		lblfood.setBounds(20, 300, 120, 20);
		lblfood.setFont(new Font("SAN SAFIF", Font.PLAIN, 15));
		add(lblfood);
		
		cfood = new Choice();
		cfood.add("Yes");
		cfood.add("No");
		cfood.setBounds(150, 300, 150, 20);
		add(cfood);
		
		JLabel lblid = new JLabel("Id:");
		lblid.setBounds(20, 350, 90, 20);
		lblid.setFont(new Font("SAN SAFIF", Font.PLAIN, 16));
		add(lblid);
		
		labelid = new JLabel();
		labelid.setBounds(150, 350, 150, 20);
		labelid.setFont(new Font("SAN SAFIF", Font.BOLD, 16));
		add(labelid);
		
		JLabel lblnumber = new JLabel("Number:");
		lblnumber.setBounds(20, 400, 90, 20);
		lblnumber.setFont(new Font("SAN SAFIF", Font.PLAIN, 16));
		add(lblnumber);
		
		labelnumber = new JLabel();
		labelnumber.setBounds(150, 400, 150, 20);
		labelnumber.setFont(new Font("SAN SAFIF", Font.BOLD, 16));
		add(labelnumber);
		
		JLabel lblphone = new JLabel("Phone:");
		lblphone.setBounds(20, 450, 90, 20);
		lblphone.setFont(new Font("SAN SAFIF", Font.PLAIN, 16));
		add(lblphone);
		
		labelphone = new JLabel();
		labelphone.setBounds(150, 450, 150, 20);
		labelphone.setFont(new Font("SAN SAFIF", Font.BOLD, 16));
		add(labelphone);
		
		JLabel lbltotal = new JLabel("Total Price:");
		lbltotal.setBounds(20, 500, 90, 20);
		lbltotal.setFont(new Font("SAN SAFIF", Font.PLAIN, 16));
		add(lbltotal);
		
		labelprice = new JLabel();
		labelprice.setBounds(150, 500, 150, 20);
		labelprice.setFont(new Font("SAN SAFIF", Font.BOLD, 16));
		add(labelprice);
		
		try {
			Conn c = new Conn();
			String query = "select * from customer where username = '"+username+"'"; 
			ResultSet rs = c.s.executeQuery(query);
			while(rs.next()) {
				labelusername.setText(rs.getString("username"));
				labelid.setText(rs.getString("id"));
				labelnumber.setText(rs.getString("number"));
				labelphone.setText(rs.getString("phone"));
				//labelprice.setText(rs.getString("price"));
				
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		checkprice = new JButton("Checkprice");
		checkprice.setBackground(Color.gray);
		checkprice.setForeground(Color.black);
		checkprice.setFont(new Font("Tahoma", Font.BOLD, 15));
		checkprice.setBounds(30, 550, 130, 30);
		checkprice.addActionListener(this);
		add(checkprice);
		
		bookpackage = new JButton("Bookpackage");
		bookpackage.setBackground(Color.gray);
		bookpackage.setForeground(Color.black);
		bookpackage.setFont(new Font("Tahoma", Font.BOLD, 15));
		bookpackage.setBounds(180, 550, 145, 30);
		bookpackage.addActionListener(this);
		add(bookpackage);
		
		back = new JButton("Back");
		back.setBackground(Color.gray);
		back.setForeground(Color.black);
		back.setFont(new Font("Tahoma", Font.BOLD, 15));
		back.setBounds(120, 600, 100, 30);
		back.addActionListener(this);
		add(back);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/book.jpg"));
		Image i2 = i1.getImage().getScaledInstance(700, 600, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(350, 20, 650, 600);
		add(image);
		
		setVisible(true);
	}
	
	
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == checkprice) {
			try {
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("Select * from hotel where name ='"+chotel.getSelectedItem()+"'");
			while(rs.next()) {
				int cost = Integer.parseInt(rs.getString("costperperson"));
				int food = Integer.parseInt(rs.getString("foodinclude"));
				int ac = Integer.parseInt(rs.getString("acroom"));
				
				int person = Integer.parseInt(tfperson.getText());
				int days = Integer.parseInt(tfdays.getText());
				
				
				String acselected = cac.getSelectedItem();
				String foodselected = cfood.getSelectedItem();
				
				if(person * days > 0) {
					int total = 0;
					total+= acselected.equals("AC") ? ac : 0;
					total+= foodselected.equals("Yes") ? food : 0;
					total += cost;
					total = total * person * days;
					labelprice.setText("Rs " + total);
					
				}else {
					JOptionPane.showMessageDialog(null, "Please enter a valid number");
				}
				
			}
			}catch(Exception e) {
				e.printStackTrace();
			}
			}else if(ae.getSource() == bookpackage) {
			try {
				Conn c = new Conn();
				c.s.executeUpdate("insert into bookhotel values ('"+labelusername.getText()+"','"+chotel.getSelectedItem()+"','"+tfperson.getText()+"', '"+tfdays.getText()+"','"+cac.getSelectedItem()+"', '"+cfood.getSelectedItem()+"','"+labelid.getText()+"', '"+labelnumber.getText()+"', '"+labelphone.getText()+"', '"+labelprice.getText()+"')");
				
				JOptionPane.showMessageDialog(null, "Hotel Booked Successfully");
				setVisible(false);
			}catch(Exception e){
				e.printStackTrace();
			}
				
			}else {
			setVisible(false);
		}
	}
	public static void main(String[] args) {
		new BookHotel("itsuhel");

	}

}
