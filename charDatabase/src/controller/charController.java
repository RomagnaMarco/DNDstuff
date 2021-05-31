package controller;

import java.awt.Font;
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

	private static Boolean DebugMRD = true;
	private static JFrame frame;
	static Boolean DRPBool= false; //value to remember if DRP is shown yet
	
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
		GoCC1L cc1 = new GoCC1L(menu);
		menu.addDiceListener(d);
		menu.addCCListener(cc1);
		
		
	}
	
	//Go -method/thing- L (L stands for listener) format
	
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
			if(DRPBool == false)
			{
				DRPBool = true; //make it so it remembers this in the controller. will prevent dupes
				DRP drp = new DRP();
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
	 * Sends back to MainMenuPage from another page
	 * @author Marco
	 *
	 */
	static class GoMMPL implements ActionListener
	{
		JFrame frame;
		MMP menu;
		GoDiceRollerL d;
		
		GoCC1L cc1;
		public GoMMPL(JFrame frame)
		{
			this.frame = frame;
		}
		
		public void actionPerformed(ActionEvent e) {
			menu = new MMP(frame);
			d = new GoDiceRollerL(menu);
			cc1 = new GoCC1L(menu);
			menu.addDiceListener(d);
			menu.addCCListener(cc1);
		}
		
	}
	
	
	/**
	 * Sends to CC1P (character creation phase 1 page)
	 * @author Marco
	 *
	 */
	static class GoCC1L implements ActionListener
	{
		CC1P cc1;
		MMP menu;
		GoMMPL b;
		GoCC2L c;
		public GoCC1L(MMP menu)
		{
			this.menu = menu;
		}
		
		public void actionPerformed(ActionEvent e) {
			cc1 = new CC1P(menu.frame);
			b = new GoMMPL(menu.frame);
			c = new GoCC2L(menu);
			cc1.addBackListener(b);
			cc1.addContListener(c);
			
		}
		
	}
	
	
	/**
	 * Sends to CC2P (character creation phase 2 page)
	 * @author Marco
	 *
	 */
	static public class GoCC2L implements ActionListener
	{
		CC2P cc2;
		MMP menu;
		GoCC1L b;
		GoCC3L c;
		public GoCC2L(MMP menu)
		{
			this.menu = menu;
		}
		
		public void actionPerformed(ActionEvent e) {
			cc2 = new CC2P(menu.frame);
			b = new GoCC1L(menu);
			c = new GoCC3L(menu);
			cc2.addBackListener(b);
			cc2.addContListener(c);
		}
		
	}
	
	/**
	 * Sends to CC2P (character creation phase 2 page)
	 * @author Marco
	 *
	 */
	static public class GoCC3L implements ActionListener
	{
		CC3P cc3;
		MMP menu;
		GoCC2L b;
		public GoCC3L(MMP menu)
		{
			this.menu = menu;
		}
		
		public void actionPerformed(ActionEvent e) {
			cc3 = new CC3P(menu.frame);
			b = new GoCC2L(menu);
			cc3.addBackListener(b);
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
			modRollDisplay(drp);
			
		}
		
	}
	
	/**
	 * Affects DRP
	 * modifies display when Roll button is clicked
	 * Rolls dice with greater value than 0 and the bonus on display
	 * @param arr
	 */
	public static void modRollDisplay(DRP drp){
		
		ArrayList<JTextArea> displayList = drp.getDisplay();
		ArrayList<Integer> DRlist = drp.getDiceRollList();
		ArrayList<Integer> diceRow = new ArrayList<>();
		
		//9 text areas. 0-8. but first one says Result:
		//1-8 are available to show dice.
		String strFront;
		String strEnd;
		String strDice = "";
		Integer result = 0;
		Integer rowResult = 0;
		displayList.get(0).setText("Result: "); //reinitialize
		int numDice = DRlist.size()-1;
		for(int listIndex = 0; listIndex < numDice+1; listIndex++)
		{
			DebugMRD("\n"+"Entering For(Loop). Index: "+listIndex+"/"+numDice+"\n");
			String displayRow= "";
			strDice = "";
			strEnd = "): ";
			//populates each dice Row
			if(listIndex  == 0) //d4
			{
				DebugMRD("@ "+listIndex+"\n"+DRlist.get(listIndex) +" Dice counted");
				DebugMRD("Dice to be added to DiceRow= "+ DRlist.get(listIndex));
				strFront = "D4(";
				for(int j = 0; j < DRlist.get(listIndex); j++){
					diceRow.add(DiceRoll(1,5));
					}
				DebugMRD("DiceRow num of dice= "+ diceRow.size());
			}
			else if (listIndex == 1) //d6
			{
				DebugMRD("@ "+listIndex+"\n"+DRlist.get(listIndex) +" Dice counted");
				DebugMRD("Dice to be added to DiceRow= "+ DRlist.get(listIndex));
				strFront = "D6(";
				for(int j = 0; j < DRlist.get(listIndex ); j++){
					diceRow.add(DiceRoll(1,7));
				}
				DebugMRD("DiceRow num of dice= "+ diceRow.size());
			}
			else if (listIndex  == 2) //d8
			{
				DebugMRD("@ "+listIndex+"\n"+DRlist.get(listIndex) +" Dice counted");
				DebugMRD("Dice to be added to DiceRow= "+ DRlist.get(listIndex));
				
				strFront = "D8(";
				for(int j = 0; j < DRlist.get(listIndex ); j++){
					diceRow.add(DiceRoll(1,8));
					}
				
				DebugMRD("DiceRow num of dice= "+ diceRow.size());
			}
			else if (listIndex  == 3) //d10
			{
				DebugMRD("@ "+listIndex+"\n"+DRlist.get(listIndex) +" Dice counted");
				DebugMRD("Dice to be added to DiceRow= "+ DRlist.get(listIndex));
				
				strFront = "D10(";
				for(int j = 0; j < DRlist.get(listIndex ); j++){
					diceRow.add(DiceRoll(1,11));
					}
				
				DebugMRD("DiceRow num of dice= "+ diceRow.size());
			}
			else if (listIndex  == 4) //d12
			{
				DebugMRD("@ "+listIndex+"\n"+DRlist.get(listIndex) +" Dice counted");
				DebugMRD("Dice to be added to DiceRow= "+ DRlist.get(listIndex));
				
				strFront = "D12(";
				for(int j = 0; j < DRlist.get(listIndex ); j++){
					diceRow.add(DiceRoll(1,13));
					}
				
				DebugMRD("DiceRow num of dice= "+ diceRow.size());
			}
			else if (listIndex  == 5) //d20
			{
				DebugMRD("@ "+listIndex+"\n"+DRlist.get(listIndex) +" Dice counted");
				DebugMRD("Dice to be added to DiceRow= "+ DRlist.get(listIndex));
				
				strFront = "D20(";
				for(int j = 0; j < DRlist.get(listIndex ); j++){
					diceRow.add(DiceRoll(1,21));
				}
				
				DebugMRD("DiceRow num of dice= "+ diceRow.size());
			}
			else //bonus
			{
				DebugMRD("@ "+listIndex+"\n"+"Bonus Reached");
				strFront = "Bonus: ";
				diceRow.add(DRlist.get(listIndex)); //just gets the num of bonus
				strEnd = "";
			}
			
			rowResult = 0;
			//adds values and also converts them to string to display for each row
			for(int rowIndex = 0; rowIndex < diceRow.size(); rowIndex++)
			{
				
				rowResult += diceRow.get(rowIndex);
				if(listIndex != numDice)
					strDice += diceRow.get(rowIndex).toString();
				if(rowIndex != diceRow.size()-1) //dont add + to string on last dice
				{
					strDice += "+";
				}
				
			}
			result += rowResult;
			if(listIndex != numDice)
				strDice  += "= "+ rowResult.toString();
			displayRow = strFront+DRlist.get(listIndex)+strEnd+strDice;
			
			displayList.get(listIndex + 1).setText(displayRow); //set text to display row after index
			
			diceRow.clear();
		}
				
		displayList.get(0).append(result.toString()); //result of all dice
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
	
	/**
	 * most basic dice roller
	 * @param low the smallest value roll-able
	 * @param high the biggest value roll-able +1
	 * @return value rolled by the dice
	 */
	public static int DiceRoll(int low, int high)
	 {
		//note low 1, and high 7 would be a d6
		 int min = (int) Math.ceil(low);
		 int max = (int) Math.floor(high);
		 return (int) Math.floor(Math.random()*(max - min) + min);
	 }
	
	/**
	 * Debugger for ModRollDisplay. Switch local variable on in charController to see Debug messages
	 * private. no using in other classes.
	 * @param message takes in debug message to print
	 */
	private static void DebugMRD(String message)
	{
		if(DebugMRD == true)
		{
			System.out.println(message);
		}
	}
	
}
