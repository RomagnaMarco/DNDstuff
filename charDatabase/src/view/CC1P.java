package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Character Creation phase 1 Page
 * Part of the View in MVC arch.
 * @author Marco
 *
 */
public class CC1P {

	public JFrame frame;
	
	public JButton back;
	public JButton cont;
	
	
	//redraws frame given by Main Menu
	public CC1P(JFrame frame)
	{
		this.frame = frame;
		frame.getContentPane().removeAll();
		frame.setTitle("Character Creation - Phase 1");
		frame.setSize(560,670);
		
		back = new JButton("Back");
		cont = new JButton("Continue");
		JPanel navP = new JPanel();
		navP.add(back, BorderLayout.WEST);
		navP.add(cont, BorderLayout.EAST);
		
		//main layout 
		JPanel displayP = new JPanel();
		BorderLayout mainL = new BorderLayout();
		displayP.setLayout(mainL);
		displayP.add(navP, BorderLayout.SOUTH);
		
		frame.add(displayP);
		
		
		
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.setVisible(true);
		frame.repaint();
		frame.revalidate();
	}
	
	/**
	 * action listeners work for this back button
	 * @param listenBack
	 */
	public void addBackListener(ActionListener listenBack)
	{
		back.addActionListener(listenBack);
	
	}
	
	public void addContListener(ActionListener listenCont)
	{
		cont.addActionListener(listenCont);
	}
}
