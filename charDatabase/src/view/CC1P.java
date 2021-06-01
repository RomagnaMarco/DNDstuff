package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
		
		//Top portion
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
		
		//center portion
		
		JPanel centerP = new JPanel();
		GridLayout cL = new GridLayout(6, 1); //center layout
		centerP.setLayout(cL);
		
		//pointBuy section
		
		int bc = 6; //button count
		JPanel[] rowArr = new JPanel[bc];
		GridLayout[] layoutArr = new GridLayout[bc];
		JButton[] plusArr = new JButton[bc];
		JButton[] minusArr = new JButton[bc];
		JLabel[] labelArr = new JLabel[bc];
		for(int i = 0; i < bc; i++)
		{
			rowArr[i] = new JPanel();
			layoutArr[i] = new GridLayout();
			rowArr[i].setLayout(layoutArr[i]);
			plusArr[i] = new JButton("+");
			minusArr[i] = new JButton("-");
			labelArr[i] = new JLabel("8");
			labelArr[i].setFont(labelArr[i].getFont().deriveFont(Font.BOLD, 14f));
			labelArr[i].setHorizontalAlignment(JLabel.CENTER);
			rowArr[i].add(plusArr[i]);
			rowArr[i].add(minusArr[i]);
			rowArr[i].add(labelArr[i]);
			centerP.add(rowArr[i]);
		}
		
		
		displayP.add(topP, BorderLayout.NORTH);
		displayP.add(centerP, BorderLayout.CENTER);
		
		setupFinalize();
		
	}
	

}
