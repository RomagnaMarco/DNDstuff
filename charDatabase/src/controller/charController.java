package controller;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextArea;

import model.PointBuyPage;
import view.*;


/**
 * Controller class of MVC arch.
 * @author Marco
 *
 */
public class charController {

	private static Boolean DebugMRD = false;
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
		GoCCBP ccBP = new GoCCBP(menu);
		GoCCRS ccRS = new GoCCRS(menu);
		GoCCMS ccMS = new GoCCMS(menu);
		menu.addDiceListener(d);
		menu.addPBListener(ccBP);
		menu.addSRListener(ccRS);
		menu.addMSListener(ccMS);
		menu.addDiceListener(d);
		menu.addPBListener(ccBP);
		menu.addSRListener(ccBP);
		menu.addMSListener(ccBP);
		
		
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
		
		GoCCBP ccBP;
		GoCCMS ccMS;
		GoCCRS ccRS;
		public GoMMPL(JFrame frame)
		{
			this.frame = frame;
		}
		
		public void actionPerformed(ActionEvent e) {
			menu = new MMP(frame);
			d = new GoDiceRollerL(menu);
			ccBP = new GoCCBP(menu);
			ccRS = new GoCCRS(menu);
			ccMS = new GoCCMS(menu);
			menu.addDiceListener(d);
			menu.addPBListener(ccBP);
			menu.addSRListener(ccRS);
			menu.addMSListener(ccMS);

		}
		
	}
	
	
	/**
	 * Sends to CCBP (character creation phase 0 page = point Buy)
	 * @author Marco
	 *
	 */
	static class GoCCBP implements ActionListener
	{
		CCPB ccBP;
		MMP menu;
		GoMMPL b;
		GoCC1L c;
		PointBuyPage PBP;
		ManagePointBuyUI ui;
		public GoCCBP(MMP menu)
		{
			this.menu = menu;
		}
		
		public void actionPerformed(ActionEvent e) {
			ccBP = new CCPB(menu.frame);
			b = new GoMMPL(menu.frame);
			c = new GoCC1L(menu);
			ccBP.addBackListener(b);
			ccBP.addContListener(c);
			
			PBP = new PointBuyPage();
			ui = new ManagePointBuyUI(PBP, ccBP);
			
			/// all the plus and minus buttons. and the confirm button
			ccBP.addConfirmListener(ui);
			ccBP.addPlusSTRListener(ui);
			ccBP.addMinusSTRListener(ui);
			ccBP.addPlusDEXListener(ui);
			ccBP.addMinusDEXListener(ui);
			ccBP.addPlusCONListener(ui);
			ccBP.addMinusCONListener(ui);
			ccBP.addPlusINTListener(ui);
			ccBP.addMinusINTListener(ui);
			ccBP.addPlusWISListener(ui);
			ccBP.addMinusWISListener(ui);
			ccBP.addPlusCHAListener(ui);
			ccBP.addMinusCHAListener(ui);
			
		}
		
	}
	
	/**
	 * Sends to CCMS (character creation phase 0 page = manual Select)
	 * @author Marco
	 *
	 */
	static class GoCCMS implements ActionListener
	{
		CCMS ccMS;
		MMP menu;
		GoMMPL b;
		GoCC1L c;
		public GoCCMS(MMP menu)
		{
			this.menu = menu;
		}
		
		public void actionPerformed(ActionEvent e) {
			ccMS = new CCMS(menu.frame);
			b = new GoMMPL(menu.frame);
			c = new GoCC1L(menu);
			ccMS.addBackListener(b);
			ccMS.addContListener(c);
			
		}
		
	}
	
	
	/**
	 * Sends to CCBP (character creation phase 0 page = point Buy)
	 * @author Marco
	 *
	 */
	static class GoCCRS implements ActionListener
	{
		CCRS ccRS;
		MMP menu;
		GoMMPL b;
		GoCC1L c;
		public GoCCRS(MMP menu)
		{
			this.menu = menu;
		}
		
		public void actionPerformed(ActionEvent e) {
			ccRS = new CCRS(menu.frame);
			b = new GoMMPL(menu.frame);
			c = new GoCC1L(menu);
			ccRS.addBackListener(b);
			ccRS.addContListener(c);
			
		}
		
	}
	
	
	/**
	 * Sends to CC1P (character creation phase 1 page)
	 * @author Marco
	 *
	 */
	static public class GoCC1L implements ActionListener
	{
		CC1P cc1;
		MMP menu;
		GoCCBP b;
		GoCC2L c;
		public GoCC1L(MMP menu)
		{
			this.menu = menu;
		}
		
		public void actionPerformed(ActionEvent e) {
			cc1 = new CC1P(menu.frame);
			b = new GoCCBP(menu);
			c = new GoCC2L(menu);
			cc1.addBackListener(b);
			cc1.addContListener(c);
		}
		
	}
	
	/**
	 * Sends to CC1P (character creation phase 2 page)
	 * @author Marco
	 *
	 */
	static public class GoCC2L implements ActionListener
	{
		CC2P cc3;
		MMP menu;
		GoCC1L b;
		public GoCC2L(MMP menu)
		{
			this.menu = menu;
		}
		
		public void actionPerformed(ActionEvent e) {
			cc3 = new CC2P(menu.frame);
			b = new GoCC1L(menu);
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
	
	static class ManagePointBuyUI implements ActionListener
	{
		PointBuyPage PBP;
		CCPB view;
		JButton[] plusArr;
		JButton[] minusArr;
		JButton confirmB;
		public ManagePointBuyUI(PointBuyPage PBP, CCPB view)
		{ 
			this.PBP = PBP;
			this.view = view;
			plusArr = view.getPlusArr();
			minusArr = view.getMinusArr();
			confirmB = view.getConfirmB();
		}

		public void actionPerformed(ActionEvent e) {
			
			//checks which button is performing the action event
			if(e.getSource() == confirmB)
			{
				
			}
			else if(e.getSource() == minusArr[0]) //STR minus
			{
				ModifyScore("STR", false, PBP, view);
			}
			else if(e.getSource() == minusArr[1]) //DEX minus
			{
				ModifyScore("DEX", false, PBP, view);
			}
			else if(e.getSource() == minusArr[2]) //CON minus
			{
				ModifyScore("CON", false, PBP, view);
			}
			else if(e.getSource() == minusArr[3]) //INT minus
			{
				ModifyScore("INT", false, PBP, view);
			}
			else if(e.getSource() == minusArr[4]) //WIS minus
			{
				ModifyScore("WIS", false, PBP, view);
			}
			else if(e.getSource() == minusArr[5]) //CHA minus
			{
				ModifyScore("CHA", false, PBP, view);
			}
			else if(e.getSource() == plusArr[0]) //STR plus
			{
				ModifyScore("STR", true, PBP, view);
			}
			else if(e.getSource() == plusArr[1]) //DEX plus
			{
				ModifyScore("DEX", true, PBP, view);
			}
			else if(e.getSource() == plusArr[2]) //CON plus
			{
				ModifyScore("CON", true, PBP, view);
			}
			else if(e.getSource() == plusArr[3]) //INT plus
			{
				ModifyScore("INT", true, PBP, view);
			}
			else if(e.getSource() == plusArr[4]) //WIS plus
			{
				ModifyScore("WIS", true, PBP, view);
			}
			else if(e.getSource() == plusArr[5]) //CHA plus
			{
				ModifyScore("CHA", true, PBP, view);
			}
			else
			{
				System.out.println("Something has gone wrong in charController.java in the "
						+ "  ManagePointBuyUI static class during the actionPerformed Event");
			}
			
		}
		
		
	
	}
	
	/**
	 * Takes in row(attribute) and modifies the Ability Scores with points
	 * If there is not enough points, the modification won't happen.
	 * Changes will also reflect with the points left option.
	 * By default, points are currently set at 27. (this may change)
	 * @param attr The attribute value. Given string of name of attribute
	 * @param PBP the model to grab info from.
	 * @param positive to determine whether or not to add or subtract from the score
	 */
	public static void ModifyScore(String attr, boolean positive, PointBuyPage PBP, CCPB view)
	{
		int selectedItem = view.getSelectedPB();
		int pos = 1;
		if (positive == false)
		{
			pos*= -1;
		}
		
		if(checkScore(attr, positive, PBP, selectedItem) == true) //sufficient points
		{
			//retrieve values from model
			int pointsNeeded = PBP.getPointsNeeded(PBP.getAttribute(attr));
			pointsNeeded = pointsNeeded * pos; //account for subtracting or addition of points
			int pointsLeft = PBP.getPointsLeft();
			int allocated = PBP.getAttributePoints(attr);
			int attrCurr = PBP.getAttribute(attr);
			
			//variables to make things easier
			int newPointsLeft = pointsLeft-pointsNeeded;
			int newAllocated = pointsNeeded + allocated;
			int newAttr = attrCurr + pos; //this either adds or subtracts 1
			
			//modify pointsLeft in view
			view.modifyPointsLeft(newPointsLeft);
			
			//modify pointsLeft in model
			PBP.setPointsLeft(newPointsLeft);
			
			//manage points in view
			view.modifyPointsAllocated(attr, newAllocated);
			
			//manage points in model
			PBP.setAttributePoints(attr, newAllocated);
			
			//manage attribute in view
			view.modifyAttribute(attr, newAttr);
			
			//manage attribute in model
			PBP.setAttribute(attr, newAttr);
			
			
		}
		else
		{
			//nothing happens. insufficient points
		}
	}
	
	/**
	 * Checks if enough points to modify that attribute score for a given attribute
	 * also checks if it doesn't go over  15 or under 8.
	 * @param AbilityScore checks this ability score to see if there enough points. uses the name to later pull from the
	 * score stored in the model.
	 * @param positive determines whether or not your trying to subtract or add from the points
	 * @return if able to modify this attribute
	 */
	public static boolean checkScore(String attrName, boolean positive, PointBuyPage PBP, int SelectedItem)
	{
		boolean valid = true; //true by default
		
		//grab from model
		int pL = PBP.getPointsLeft(); //points left
		int attr = PBP.getAttribute(attrName); //gets integer value of ability score currently at
		int pN = PBP.getPointsNeeded(attr); // points needed. 1000 for sake of initializing
	
		//logic
		if (positive == true)
		{
			if(pN > pL) //cannot add when points needed exceed points left
			{
				valid = false;
			}
			if(attr == 15) //cannot add past 15
			{
				valid = false;
			}
		}
		else
		{
			if(attr == 8) //cannot subtract past 8
			{
				valid = false;
			}
			if(pN + pL > SelectedItem) //No getting more points somehow.
			{
				valid = false;
			}
		}
			
		return valid;
	}
	
}
