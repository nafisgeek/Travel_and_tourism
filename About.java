package travel_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class About extends JFrame implements ActionListener {

		About() {
			setBounds(330,100,900, 600);
			setLayout(null);
			getContentPane().setBackground(Color.LIGHT_GRAY);
			
			JLabel l1 = new JLabel("ABOUT");
			l1.setBounds(350, 10, 100, 40);
			l1.setForeground(Color.WHITE);
			l1.setFont(new Font("Tahoma", Font.BOLD, 25));
			add(l1);
			
		 String	s = "About Projects          \n  "
	                + "\nThe objective of the Travel and Tourism Management System"
	                + " project is to develop a system that automates the processes "
	                + "and activities of a travel and the purpose is to design a "
	                + "system using which one can perform all operations related to "
	                + "traveling.\n\n"
	                + "This application will help in accessing the information related "
	                + "to the travel to the particular destination with great ease. "
	                + "The users can track the information related to their tours with "
	                + "great ease through this application. The travel agency information "
	                + "can also be obtained through this application.\n\n"
	                + "Advantages of Project:"
	                + "\nGives accurate information"
	                + "\nSimplifies the manual work"
	                + "\nIt minimizes the documentation related work"
	                + "\nProvides up to date information"
	                + "\nFriendly Environment by providing warning messages."
	                + "\ntravelers details can be provided"
	                + "\nbooking confirmation notification"
	                ;
			
			TextArea area = new TextArea(s, 10, 40, Scrollbar.VERTICAL);
			area.setEditable(false);
			area.setBounds(150, 80, 550, 400);
			add(area);
			
			JButton back = new JButton("Back");
			back.setBounds(355, 500, 80, 30);
			back.addActionListener(this);
			add(back);
			
		setVisible(true);
		}
		

		public void actionPerformed(ActionEvent ae) {
			setVisible(false);
		
		}
		
	public static void main(String[] args) {

		new About();
	}

}
