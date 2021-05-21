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
		
		ArrayList<JTextArea> arr = drp.getDisplay();
		ArrayList<Integer> list = drp.getDiceRollList();
		ArrayList<Integer> diceRow = new ArrayList<>();
		
		//9 text areas. 0-8. but first one says Result:
		//1-8 are available to show dice.
		String strFront;
		String strEnd;
		String strDice = "";
		Integer result = 0;
		Integer rowResult = 0;
		arr.get(0).setText("Result: "); //reinitialize
		
		for(int listIndex = 0; listIndex < list.size();listIndex ++)
		{
			String displayRow= "";
			strDice = "";
			strEnd = "): ";
			//populates each dice Row
			if(listIndex  == 0) //d4
			{
				strFront = "D4(";
				for(int j = 0; j < list.get(listIndex ); j++){diceRow.add(DiceRoll(1,5));}
			}
			else if (listIndex == 1) //d6
			{
				strFront = "D6(";
				for(int j = 0; j < list.get(listIndex ); j++){diceRow.add(DiceRoll(1,7));}	
			}
			else if (listIndex  == 2) //d8
			{
				strFront = "D8(";
				for(int j = 0; j < list.get(listIndex ); j++){diceRow.add(DiceRoll(1,8));}
			}
			else if (listIndex  == 3) //d10
			{
				strFront = "D10(";
				for(int j = 0; j < list.get(listIndex ); j++){diceRow.add(DiceRoll(1,11));}
			}
			else if (listIndex  == 4) //d12
			{
				strFront = "D12(";
				for(int j = 0; j < list.get(listIndex ); j++){diceRow.add(DiceRoll(1,13));}
			}
			else if (listIndex  == 5) //d20
			{
				strFront = "D20(";
				for(int j = 0; j < list.get(listIndex ); j++){diceRow.add(DiceRoll(1,21));}
			}
			else //bonus
			{
				strFront = "Bonus: ";
				strEnd = "";
			}
			
			//adds values and also converts them to string to display for each row
			for(int rowIndex = 0; rowIndex < diceRow.size(); rowIndex++)
			{
				rowResult = 0;
				rowResult += diceRow.get(rowIndex);
				result+= rowResult;
				strDice += diceRow.get(rowIndex).toString();
				if(rowIndex != diceRow.size()-1) //dont add + to string on last dice
				{
					strDice += "+";
				}
				
			}
			strDice  += "= "+ rowResult.toString();
			displayRow = strFront+list.get(listIndex)+strEnd+strDice;
			//for every row after row 0, set the text to display row for a row after the index
			if(listIndex  != list.size()) // don't do this for the last row with the bonus
			{
				arr.get(listIndex +1).setText(displayRow);
			}
		}
				
		arr.get(0).append(result.toString()); //result of all dice
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
	
}
