package plotter.plotter;

import plotter.gui.Login;

public class OpenState {
	private String state = "ON";
	private Login form;
	
	public void setState(String state) {
		this.state = state;
	}
	
	public OpenState() {
		//repeat for program runtime
		while(!state.equals("OFF")) {
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
				
			//Assume authentication failed
			} else {
				
			}
		}
	}
}
