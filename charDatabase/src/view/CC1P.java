package view;

import java.awt.BorderLayout;

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
	
	/**
	 * Borrows from CCP template.
	 * @param frame
	 */
	public CC1P(JFrame frame) 
	{
		super(frame);
		setupFrame();
		setupNavP();
		setupMainL();
		setupFinalize();
		frame.setTitle("Character Creation - Phase 1");
	}
	

}