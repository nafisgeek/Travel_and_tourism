package travel_management_system;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class Loading extends JFrame implements Runnable{
	Thread t;
	JProgressBar bar;
	String username;
	public void run() {
		try {
			for(int i =1; i<= 101; i++) {
				int max = bar.getMaximum();
				int value = bar.getValue();
				
				if(value < max) {
					bar.setValue(bar.getValue() + 1);
					
				}else {
					setVisible(false);
					new Dashboard(username);
				}
				Thread.sleep(30);
			}
			
		}catch (Exception e){
			e.printStackTrace();
			
		}
	}
	
	public Loading (String username){
		this.username = username;
		t =  new Thread(this);
		
		setBounds(320, 200, 600, 350);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel text = new JLabel("Travel and Toursim Application");
		text.setBounds(30, 20, 800, 40);
		text.setForeground(Color.black);
		text.setFont(new Font("Raleway", Font.BOLD, 35));
		add(text);
		
		bar = new JProgressBar();
		bar.setBounds(170, 70, 200, 20);
		bar.setStringPainted(true);
		add(bar);
		
		JLabel loading = new JLabel("Lading, please wait...");
		loading.setBounds(190, 90, 180, 20);
		loading.setForeground(Color.RED);
		loading.setFont(new Font("Raleway", Font.BOLD, 15));
		add(loading);
		
		JLabel lblusername = new JLabel("Welcome " + username);
		lblusername.setBounds(20, 280, 200, 15);
		lblusername.setForeground(Color.RED);
		lblusername.setFont(new Font("Raleway", Font.BOLD, 15));
		add(lblusername);
		
		t.start();
		setVisible(true);
	}
	
	public static void main(String[] args) {
		
		new Loading("");
		
	}

}
