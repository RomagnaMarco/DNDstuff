package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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
 * Main Menu Page.
 * Initial page you start on.
 * Part of View in MVC arch.
 * @author Marco
 *
 */
public class MMP {
	private JButton viewB; //view character button
	private JButton diceB; //dice page button
	public  JFrame frame;
	public Boolean popBool; //is DRP up or not.
	public JPanel ccP; //panel for char creation
	private JButton setRollB; //takes to char creation with set method
	private JButton manSelectB; //takes to char creation with manual selection method
	private JButton pointBuyB; //takes to char creation with point buy method.
	
	
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
		
		frame.setTitle("Main Menu");
		frame.setSize(580,670);
		
		//setup view Button
		viewB = new JButton("View Characters");
		JPanel viewBP = new JPanel();
		frame.add(viewBP, BorderLayout.NORTH);
		//view button config
		basicButtonSetup(viewB);
		viewBP.add(viewB);
		
		//char creation panel setup
		ccP = new JPanel();
		setRollB = new JButton("Roll Sets");
		manSelectB = new JButton("Enter Manually");
		pointBuyB = new JButton("Point Buy");
		//Char Creation buttons config
		basicButtonSetup(setRollB);
		basicButtonSetup(manSelectB);
		basicButtonSetup(pointBuyB);
		GridLayout ccLay = new GridLayout();
		ccP.setLayout(ccLay);
		//set gaps between buttons for spacing
		ccLay.setHgap(15);
		//add components to ccP
		ccP.add(setRollB);
		ccP.add(pointBuyB);
		ccP.add(manSelectB);		
		frame.add(ccP, BorderLayout.CENTER);
		
		//setup dice button
		diceB = new JButton("Open Dice Roller");
		JPanel diceBP = new JPanel();
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
	 * actionlistener will work for this pointBuy button
	 * @param listenCreateBP
	 */
	public void addPBListener(ActionListener listenCreateBP)
	{
		pointBuyB.addActionListener(listenCreateBP);
	
	}
	
	/**
	 * actionlistener will work for this manual Select button
	 * @param listenCreateMS
	 */
	public void addMSListener(ActionListener listenCreateMS)
	{
		manSelectB.addActionListener(listenCreateMS);
	
	}
	
	/**
	 * actionlistener will work for this setRoll button
	 * @param listenCreateSR
	 */
	public void addSRListener(ActionListener listenCreateSR)
	{
		setRollB.addActionListener(listenCreateSR);
	
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
		
	}
	
	/**
	 * takes in JButton. Setups up basic appearance
	 * @param b
	 */
	public void basicButtonSetup(JButton b)
	{
		b.setPreferredSize(new Dimension(300, 250));
		b.setOpaque(true);
		b.setBackground(new Color(41, 142, 208));
		b.setForeground(Color.white);
		b.setBorderPainted(false);
		b.setFont(new Font("Arial", Font.BOLD, 20));
	}
	
	
}
