package travel_management_system;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Dashboard extends JFrame implements ActionListener{

	JButton addPersonDetails, viewPersonDetails, updatePersonDetails, checkpackages, bookpackages, viewpackages, viewhotels;
	JButton destinations, bookhotel, viewbookedhotel, payments, calculator, notepad, about, deletePersonDetails;
	String username;
	Dashboard(String username){
		
		this.username = username;
		
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setLayout(null);
		
		
		JPanel p1 = new JPanel();
		p1.setBackground(new Color(0,0,102));
		p1.setBounds(0, 0,1600, 65);
		p1.setLayout(null);
		add(p1);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/dashboard.png"));
        Image i2 = i1.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
    	ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(10, 10, 50, 50);
		getContentPane().setBackground(Color.white);
		p1.add(image);
		
		JLabel heading =  new JLabel("Md Nafis Ansari");
		heading.setBounds(70, 20, 150, 30);
		heading.setForeground(Color.WHITE);
		heading.setFont(new Font("Tahoma", Font.BOLD, 25));
		p1.add(heading);
		
		JPanel p2 = new JPanel();
		p2.setBackground(new Color(0,0,102));
		p2.setBounds(0, 65,250, 1000);
		p2.setLayout(null);
		add(p2);

		addPersonDetails = new JButton ("Add Personal Details");
		addPersonDetails.setBounds(0, 0, 250, 40);
		addPersonDetails.setBackground(new Color(0,0,102));
		addPersonDetails.setForeground(Color.WHITE);
		addPersonDetails.setFont(new Font("Tahoma", Font.PLAIN, 15));
		addPersonDetails.setMargin(new Insets(0,0,0,60));
		addPersonDetails.addActionListener(this);
		p2.add(addPersonDetails);
		
	    updatePersonDetails = new JButton ("Update Personal Details");
		updatePersonDetails.setBounds(0, 40, 250, 40);
		updatePersonDetails.setBackground(new Color(0,0,102));
		updatePersonDetails.setForeground(Color.WHITE);
		updatePersonDetails.setFont(new Font("Tahoma", Font.PLAIN, 15));
		updatePersonDetails.setMargin(new Insets(0,0,0,40));
		updatePersonDetails.addActionListener(this);
		p2.add(updatePersonDetails);
		
		viewPersonDetails = new JButton ("View Personal Details");
		viewPersonDetails.setBounds(0, 80, 250, 40);
		viewPersonDetails.setBackground(new Color(0,0,102));
		viewPersonDetails.setForeground(Color.WHITE);
		viewPersonDetails.setFont(new Font("Tahoma", Font.PLAIN, 15));
		viewPersonDetails.setMargin(new Insets(0,0,0,55));
		viewPersonDetails.addActionListener(this);
		p2.add(viewPersonDetails);
		
		deletePersonDetails = new JButton ("Delete Personal Details");
		deletePersonDetails.setBounds(0, 120, 250, 40);
		deletePersonDetails.setBackground(new Color(0,0,102));
		deletePersonDetails.setForeground(Color.WHITE);
		deletePersonDetails.setFont(new Font("Tahoma", Font.PLAIN, 15));
		deletePersonDetails.setMargin(new Insets(0,0,0,40));
		deletePersonDetails.addActionListener(this);
		p2.add(deletePersonDetails);
		
		checkpackages = new JButton ("Check Packages");
		checkpackages.setBounds(0, 160, 250, 40);
		checkpackages.setBackground(new Color(0,0,102));
		checkpackages.setForeground(Color.WHITE);
		checkpackages.setFont(new Font("Tahoma", Font.PLAIN, 15));
		checkpackages.setMargin(new Insets(0,0,0,85));
		checkpackages.addActionListener(this);
		p2.add(checkpackages);
		
		bookpackages = new JButton ("Book Packages");
		bookpackages.setBounds(0, 200, 250, 40);
		bookpackages.setBackground(new Color(0,0,102));
		bookpackages.setForeground(Color.WHITE);
		bookpackages.setFont(new Font("Tahoma", Font.PLAIN, 15));
		bookpackages.setMargin(new Insets(0,0,0,90));
		bookpackages.addActionListener(this);
		p2.add(bookpackages);
		
		viewpackages = new JButton ("View Packages");
		viewpackages.setBounds(0, 240, 250, 40);
		viewpackages.setBackground(new Color(0,0,102));
		viewpackages.setForeground(Color.WHITE);
		viewpackages.setFont(new Font("Tahoma", Font.PLAIN, 15));
		viewpackages.setMargin(new Insets(0,0,0,93));
		viewpackages.addActionListener(this);
		p2.add(viewpackages);
		
		viewhotels = new JButton ("View Hotels");
		viewhotels.setBounds(0, 280, 250, 40);
		viewhotels.setBackground(new Color(0,0,102));
		viewhotels.setForeground(Color.WHITE);
		viewhotels.setFont(new Font("Tahoma", Font.PLAIN, 15));
		viewhotels.setMargin(new Insets(0,0,0,109));
		viewhotels.addActionListener(this);
		p2.add(viewhotels);
		
		bookhotel = new JButton ("Book Hotel");
		bookhotel.setBounds(0, 320, 250, 40);
		bookhotel.setBackground(new Color(0,0,102));
		bookhotel.setForeground(Color.WHITE);
		bookhotel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		bookhotel.setMargin(new Insets(0,0,0,109));
		bookhotel.addActionListener(this);
		p2.add(bookhotel);
		
		viewbookedhotel = new JButton ("View Booked Hotel");
		viewbookedhotel.setBounds(0, 360, 250, 40);
		viewbookedhotel.setBackground(new Color(0,0,102));
		viewbookedhotel.setForeground(Color.WHITE);
		viewbookedhotel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		viewbookedhotel.setMargin(new Insets(0,0,0,60));
		viewbookedhotel.addActionListener(this);
		p2.add(viewbookedhotel);
		
		destinations = new JButton ("Destinations");
		destinations.setBounds(0, 400, 250, 40);
		destinations.setBackground(new Color(0,0,102));
		destinations.setForeground(Color.WHITE);
		destinations.setFont(new Font("Tahoma", Font.PLAIN, 15));
		destinations.setMargin(new Insets(0,0,0,100));
		destinations.addActionListener(this);
		p2.add(destinations);
		
		payments = new JButton ("Payments");
		payments.setBounds(0, 440, 250, 40);
		payments.setBackground(new Color(0,0,102));
		payments.setForeground(Color.WHITE);
		payments.setFont(new Font("Tahoma", Font.PLAIN, 15));
		payments.setMargin(new Insets(0,0,0,115));
		payments.addActionListener(this);
		p2.add(payments);
		
		calculator = new JButton ("Calculator");
		calculator.setBounds(0, 480, 250, 40);
		calculator.setBackground(new Color(0,0,102));
		calculator.setForeground(Color.WHITE);
		calculator.setFont(new Font("Tahoma", Font.PLAIN, 15));
		calculator.setMargin(new Insets(0,0,0,115));
		calculator.addActionListener(this);
		p2.add(calculator);
		
		notepad = new JButton ("Notepad");
		notepad.setBounds(0, 520, 250, 40);
		notepad.setBackground(new Color(0,0,102));
		notepad.setForeground(Color.WHITE);
		notepad.setFont(new Font("Tahoma", Font.PLAIN, 15));
		notepad.setMargin(new Insets(0,0,0,120));
		notepad.addActionListener(this);
		p2.add(notepad);
		
		about = new JButton ("About");
		about.setBounds(0, 560, 250, 40);
		about.setBackground(new Color(0,0,102));
		about.setForeground(Color.WHITE);
		about.setFont(new Font("Tahoma", Font.PLAIN, 15));
		about.setMargin(new Insets(0,0,0,134));
		about.addActionListener(this);
		p2.add(about);
		
		ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i5 = i4.getImage().getScaledInstance(1550, 900, Image.SCALE_DEFAULT);
    	ImageIcon i6 = new ImageIcon(i5);
		JLabel image1 = new JLabel(i6);
		image1.setBounds(0, 0, 1550, 900);
		getContentPane().setBackground(Color.white);
		add(image1);
		
		JLabel text  = new JLabel("Travel and Tourism Management System");
		text.setBounds(350, 50, 1000, 100);
		text.setForeground(Color.WHITE);
		text.setFont(new Font("Raleway", Font.PLAIN,50));
		image1.add(text);
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == addPersonDetails) {
			new AddCustomer(username);
		}else if(ae.getSource() == viewPersonDetails) {
			new ViewCustomer(username);
		}else if(ae.getSource() == updatePersonDetails) {
			new UpdateCustomer(username);
		}else if(ae.getSource() == checkpackages) {
			new CheckPackage();
		}else if(ae.getSource() == bookpackages) {
			new BookPackage(username);
		}else if(ae.getSource() == viewpackages) {
			new ViewPackage(username);
		}else if(ae.getSource() == viewhotels) {
			new CheckHotels();
		}else if(ae.getSource() == destinations) {
			new Destinations();
		}else if(ae.getSource() == bookhotel) {
			new BookHotel(username);
		}else if(ae.getSource() == deletePersonDetails) {
			new DeleteDetails(username);
		}else if(ae.getSource() == payments) {
			new Payment();
			
		}else if(ae.getSource() == viewPersonDetails) {
			new ViewCustomer(username);
		}else if(ae.getSource() == calculator) {
			try {
				Runtime.getRuntime().exec("calc.exe");
			}catch(Exception e){
				e.printStackTrace();
			}	
		} else if (ae.getSource() == notepad) {
			try {
				Runtime.getRuntime().exec("notepad.exe");
			}catch(Exception e){
				e.printStackTrace();
			}	
		} else if (ae.getSource() == about) {
			new About().setVisible(true);
		}
	}
	
	public static void main(String[] args) {
		new Dashboard("");
	}

}
