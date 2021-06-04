package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

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
		GridLayout cL = new GridLayout(9,3); //center layout
		centerP.setLayout(cL);
		cL.setColumns(1);
		
		//pointBuy section
		
		int bc = 6; //button count
		int rc = bc +2; //row count
		JLabel pointsLeft; 
		JPanel[] rowArr = new JPanel[rc]; //2 rows more than buttons
		GridLayout[] layoutArr = new GridLayout[rc];//2 more layouts than buttons
		JButton[] plusArr = new JButton[bc];
		JButton[] minusArr = new JButton[bc];
		JLabel[] statCurrArr = new JLabel[bc];
		JLabel[] statCostArr = new JLabel[bc];
		JLabel[] ScoreLabelArr = new JLabel[bc];
		String[] abScoresArr = {"STR", "DEX", "CON", "INT", "WIS", "CHA"};
		for(int i = 0; i < rc; i++) //adds rows of Jpanels that contain the PointBuy UI for each stat. 
		{
			
			if(i == 0) //first row
			{
				rowArr[i] = new JPanel();
				layoutArr[i] = new GridLayout();
				rowArr[i].setLayout(layoutArr[i]);
				
				JLabel ScoreLabel = new JLabel("Ability Scores");
				JLabel addLabel = new JLabel("Add Points");
				JLabel subtractLabel = new JLabel("Subtract Points");
				JLabel currScoreLabel = new JLabel("Current Scores");
				JTextArea pointsAllocated = new JTextArea();
				
				//center labels
				ScoreLabel.setHorizontalAlignment(JLabel.CENTER);
				currScoreLabel.setHorizontalAlignment(JLabel.CENTER);
				addLabel.setHorizontalAlignment(JLabel.CENTER);
				subtractLabel.setHorizontalAlignment(JLabel.CENTER);
				
				rowArr[i].add(ScoreLabel);
				rowArr[i].add(addLabel);
				rowArr[i].add(subtractLabel);
				rowArr[i].add(currScoreLabel);
				rowArr[i].add(pointsAllocated);
				
				centerP.add(rowArr[i]);
			}
			if (i != 0 && i != rc-1) //middle 6 rows
			{
				int ai = i - 1; //adjust index.
				//use ai for 
				//plusArr, minusArr, statCurrArr, statCostArr
				
				rowArr[i] = new JPanel();
				layoutArr[i] = new GridLayout();
				rowArr[i].setLayout(layoutArr[i]);
				
				//create buttons
				plusArr[ai] = new JButton("+");
				minusArr[ai] = new JButton("-");
				statCurrArr[ai] = new JLabel("8");
				statCostArr[ai] = new JLabel("0");
				
				//adjust text on labels. Bold and centered
				statCurrArr[ai].setFont(statCurrArr[ai].getFont().deriveFont(Font.BOLD, 14f));
				statCostArr[ai].setFont(statCostArr[ai].getFont().deriveFont(Font.BOLD, 14f));
				statCurrArr[ai].setHorizontalAlignment(JLabel.CENTER);
				statCostArr[ai].setHorizontalAlignment(JLabel.CENTER);
				
				//handle label
				ScoreLabelArr[ai] = new JLabel("");
				ScoreLabelArr[ai].setText(abScoresArr[ai]);
				ScoreLabelArr[ai].setHorizontalAlignment(JLabel.CENTER);
				
				//add components to row
				rowArr[i].add(ScoreLabelArr[ai]);
				rowArr[i].add(plusArr[ai]);
				rowArr[i].add(minusArr[ai]);
				rowArr[i].add(statCurrArr[ai]);
				rowArr[i].add(statCostArr[ai]);
				
				//add rows to center panel
				centerP.add(rowArr[i]);
				
				
			}
			if(i == bc+1) //first row
			{
				rowArr[i] = new JPanel();
				layoutArr[i] = new GridLayout();
				rowArr[i].setLayout(layoutArr[i]);
				
				JLabel s1 = new JLabel(); //spacer
				JLabel s2 = new JLabel(); //spacer
				JLabel s3 = new JLabel(); //spacer
				JLabel s4 = new JLabel(); //spacer
				
				//handle center alignment for label
				pointsLeft = new JLabel("0 points Left");
				pointsLeft.setHorizontalAlignment(JLabel.CENTER);
				
				//add components to row
				rowArr[i].add(s1);
				rowArr[i].add(s2);
				rowArr[i].add(s3);
				rowArr[i].add(s4);
				rowArr[i].add(pointsLeft);
				
				
				centerP.add(rowArr[i]);
			}
			
		}
		
		displayP.add(topP, BorderLayout.NORTH);
		displayP.add(centerP, BorderLayout.CENTER);
		
		setupFinalize();
		
	}
	

}
