package travel_management_system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;


public class BookPackage extends JFrame implements ActionListener {

	
	Choice cpackage;
	JTextField tfperson;
	String username;
	JLabel labelusername, labelid, labelnumber,labelphone, labelprice;
	JButton checkprice, bookpackage, back;
	BookPackage(String username){
		this.username = username;
		setBounds(250, 100, 850, 550);
		getContentPane().setBackground(Color.white);
		setLayout(null);
		
		JLabel text = new JLabel("BOOK PACKAGE");
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
		
		JLabel lblpackage = new JLabel("Select Package:");
		lblpackage.setBounds(20, 100, 120, 20);
		lblpackage.setFont(new Font("SAN SAFIF", Font.PLAIN, 16));
		add(lblpackage);
		
		cpackage = new Choice();
		cpackage.add("Gold Package");
		cpackage.add("Silver Package");
		cpackage.add("Bronze Package");
		cpackage.setBounds(150, 100, 150, 20);
		add(cpackage);
		
		JLabel lblperson = new JLabel("Total Person:");
		lblperson.setBounds(20, 150, 150, 20);
		lblperson.setFont(new Font("SAN SAFIF", Font.PLAIN, 16));
		add(lblperson);
		
		tfperson = new JTextField("1");
		tfperson.setBounds(150, 150, 150, 20);
		add(tfperson);
		
		JLabel lblid = new JLabel("Id:");
		lblid.setBounds(20, 200, 90, 20);
		lblid.setFont(new Font("SAN SAFIF", Font.PLAIN, 16));
		add(lblid);
		
		labelid = new JLabel();
		labelid.setBounds(150, 200, 150, 20);
		labelid.setFont(new Font("SAN SAFIF", Font.BOLD, 16));
		add(labelid);
		
		JLabel lblnumber = new JLabel("Number:");
		lblnumber.setBounds(20, 250, 90, 20);
		lblnumber.setFont(new Font("SAN SAFIF", Font.PLAIN, 16));
		add(lblnumber);
		
		labelnumber = new JLabel();
		labelnumber.setBounds(150, 250, 150, 20);
		labelnumber.setFont(new Font("SAN SAFIF", Font.BOLD, 16));
		add(labelnumber);
		
		JLabel lblphone = new JLabel("Phone:");
		lblphone.setBounds(20, 300, 90, 20);
		lblphone.setFont(new Font("SAN SAFIF", Font.PLAIN, 16));
		add(lblphone);
		
		labelphone = new JLabel();
		labelphone.setBounds(150, 300, 150, 20);
		labelphone.setFont(new Font("SAN SAFIF", Font.BOLD, 16));
		add(labelphone);
		
		JLabel lbltotal = new JLabel("Total Price:");
		lbltotal.setBounds(20, 350, 90, 20);
		lbltotal.setFont(new Font("SAN SAFIF", Font.PLAIN, 16));
		add(lbltotal);
		
		labelprice = new JLabel();
		labelprice.setBounds(150, 350, 150, 20);
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
				labelprice.setText(rs.getString("price"));
				
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		checkprice = new JButton("Checkprice");
		checkprice.setBackground(Color.gray);
		checkprice.setForeground(Color.black);
		checkprice.setFont(new Font("Tahoma", Font.BOLD, 15));
		checkprice.setBounds(30, 400, 130, 30);
		checkprice.addActionListener(this);
		add(checkprice);
		
		bookpackage = new JButton("Bookpackage");
		bookpackage.setBackground(Color.gray);
		bookpackage.setForeground(Color.black);
		bookpackage.setFont(new Font("Tahoma", Font.BOLD, 15));
		bookpackage.setBounds(180, 400, 145, 30);
		bookpackage.addActionListener(this);
		add(bookpackage);
		
		back = new JButton("Back");
		back.setBackground(Color.gray);
		back.setForeground(Color.black);
		back.setFont(new Font("Tahoma", Font.BOLD, 15));
		back.setBounds(120, 450, 100, 30);
		back.addActionListener(this);
		add(back);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookpackage.jpg"));
		Image i2 = i1.getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(350, 20, 450, 450);
		add(image);
		
		setVisible(true);
	}
	
	
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == checkprice) {
			String pack = cpackage.getSelectedItem();
			int cost = 0;
			
			if(pack.equals("Gold Package")) {
					cost += 32000;
			}else if (pack.equals("Silver Package")) {
					cost += 24000;
			}else {
					cost += 12000;
			}
			
			int person = Integer.parseInt(tfperson.getText());
			cost *= person;
			labelprice.setText("Rs"+ cost);
			}else if(ae.getSource() == bookpackage) {
			try {
				Conn c = new Conn();
				c.s.executeUpdate("insert into bookpackage values ('"+labelusername.getText()+"','"+cpackage.getSelectedItem()+"','"+tfperson.getText()+"','"+labelid.getText()+"', '"+labelnumber.getText()+"', '"+labelphone.getText()+"', '"+labelprice.getText()+"')");
				
				JOptionPane.showMessageDialog(null, "Package Booked Successfully");
				setVisible(false);
			}catch(Exception e){
				e.printStackTrace();
			}
				
			}else {
			setVisible(false);
		}
	}
	public static void main(String[] args) {
		new BookPackage("itsuhel");

	}

}
