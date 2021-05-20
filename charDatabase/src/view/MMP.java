package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

/**
 * Main Menu Page.
 * Initial page you start on.
 * Part of View in MVC arch.
 * @author Marco
 *
 */
public class MMP {
	private JButton viewB; //view character button
	private JButton ccB; //create character button
	private JButton diceB; //dice page button
	public  JFrame frame;
	public JFrame popFrame; //for popup dice roller
	public Boolean popBool; //is one up or not.
	
	/**
	 * Creates UI for Main Menu Page.
	 * Will reuse frame from last page and redraw on it.
	 * Has 3 buttons on it
	 * @param frame
	 */
	public MMP(JFrame frame){
		//start of basic frame setup
		this.frame = frame;
		frame.setResizable(false);
		frame.getContentPane().removeAll();
		
		viewB = new JButton("View Characters");
		ccB = new JButton("Create Character");
		diceB = new JButton("Open Dice Roller");
		
		frame.setTitle("Main Menu");
		frame.setSize(560,670);
		
		JPanel viewBP = new JPanel();
		viewBP.setSize(455,700);
		frame.add(viewBP, BorderLayout.NORTH);
		//view button config
		basicButtonSetup(viewB);
		viewBP.add(viewB);
		
		JPanel ccBP = new JPanel();
		ccBP.setSize(455,700);
		frame.add(ccBP, BorderLayout.CENTER);
		//create character button config
		basicButtonSetup(ccB);
		ccBP.add(ccB);
		
		JPanel diceBP = new JPanel();
		ccBP.setSize(455,700);
		frame.add(diceBP, BorderLayout.SOUTH);
		//Dice Roller button config
		basicButtonSetup(diceB);
		diceBP.add(diceB);
		
		//frame finishing touches
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.repaint();
		frame.revalidate();
		
		popBool = false; //needed to determine whether or not popFrame has been opened
	}
	
	/**
	 * actionlistener will work for this view Characters button
	 * @param listenView
	 */
	public void addViewListener(ActionListener listenView)
	{
		viewB.addActionListener(listenView);
	
	}
	
	/**
	 * actionlistener will work for this Create Characters button
	 * @param listenCreate
	 */
	public void addCCListener(ActionListener listenCreate)
	{
		ccB.addActionListener(listenCreate);
	
	}
	
	/**
	 * actionlistener will work for this Open Dice Roller button
	 * @param listenDice
	 */
	public void addDiceListener(ActionListener listenDice)
	{
		diceB.addActionListener(listenDice);
	
	}
	
	/**
	 * allows for creation of dice roller pop up
	 * User can enter dice and bonus Quantities.
	 * They can roll dice and add them up with a bonus.
	 * They can clear the fields.
	 */
	public void addPopup()
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
		
		Integer list[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		Integer list2[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
		JComboBox<Integer> DDd4 = new JComboBox<>(list); //drop down d4
		JComboBox<Integer> DDd6 = new JComboBox<>(list); //drop down d6
		JComboBox<Integer> DDd8 = new JComboBox<>(list); //drop down d8
		JComboBox<Integer> DDd10 = new JComboBox<>(list); //drop down d10
		JComboBox<Integer> DDd12 = new JComboBox<>(list); //drop down d12
		JComboBox<Integer> DDd20 = new JComboBox<>(list); //drop down d20
		JComboBox<Integer> DDbonus = new JComboBox<>(list2); //drop down bonus
		dicePanel.add(DDd4);dicePanel.add(d4);
		dicePanel.add(DDd6);dicePanel.add(d6);
		dicePanel.add(DDd8);dicePanel.add(d8);
		dicePanel.add(DDd10);dicePanel.add(d10);
		dicePanel.add(DDd12);dicePanel.add(d12);
		dicePanel.add(DDd20);dicePanel.add(d20);
		dicePanel.add(DDbonus);dicePanel.add(bonus);
		
		//display setup
		JPanel displayP = new JPanel();
		displayP.setBorder(new LineBorder(Color.LIGHT_GRAY,3));
		GridLayout subLayout2 = new GridLayout(8,1);
		displayP.setLayout(subLayout2);
		ArrayList<JTextArea> arr = new ArrayList<>();
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
		JButton clearB = new JButton("Clear");
		JButton rollB = new JButton("Roll");
		
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
	 * takes in JButton. Setups up basic appearance
	 * @param b
	 */
	public void basicButtonSetup(JButton b)
	{
		b.setPreferredSize(new Dimension(400, 200));
		b.setOpaque(true);
		b.setBackground(new Color(41, 142, 208));
		b.setForeground(Color.white);
		b.setBorderPainted(false);
		b.setFont(new Font("Arial", Font.BOLD, 40));
	}
	
}
