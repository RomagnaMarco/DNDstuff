package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Page 1 of Character Creation.
 * Works off of CCP class extension
 * Part of View in MVC arch
 * @author Marco
 *
 */
public class CC1P extends CCP{
	JButton back;
	JButton cont;
	JPanel spacer;
	JPanel navP;
	JPanel displayP;
	BorderLayout mainL;
	JFrame frame;
	
	/**
	 * Borrows from CCP template.
	 * @param frame
	 */
	public CC1P(JFrame frame) 
	{
		super(frame);
		setupFrame();
		frame.setTitle("Character Creation - Phase 1");
		
		setupNavP();
		setupMainL();
		//Center section dealt with.
		displayP = super.getDisplayP(); //initialize
		
		JButton setRoll = new JButton("Roll Sets");
		setRoll.setPreferredSize(new Dimension(120, 40));
		JPanel centerP = new JPanel();
		GridLayout buttonTop = new GridLayout();
		centerP.setLayout(buttonTop);
		centerP.add(setRoll);
		
		displayP.add(centerP, BorderLayout.CENTER);
		
		setupFinalize();
		
	}
	

}
