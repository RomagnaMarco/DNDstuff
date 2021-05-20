package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
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
				UpdateDisplay uD = new UpdateDisplay(drp);
				RefreshDice rD = new RefreshDice(drp);
				drp.addRollListener(uD);
				drp.addClearListener(rD);
			}
			else
			{
				DRP.popFrame.setVisible(true); //un-hides if previously hidden( and opened ).
			}
			
		}
		
	}
	
	
	
	
	/**
	 * Updates the display for DRP for view.
	 * Uses modRollDisplay() method to alter it.
	 * @author Marco
	 *
	 */
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
	 * Affects DRP
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
	
	/**
	 * Affects DRP
	 * clears all dice and bonus to 0 when clear is clicked
	 * uses refreshDice() method to clear
	 * @author Marco
	 *
	 */
	static class RefreshDice implements ActionListener
	{
		DRP drp;
		public RefreshDice(DRP drp)
		{
			this.drp = drp;
		}

		public void actionPerformed(ActionEvent e) {
			refreshDice(drp);
			
		}
		
	}
	
	/**
	 * clears dice dropdrown on page. sets all to 0
	 * @param drp
	 */
	public static void refreshDice(DRP drp)
	{
		ArrayList<JComboBox<Integer>> list = drp.getDropdownList();
		for(int i = 0; i < list.size(); i++)
		{
			list.get(i).setSelectedItem(0);
		}
	}
}
