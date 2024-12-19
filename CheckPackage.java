package travel_management_system;

import java.awt.*;
import javax.swing.*;

public class CheckPackage extends JFrame{
	
	CheckPackage(){
		setBounds(320,40,800,600);
		
		String[] package1 = {"BRONZE PACKAGE","6 Days and 7 Nights","Airport Assistance","Half Day City Tour","Daily Buffet","Welcome Drinks on Arrival","Full Day 3 Island Cruise","English Speaking Guide","BOOK NOW","Summer Special","RS 12000/-","package1.jpg"};
		String[] package2 = {"SILVER PACKAGE", "5 Days and 6 Nights","Entrance Free ticket","Meet and Greet at Airport","Welcome Drinks on Arrival","Night Safari","Cruise With Dinner","Free Language Guidence","BOOK NOW","Winter Special","RS 24000/-","package2.jpg"};
		String[] package3 = {"GOLD PACKAGE", "5 Days and 5 Nights","Return Airfare","Free Clubbing","Horse Riding & other","Welcome Drinks on Arrival","Daily Buffet","Candel Night Dinner","BOOK NOW","Monsooon Special","RS 32000/-","package3.jpg"};
		
		
		JTabbedPane tab = new JTabbedPane();
		JPanel p1 = CreatePackage(package1);
		tab.addTab("Package 1", null, p1);	
		
		JPanel p2 = CreatePackage(package2);
		tab.addTab("Package 2", null, p2);
		
		JPanel p3 = CreatePackage(package3);
		tab.addTab("Package 3", null, p3);
		
		add(tab);
		
		setVisible(true);
	}
	
	public JPanel CreatePackage(String [] pack) {
		JPanel p1 = new JPanel();
		p1.setLayout(null);
		p1.setBackground(Color.WHITE);
		
		JLabel l1 = new JLabel(pack[0]);
		l1.setBounds(20, 10, 300, 30);
		l1.setForeground(Color.YELLOW);
		l1.setFont(new Font("Tahoma ", Font.BOLD, 29));
		p1.add(l1);
		
		JLabel l2 = new JLabel(pack[1]);
		l2.setBounds(40, 60, 300, 30);
		l2.setForeground(Color.RED);
		l2.setFont(new Font("Tahoma ", Font.BOLD, 18));
		p1.add(l2);
		
		JLabel l3 = new JLabel(pack[2]);
		l3.setBounds(40, 110, 300, 30);
		l3.setForeground(Color.BLUE);
		l3.setFont(new Font("Tahoma ", Font.BOLD, 18));
		p1.add(l3);
		
		JLabel l4 = new JLabel(pack[3]);
		l4.setBounds(40, 160, 300, 30);
		l4.setForeground(Color.RED);
		l4.setFont(new Font("Tahoma ", Font.BOLD, 18));
		p1.add(l4);
		
		JLabel l5 = new JLabel(pack[4]);
		l5.setBounds(40, 210, 300, 30);
		l5.setForeground(Color.BLUE);
		l5.setFont(new Font("Tahoma ", Font.BOLD, 18));
		p1.add(l5);
		
		JLabel l6 = new JLabel(pack[5]);
		l6.setBounds(40, 260, 300, 30);
		l6.setForeground(Color.RED);
		l6.setFont(new Font("Tahoma ", Font.BOLD, 18));
		p1.add(l6);
		
		JLabel l7 = new JLabel(pack[6]);
		l7.setBounds(40, 310, 300, 30);
		l7.setForeground(Color.BLUE);
		l7.setFont(new Font("Tahoma ", Font.BOLD, 18));
		p1.add(l7);
		
		JLabel l8 = new JLabel(pack[7]);
		l8.setBounds(40, 360, 300, 30);
		l8.setForeground(Color.RED);
		l8.setFont(new Font("Tahoma ", Font.BOLD, 18));
		p1.add(l8);
		
		JLabel l9 = new JLabel(pack[8]);
		l9.setBounds(60, 420, 200, 30);
		l9.setForeground(Color.BLACK);
		l9.setFont(new Font("Tahoma ", Font.BOLD, 25));
		p1.add(l9);
		
		JLabel l10 = new JLabel(pack[9]);
		l10.setBounds(100, 480, 200, 30);
		l10.setForeground(Color.MAGENTA);
		l10.setFont(new Font("Tahoma ", Font.BOLD, 22));
		p1.add(l10);
		
		JLabel l11 = new JLabel(pack[10]);
		l11.setBounds(500, 480, 200, 30);
		l11.setForeground(Color.MAGENTA);
		l11.setFont(new Font("Tahoma ", Font.BOLD, 25));
		p1.add(l11);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/"+pack[11]));
		Image i2 = i1.getImage().getScaledInstance(450, 650, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(280, 10, 500, 450);
		p1.add(image);
		
		
		return p1;
	}

	public static void main(String[] args) {

		new CheckPackage();
	}

}
