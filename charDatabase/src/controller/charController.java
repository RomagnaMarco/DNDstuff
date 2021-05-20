package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTextArea;

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
			//checks if previously opened or not.
			if(menu.popBool == false)
			{
				DRP drp = new DRP(menu.popBool);
				UpdateDisplay mr = new UpdateDisplay(drp);
				drp.addRollListener(mr);
			}
			else
			{
				DRP.popFrame.setVisible(true); //un-hides if previously hidden( and opened ).
			}
			
		}
		
	}
	
	
	
	
	
	static class UpdateDisplay implements ActionListener
	{
		DRP drp;
		public UpdateDisplay(DRP drp)
		{
			this.drp = drp;
		}

		public void actionPerformed(ActionEvent e) {
			modRollDisplay(drp.getDisplay());
			
		}
		
	}
	
	/**
	 * modifies display when Roll button is clicked
	 * Rolls dice with greater value than 0 and the bonus on display
	 * @param arr
	 */
	public static void modRollDisplay(ArrayList<JTextArea> arr)
	{
		//9 text areas. 0-8. but first one says Result:
		//1-8 are available to show dice.
		arr.get(1).setText("test");
		
	}
	
}
