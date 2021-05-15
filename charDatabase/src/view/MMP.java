package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

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
	private JFrame frame;
	
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
		viewB.setPreferredSize(new Dimension(400, 200));
		viewB.setOpaque(true);
		viewB.setBackground(new Color(41, 142, 208));
		viewB.setForeground(Color.white);
		viewB.setBorderPainted(false);
		viewB.setFont(new Font("Arial", Font.BOLD, 40));
		viewBP.add(viewB);
		
		JPanel ccBP = new JPanel();
		ccBP.setSize(455,700);
		frame.add(ccBP, BorderLayout.CENTER);
		//create character button config
		ccB.setPreferredSize(new Dimension(400, 200));
		ccB.setOpaque(true);
		ccB.setBackground(new Color(41, 142, 208));
		ccB.setForeground(Color.white);
		ccB.setBorderPainted(false);
		ccB.setFont(new Font("Arial", Font.BOLD, 40));
		ccBP.add(ccB);
		
		JPanel diceBP = new JPanel();
		ccBP.setSize(455,700);
		frame.add(diceBP, BorderLayout.SOUTH);
		//Dice Roller button config
		diceB.setPreferredSize(new Dimension(400, 200));
		diceB.setOpaque(true);
		diceB.setBackground(new Color(41, 142, 208));
		diceB.setForeground(Color.white);
		diceB.setBorderPainted(false);
		diceB.setFont(new Font("Arial", Font.BOLD, 40));
		diceBP.add(diceB);
		
		//frame finishing touches
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.repaint();
		frame.revalidate();
		
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
	
}
