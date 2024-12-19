package travel_management_system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Payment extends JFrame implements ActionListener{
	JButton pay, back;
	
	Payment(){
		
		setBounds(330,100,900, 600);
		getContentPane().setBackground(Color.white);
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/paytm.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(900, 600, Image.SCALE_DEFAULT);
    	ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 900, 600);
		getContentPane().setBackground(Color.white);
		add(image);
		
		pay = new JButton("Pay");
		pay.setBackground(Color.BLACK);
		pay.setForeground(Color.WHITE);
		pay.setFont(new Font("Tahoma", Font.BOLD, 15));
		pay.setBounds(600, 30, 100, 30);
		pay.addActionListener(this);
		image.add(pay);
		
		back = new JButton("Back");
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.setFont(new Font("Tahoma", Font.BOLD, 15));
		back.setBounds(730, 30, 100, 30);
		back.addActionListener(this);
		image.add(back);
		
		setVisible(true);
	}
	
	
	
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == pay) {
			setVisible(false);
			new Paytm();
		}else{
			setVisible(false);
		}
		
	}
	
	public static void main(String[] args) {
	

		new Payment();
	}

	

}
