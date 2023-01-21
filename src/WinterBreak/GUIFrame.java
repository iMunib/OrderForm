package WinterBreak;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class GUIFrame implements ActionListener{
	
	  final String senderEmail = "rehmanhavingfun@gmail.com";
	  final String storeOwner = "munib.rehman01@gmail.com";
	  final String senderPassword= "mqbzogjddzuddncf";
	  final String emailSMTPserver = "smtp.gmail.com";
	  final String emailServerPort = "587";
	  String collectedEmail;
	  String emailSubject;
	  String emailBody;
	
	
	  JFrame frame;
	  JButton send;
	  JButton clear;
	  JTextField userName;
	  JTextField userPhoneNumber;
	  JTextField userEmail;
	  JTextField userAddress;
	  JCheckBox userContactMethodEmail;
	  JCheckBox userContactMethodPhone;
	  JTextArea userNotes;
	  JLabel userNameLabel;
	  JLabel userPhoneNumberLabel;
	  JLabel userEmailLabel;
	  JLabel userAddressLabel;
	  JLabel userContactMethodLabel;
	  JLabel userNotesLabel;
	  
	  

	
	GUIFrame(){
		  
		   frame = new JFrame();
		   frame.setTitle("Orderform by Rehman");
		   frame.setIconImage((new ImageIcon(getClass().getResource("duck-v3.png")).getImage()));
		   frame.getContentPane().setBackground(Color.lightGray);
		   send = new JButton("Send");
		   clear = new JButton("Clear");
		   userName = new JTextField();
		   userPhoneNumber = new JTextField();
		   userEmail = new JTextField();
		   userAddress = new JTextField();
		   userContactMethodEmail = new JCheckBox();
		   userContactMethodPhone = new JCheckBox();
		   userNotes = new JTextArea();
		   userNameLabel = new JLabel("Name: ");
		   userPhoneNumberLabel = new JLabel("Phone Number: ");
		   userEmailLabel = new JLabel("Email: ");
		   userAddressLabel = new JLabel("Address: ");
		   userContactMethodLabel = new JLabel("Best way to contact: ");
		   userNotesLabel = new JLabel("Any notes: ");
		  
		  
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
		  clear.addActionListener(this);
		  send.addActionListener(this);
		  	
}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==clear) {
			userNotes.setText("");
			userName.setText("");
			userAddress.setText("");
			userPhoneNumber.setText("");
			userEmail.setText("");
			userContactMethodEmail.setSelected(false);
			userContactMethodPhone.setSelected(false);	
		}
		else if(e.getSource()==send) {
			String collectedName = userName.getText();
			String collectedPhoneNumber = userPhoneNumber.getText();
			collectedEmail = userEmail.getText();
			String collectedAddress = userAddress.getText();
			String collectedNotes = userNotes.getText();
			Boolean collectedMethodOfContactEmail= userContactMethodEmail.isSelected();
			Boolean collectedMethodOfContactPhone= userContactMethodPhone.isSelected();
			
			// Set up the email properties
			Properties props = new Properties();
			props.put("mail.smtp.user", senderEmail);
			props.put("mail.smtp.host", emailSMTPserver);
			props.put("mail.smtp.port", emailServerPort);
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			
			
			// Create a session with the email properties
			Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			    protected PasswordAuthentication getPasswordAuthentication() {
			        return new PasswordAuthentication(senderEmail, senderPassword);
			    	}
			  	}
			);
			
			
			try {
			    // Create a message with the recipient's email address, the sender's email address, and the message content
			    Message message = new MimeMessage(session);
			    message.setFrom(new InternetAddress(senderEmail));
			    
			    message.addRecipients(Message.RecipientType.TO,
			        InternetAddress.parse(collectedEmail));
			    message.addRecipients(Message.RecipientType.TO,
				        InternetAddress.parse(storeOwner));
			    
			    message.setSubject("Orderform Confirmation by Rehman");
			    message.setText("Name: " + collectedName + "\nPhone Number: " + collectedPhoneNumber + 
			    		"\nEmail: "+collectedEmail+ "\nAddress: " + collectedAddress+ 
			    		"\nBest way to get in contact:\n\tPhone: "+collectedMethodOfContactPhone+"\n\tEmail: " +collectedMethodOfContactEmail +"\nNotes: " + collectedNotes);

			    // Send the email
			    Transport.send(message);
			    System.out.println("Email sent successfully.");

			} catch (Exception ex) {
				System.out.println("Something went wrong sending the email");
			    ex.printStackTrace();
			}
			finally {
				userNotes.setText("");
				userName.setText("");
				userAddress.setText("");
				userPhoneNumber.setText("");
				userEmail.setText("");
				userContactMethodEmail.setSelected(false);
				userContactMethodPhone.setSelected(false);	
			}
			  
			
		}
		
	}
	
}