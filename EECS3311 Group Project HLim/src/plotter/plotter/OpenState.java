package plotter.plotter;

import plotter.gui.Login;
import plotter.gui.MainUI2;

public class OpenState {
	private String state = "ON";
	private Login form;
	private static OpenState instance = new OpenState();
	
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
		} else if(state.equals("login")) {
			//check for authentication
			this.form = Login.getInstance();
	    	form.setSize(350, 150);
	    	form.setVisible(true);
		//Check if authentication is true
		} else if(state.equals("analyzing")) {
			MainUI2 analysis = MainUI2.getInstance();
		//Assume state is OFF
		} else {
			System.out.println(state);
			this.setState("ON");
			System.exit(0);
		}
		//Assume OFF
		System.out.println(state);
	
		this.setState("ON");
	}
	
	public OpenState() {
		
	}
	
	public static void main(String[] args) {
		OpenState state = OpenState.getInstance();
		state.doAction();
	}
}
