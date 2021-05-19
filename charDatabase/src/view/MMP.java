package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SpringLayout;

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
		
		popBool = false;
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
		//dropdown setup
		Label d4, d6, d8, d10, d12, d20, bonus; // input for textPane of each dice/bonus
		d4 = new Label("d4");
		d6 = new Label("d6");
		d8 = new Label("d8");
		d10 = new Label("d10");
		d12 = new Label("d12");
		d20 =  new Label("d20");
		bonus = new Label("Bonus");
		
		 Integer list[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		JComboBox<Integer> DDd4 = new JComboBox<>(list); //drop down d4
		JComboBox<Integer> DDd6 = new JComboBox<>(list); //drop down d6
		JComboBox<Integer> DDd8 = new JComboBox<>(list); //drop down d8
		JComboBox<Integer> DDd10 = new JComboBox<>(list); //drop down d10
		JComboBox<Integer> DDd12 = new JComboBox<>(list); //drop down d12
		JComboBox<Integer> DDd20 = new JComboBox<>(list); //drop down d20
		JComboBox<Integer> DDbonus = new JComboBox<>(list); //drop down bonus
		
		//pop up setup
		popBool = true; // for hiding and closing condition
		
		popFrame = new JFrame("Dice Roller"); //opens frame diceRoller
		GridBagLayout layout = new GridBagLayout();
		popFrame.setLayout(layout); //sets layout of frame to grid bag layout
		
		JLayeredPane popup = new JLayeredPane();
		popFrame.getContentPane().add(popup);
		popFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		//setup constraints for layout
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.ipadx = 90;
		gbc.ipady = 10;
		
		
		//Layout x = 0
		//1d4
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.BOTH;
		popFrame.add(DDd4, gbc);
		//1d6
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.BOTH;
		popFrame.add(DDd6, gbc);
		//1d8
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.BOTH;
		popFrame.add(DDd8, gbc);
		//1d10
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.BOTH;
		popFrame.add(DDd10, gbc);
		//1d12
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.BOTH;
		popFrame.add(DDd12, gbc);
		//1d20
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.BOTH;
		popFrame.add(DDd20, gbc);
		//iBonus
		gbc.gridx = 0;
		gbc.gridy = 6;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.BOTH;
		popFrame.add(DDbonus, gbc);
		
		// Layout x = 1
		//1d4
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridheight = 1;
		gbc.gridwidth = 5;
		gbc.fill = GridBagConstraints.BOTH;
		popFrame.add(d4, gbc);
		//1d6
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.BOTH;
		popFrame.add(d6, gbc);
		//1d8
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.BOTH;
		popFrame.add(d8, gbc);
		//1d10
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.BOTH;
		popFrame.add(d10, gbc);
		//1d12
		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.BOTH;
		popFrame.add(d12, gbc);
		//1d20
		gbc.gridx = 1;
		gbc.gridy = 5;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.BOTH;
		popFrame.add(d20, gbc);
		//iBonus
		gbc.gridx = 1;
		gbc.gridy = 6;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.BOTH;
		popFrame.add(bonus, gbc);
				
		popFrame.setSize(700,400);
		popFrame.setVisible(true);
	}
	
}
