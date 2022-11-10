package plotter.gui;

import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import plotter.auth.Auth;

public class Login extends JFrame implements ActionListener {
	//initialize button, panel, label, and text field  
    private JButton loginBtn;  
    private JPanel panel;  
    private JLabel userLabel, passLabel;  
    private final JTextField  userField, passField;
    
    public Login() {
    	userLabel = new JLabel();  
        userLabel.setText("Username");        
        userField = new JTextField(15);
        
        passLabel = new JLabel();  
        passLabel.setText("Password");        
        passField = new JTextField(15);
        
        loginBtn = new JButton("Submit");
        panel = new JPanel(new GridLayout(3, 1));
        panel.add(userLabel);
        panel.add(userField);
        panel.add(passLabel);
        panel.add(passField);
        panel.add(loginBtn);
        
        add(panel, BorderLayout.CENTER);
        loginBtn.addActionListener(this);
        setTitle("Login");
    }
    
    public void actionPerformed(ActionEvent ev) {
    	String username = userField.getText();
    	String password = passField.getText();
    	
    	try {
			if (Auth.getInstance().authenticate(username, password)) {
				Statistics stats = new Statistics();
				
				stats.setVisible(true);  
	              
	            JLabel wel_label = new JLabel("Welcome: "+ username);
	            setVisible(false);
	            stats.getContentPane().add(wel_label);  
			} else {
				JOptionPane.showMessageDialog(null, "Invalid username and password combo.");
				System.exit(0);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
    }
    
    public static void main(String[] args) {
    	Login form = new Login();
    	form.setSize(350, 150);
    	form.setVisible(true);
    }
}
