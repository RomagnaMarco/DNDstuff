package view;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Page 0 of Character Creation. Manual Select Option
 * Works off of CCP class extension
 * Part of View in MVC arch
 * @author Marco
 *
 */
public class CCMS extends CCP{
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
	public CCMS(JFrame frame) 
	{
		super(frame);
		setupFrame();
		setupNavP();
		setupMainL();
		setupFinalize();
		frame.setTitle("Character Creation - Phase 0");
	}
	

}