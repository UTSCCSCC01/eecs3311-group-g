package plotter.plotter;

import plotter.gui.Login;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Login form = Login.getInstance();
    	form.setSize(350, 150);
    	form.setVisible(true);
    }
}
