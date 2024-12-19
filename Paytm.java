package travel_management_system;

import java.awt.Color;
import java.awt.event.*;

import javax.swing.*;

public class Paytm extends JFrame implements ActionListener {

	Paytm(){
		setBounds(330,100,900, 600);
		JEditorPane pane = new JEditorPane();
		pane.setEditable(false);
		
		try {
			pane.setPage("https://paytm.com/rent-payment");
		}catch(Exception e){
			pane.setContentType("text/html");
			pane.setText("<html>Could not load, Error 404</html>");
		}
		
	JScrollPane sp = new JScrollPane(pane);
	getContentPane().add(sp);
	
	JButton back = new JButton("Back");
	back.setBounds(700, 20, 80, 30);
	back.addActionListener(this);
	pane.add(back);
	
	setVisible(true);
	}
	
		public void actionPerformed(ActionEvent ae) {
			setVisible(false);
			new Payment();
		
		}

	
	
	public static void main(String[] args) {
		new Paytm();
	}

	
	
}
