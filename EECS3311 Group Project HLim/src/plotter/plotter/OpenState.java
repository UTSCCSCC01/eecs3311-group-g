package plotter.plotter;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import plotter.gui.Login;
import plotter.gui.MainUI2;

public class OpenState implements WindowListener{
	private String state = "ON";
	private Login form;
	private static OpenState instance = new OpenState();
	private WindowListener listener;
	
	public static OpenState getInstance() {
        if (instance == null) {
            instance = new OpenState();
        }
        return instance;
    }
	
	public void setState(String state) {
		this.state = state;
	}
	
	public void doAction() {
		//Check state
		//Check if state is start
		if(state.equals("ON")) {
			//Initialize all classes
			
			this.setState("login");
			this.doAction();
		} else if(state.equals("login")) {
			//check for authentication
			this.form = Login.getInstance();
	    	form.setSize(350, 150);
	    	form.addWindowListener(this);
	    	form.setVisible(true);
		//Check if authentication is true
		} else if(state.equals("analyzing")) {
			MainUI2 analysis = MainUI2.getInstance();
			analysis.addWindowListener(this);
		//Assume state is OFF
		} else {
			System.out.println(state);
			this.setState("ON");
			//System.exit(0);
		}
		
		//Assume OFF
		System.out.println(state);
	}
	
	public OpenState() {
		this.setState("ON");
	}
	
	public static void main(String[] args) {
		OpenState state = OpenState.getInstance();
		state.doAction();
	}

	public void windowOpened(WindowEvent e) {
		//System.out.println("Login Opened");
		//System.out.println(e.getSource().getClass().toString());
	}

	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		//System.out.println(e.getSource().toString());
	}

	public void windowClosed(WindowEvent e) {
		//System.out.println("Login Closed");
	}

	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void windowDeactivated(WindowEvent e) {
		System.out.println("Login deactivated");
		if(!e.getWindow().isVisible()) {
			//Check if source is Login
			if(e.getSource().getClass() == Login.class) {
				this.setState("analyzing");
				this.doAction();
			//Assume source is MainGUI2
			} else {
				this.setState("OFF");
				this.doAction();
			}
		}
		
		
	}
}
