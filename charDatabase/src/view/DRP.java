package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

/**
 * Dice Roller Page.
 * side page that is part of the view in MVC arch.
 * lets user roll dice
 * @author Marco
 *
 */
public class DRP 
{

	public static JFrame popFrame; //for popup dice roller
	ArrayList<JTextArea> arr; //popFrame display
	JButton rollB; //button to roll dice
	JButton clearB; //button to clear dice dropdown
	JComboBox<Integer> DDd4;
	JComboBox<Integer> DDd6;
	JComboBox<Integer> DDd8;
	JComboBox<Integer> DDd10;
	JComboBox<Integer> DDd12;
	JComboBox<Integer> DDd20;
	JComboBox<Integer> DDbonus;
	ArrayList<JComboBox<Integer>> JCBL;
	
	public DRP(Boolean popBool)
	{
		//prep work for layout
		
		//labels setup for dropDown Menu
		
		JPanel dicePanel = new JPanel();
		GridLayout subLayout1 = new GridLayout(7,1);
		dicePanel.setLayout(subLayout1);
		Label d4, d6, d8, d10, d12, d20, bonus; // input for textPane of each dice/bonus
		d4 = new Label("d4");
		d6 = new Label("d6");
		d8 = new Label("d8");
		d10 = new Label("d10");
		d12 = new Label("d12");
		d20 =  new Label("d20");
		bonus = new Label("Bonus");
		
		//dropdown setup
		JCBL = new ArrayList<>();
		Integer list[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		Integer list2[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
		DDd4 = new JComboBox<>(list); //drop down d4
		DDd6 = new JComboBox<>(list); //drop down d6
		DDd8 = new JComboBox<>(list); //drop down d8
		DDd10 = new JComboBox<>(list); //drop down d10
		DDd12 = new JComboBox<>(list); //drop down d12
		DDd20 = new JComboBox<>(list); //drop down d20
		DDbonus = new JComboBox<>(list2); //drop down bonus
		dicePanel.add(DDd4);dicePanel.add(d4);
		dicePanel.add(DDd6);dicePanel.add(d6);
		dicePanel.add(DDd8);dicePanel.add(d8);
		dicePanel.add(DDd10);dicePanel.add(d10);
		dicePanel.add(DDd12);dicePanel.add(d12);
		dicePanel.add(DDd20);dicePanel.add(d20);
		dicePanel.add(DDbonus);dicePanel.add(bonus);
		
		//add comboboxes to JCBL
		JCBL.add(DDd4);
		JCBL.add(DDd6);
		JCBL.add(DDd8);
		JCBL.add(DDd10);
		JCBL.add(DDd12);
		JCBL.add(DDd20);
		JCBL.add(DDbonus);
		
		//display setup
		JPanel displayP = new JPanel();
		displayP.setBorder(new LineBorder(Color.LIGHT_GRAY,3));
		GridLayout subLayout2 = new GridLayout(8,1);
		displayP.setLayout(subLayout2);
		arr = new ArrayList<>();
		//adds new text areas in arrayList
		for(int i = 0; i < 8; i++) {//adds 9 text areas
			arr.add(new JTextArea());
		}
		//clarify most recent roll
		JTextArea recentRoll = arr.get(0);
		recentRoll.setBackground(Color.LIGHT_GRAY);
		recentRoll.setFont(recentRoll.getFont().deriveFont(Font.BOLD, 14f));
		recentRoll.append("Result: ");
		
		//make it so the user can't edit results of rolls
		for (int i =0; i < arr.size(); i++){ //Sets all to non-editable and adds them
			arr.get(i).setEditable(false);
			displayP.add(arr.get(i));
		}
		
		//buttons made
		clearB = new JButton("Clear"); //clears dice dropdown
		rollB = new JButton("Roll");
	
		//pop up setup
		popBool = true; // for hiding and closing condition
		
		//main layout
		popFrame = new JFrame("Dice Roller"); //opens frame diceRoller
		JPanel panel = new JPanel();
		GridLayout mainL = new GridLayout(2,2); //main Layout
		panel.setLayout(mainL); //sets layout
		
		panel.add(displayP);
		panel.add(dicePanel);
		panel.add(rollB);
		panel.add(clearB);
		popFrame.add(panel);
		popFrame.pack();
		
		popFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		popFrame.setSize(300,390);
		popFrame.setResizable(false);
		popFrame.setVisible(true);
			
	}
	

	/**
	 * Returns the display from the dice roller popup
	 * in the form of 9 JTextAreas
	 */
	public ArrayList<JTextArea> getDisplay()
	{
		return arr;	
	}
	
	/**
	 * action listener will work for this roll button
	 * @param listenRoll
	 */
	public void addRollListener(ActionListener listenRoll)
	{
		rollB.addActionListener(listenRoll);
	
	}
	
	/**
	 * action listener will work for this clear button
	 * @param listenClear
	 */
	public void addClearListener(ActionListener listenClear)
	{
		clearB.addActionListener(listenClear);
	
	}
	
	/**
	 * From DRP has drowndowns for dice
	 * @return the list of JComboBoxes compromising the values of the dice quantities
	 */
	public ArrayList<JComboBox<Integer>> getDropdownList()
	{
		return JCBL;
		
	}
	

	/**
	 * From DRP has  dice quantities
	 * @return the list of values selected
	 */
	public ArrayList<Integer> getDiceRollList()
	{
		ArrayList<Integer> values = new ArrayList<>();
		for(int i = 0; i < JCBL.size(); i++)
		{
			values.add((Integer) JCBL.get(i).getSelectedItem());
		}
		return values;
		
	}
	
}
