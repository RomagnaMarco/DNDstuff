package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
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
	
	private JButton back;
	private JButton cont;
	private JPanel spacer;
	private JPanel navP;
	
	
	
	public CC1P(JFrame frame)
	{
		//redraws frame given by Main Menu.
		this.frame = frame;
		frame.getContentPane().removeAll();
		frame.setTitle("Character Creation - Phase 1");
		frame.setSize(560,670);
		
		back = new JButton("Back");
		cont = new JButton("Continue");
		navP = new JPanel();
		spacer = new JPanel();
		back.setPreferredSize(new Dimension(120, 30));
		cont.setPreferredSize(new Dimension(120, 30));
		spacer.setPreferredSize(new Dimension(250, 30));
		navP.add(back, BorderLayout.LINE_START);
		navP.add(spacer, BorderLayout.CENTER);
		navP.add(cont, BorderLayout.LINE_END);
		
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
