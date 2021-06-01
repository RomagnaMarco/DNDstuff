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
	 * @param frame re-used from old frames
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
		JButton manSelect = new JButton("Enter Manually");
		JButton pointBuy = new JButton("Point Buy");
		setRoll.setPreferredSize(new Dimension(40, 60));
		manSelect.setPreferredSize(new Dimension(40, 60));
		JPanel topP = new JPanel();
		GridLayout buttonTop = new GridLayout();
		//set gaps between buttons for spacing
		buttonTop.setHgap(15);
		//add components to top Panel
		topP.setLayout(buttonTop);
		topP.add(setRoll);
		topP.add(pointBuy);
		topP.add(manSelect);
		
		displayP.add(topP, BorderLayout.NORTH);
		
		setupFinalize();
		
	}
	

}
