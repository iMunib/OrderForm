package WinterBreak;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class GUIFrame  implements ActionListener{

	
	GUIFrame(){
		  
		  JFrame frame = new JFrame();
		  JButton send = new JButton("Send");
		  JButton clear = new JButton("Clear");
		  JTextField userName = new JTextField();
		  JTextField userPhoneNumber = new JTextField();
		  JTextField userEmail = new JTextField();
		  JTextField userAddress = new JTextField();
		  JCheckBox userContactMethodEmail = new JCheckBox();
		  JCheckBox userContactMethodPhone = new JCheckBox();
		  JTextArea userNotes = new JTextArea();
		  JLabel userNameLabel = new JLabel("Name: ");
		  JLabel userPhoneNumberLabel = new JLabel("Phone Number: ");
		  JLabel userEmailLabel = new JLabel("Email: ");
		  JLabel userAddressLabel = new JLabel("Address: ");
		  JLabel userContactMethodLabel = new JLabel("Best way to contact: ");
		  JLabel userNotesLabel = new JLabel("Any notes: ");
		  
		  
		  userContactMethodEmail.setText("Email");
		  userContactMethodPhone.setText("Phone");
		  userContactMethodEmail.setFocusable(false);
		  userContactMethodPhone.setFocusable(false);
		  
		  
		  
		  send.setBounds(120, 600, 75, 25);
		  clear.setBounds(250, 600, 75, 25);
		  
		  userNameLabel.setBounds(60, 40, 70, 25);
		  userName.setBounds(175, 45, 150, 20);
		  
		  userPhoneNumberLabel.setBounds(60, 60, 100, 25);
		  userPhoneNumber.setBounds(175, 65, 150, 20);
		  
		  userEmailLabel.setBounds(60, 80, 100, 25);
		  userEmail.setBounds(175, 85, 150, 20);
		  
		  userAddressLabel.setBounds(60, 100, 100, 25);
		  userAddress.setBounds(175, 105, 250, 20);
		  
		  userContactMethodLabel.setBounds(60, 125, 250, 20);
		  userContactMethodEmail.setBounds(200, 125, 75, 20);
		  userContactMethodPhone.setBounds(275, 125, 75, 20);
		  
		  userNotesLabel.setBounds(60, 155, 100, 25);
		  userNotes.setBounds(60, 185, 350, 250);
		  
		  
		  
		  frame.add(userNotesLabel);
		  frame.add(userNotes);
		  frame.add(userNameLabel);
		  frame.add(userName);
		  frame.add(userAddressLabel);
		  frame.add(userAddress);
		  frame.add(userContactMethodLabel);
		  frame.add(userPhoneNumberLabel);
		  frame.add(userPhoneNumber);
		  frame.add(userEmailLabel);
		  frame.add(userEmail);
		  frame.add(userContactMethodEmail);
		  frame.add(userContactMethodPhone);
		  frame.add(send);
		  frame.add(clear);
		  
		  
		  
		  
		  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  frame.setSize(450,700);
		  frame.setLayout(null);
		  frame.setVisible(true);
		  frame.setResizable(false);
		  
		  
		  
		  
		 
		
}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
