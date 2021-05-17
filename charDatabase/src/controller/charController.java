package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import view.*;


/**
 * Controller class of MVC arch.
 * @author Marco
 *
 */
public class charController {

	
	private static JFrame frame;
	
	/**
	* constructor for character controller
	* @param frame used to draw the pages
	*/
	public charController(JFrame frame) 
	{
		this.frame = frame;
	}
	
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		MMP menu = new MMP(frame);
		GoDiceRollerL d = new GoDiceRollerL(menu);
		menu.addDiceListener(d);
		
	}
	
	/**
	 * Opens pop up for dice roller page
	 * @author Marco
	 *
	 */
	static class GoDiceRollerL implements ActionListener
	{
		
		MMP menu;
		public GoDiceRollerL(MMP menu){
			this.menu = menu;
		}
		public void actionPerformed(ActionEvent e)
		{
			menu.addPopup(); 
		}
		
	}
}
