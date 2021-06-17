package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Page 0 of Character Creation. Point Buy Option
 * Works off of CCP class extension
 * Part of View in MVC arch
 * @author Marco
 *
 */
public class CCPB extends CCP{
	//super variables
	JButton back;
	JButton cont;
	JPanel spacer;
	JPanel navP;
	JPanel displayP;
	BorderLayout mainL;
	JFrame frame;
	//CCPB variables
	Integer[] dropArr = {27, 28, 29 , 30, 31, 32, 33, 34, 35, 36, 37};
	JButton confirmB;
	JLabel introL;
	JComboBox<Integer> pointDropDown;
	
	JPanel topP;
	BorderLayout topLay;
	
	JPanel subTopP;
	BorderLayout subTopLay;
	
	JPanel centerP;
	GridLayout cL;
	
	JLabel pointsLeft; 
	JPanel[] rowArr;
	GridLayout[] layoutArr;
	JButton[] plusArr;
	JButton[] minusArr;
	JLabel[] statCurrArr;
	JLabel[] statCostArr;
	JLabel[] ScoreLabelArr;
	String[] abScoresArr = {"STR", "DEX", "CON", "INT", "WIS", "CHA"};
	
	/**
	 * Borrows from CCP template.
	 * @param frame re-used from old frames
	 */
	public CCPB(JFrame frame) 
	{
		super(frame);
		setupFrame();
		frame.setTitle("Character Creation - Phase 0");
		
		setupNavP();
		setupMainL();
		
		
	
		displayP = super.getDisplayP(); //initialize
		
		//Top portion
		topP = new JPanel();
		topLay = new BorderLayout();
		topP.setLayout(topLay);
		
		//setup
		introL = new JLabel(" Choose the # of points for your Character. Then hit Confirm.");
		confirmB = new JButton("Confirm");
		pointDropDown = new JComboBox<Integer>(dropArr);
		pointDropDown.setEditable(false);
		introL.setPreferredSize(new Dimension(100, 40));
		confirmB.setPreferredSize(new Dimension(100, 30));
		pointDropDown.setPreferredSize(new Dimension(60, 30));
		
		//top sub panel
		subTopP = new JPanel();
		subTopLay = new BorderLayout();
		subTopP.setLayout(subTopLay);
		subTopP.add(pointDropDown, BorderLayout.CENTER);
		subTopP.add(confirmB, BorderLayout.EAST);
		
		topP.add(introL, BorderLayout.NORTH);
		topP.add(subTopP, BorderLayout.EAST);
		//center portion
		
		centerP = new JPanel();
		cL = new GridLayout(8,3); //center layout
		centerP.setLayout(cL);
		cL.setColumns(1);
		
		//pointBuy main section
		
		int bc = 6; //button count
		int rc = bc +2; //row count
		rowArr = new JPanel[rc]; //2 rows more than buttons
		layoutArr = new GridLayout[rc];//2 more layouts than buttons
		plusArr = new JButton[bc];
		minusArr = new JButton[bc];
		statCurrArr = new JLabel[bc];
		statCostArr = new JLabel[bc];
		ScoreLabelArr = new JLabel[bc];
		for(int i = 0; i < rc; i++) //adds rows of Jpanels that contain the PointBuy UI for each stat. 
		{
			
			if(i == 0) //first row
			{
				//main Panels
				rowArr[i] = new JPanel();
				layoutArr[i] = new GridLayout();
				rowArr[i].setLayout(layoutArr[i]);
				
				JLabel scoreLabel = new JLabel("Ability Scores");
				JLabel addLabel = new JLabel("Add Points");
				JLabel subtractLabel = new JLabel("Subtract Points");
				JLabel currScoreLabel = new JLabel("Current Scores");
				JLabel descriptionLabel = new JLabel("Points Allocated");
				
				//center all labels
				descriptionLabel.setHorizontalAlignment(JLabel.CENTER);
				scoreLabel.setHorizontalAlignment(JLabel.CENTER);
				currScoreLabel.setHorizontalAlignment(JLabel.CENTER);
				addLabel.setHorizontalAlignment(JLabel.CENTER);
				subtractLabel.setHorizontalAlignment(JLabel.CENTER);
				
				rowArr[i].add(scoreLabel);
				rowArr[i].add(subtractLabel);
				rowArr[i].add(addLabel);
				rowArr[i].add(currScoreLabel);
				rowArr[i].add(descriptionLabel);
				
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
				plusArr[ai] = new JButton("-");
				minusArr[ai] = new JButton("+");
				statCurrArr[ai] = new JLabel("8");
				statCostArr[ai] = new JLabel("0");
				
				//adjust text on labels and buttons. Bold and centered
				plusArr[ai].setFont(plusArr[ai].getFont().deriveFont(Font.BOLD, 20f));
				minusArr[ai].setFont(plusArr[ai].getFont().deriveFont(Font.BOLD, 20f));
				statCurrArr[ai].setFont(statCurrArr[ai].getFont().deriveFont(Font.BOLD, 14f));
				statCostArr[ai].setFont(statCostArr[ai].getFont().deriveFont(Font.BOLD, 14f));
				statCurrArr[ai].setHorizontalAlignment(JLabel.CENTER);
				statCostArr[ai].setHorizontalAlignment(JLabel.CENTER);
				
				//handle label
				ScoreLabelArr[ai] = new JLabel("");
				ScoreLabelArr[ai].setText(abScoresArr[ai]);
				ScoreLabelArr[ai].setFont(ScoreLabelArr[ai].getFont().deriveFont(Font.BOLD, 28f));
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
				JLabel points = new JLabel("Points Left: "); //spacer
				
				//handle center alignment for label
				pointsLeft = new JLabel("27");
				pointsLeft.setHorizontalAlignment(JLabel.CENTER);
				points.setHorizontalAlignment(JLabel.CENTER);
				
				//add components to row
				rowArr[i].add(s1);
				rowArr[i].add(s2);
				rowArr[i].add(s3);
				rowArr[i].add(points);
				rowArr[i].add(pointsLeft);
				
				centerP.add(rowArr[i]);
			}
			
		}
		
		displayP.add(topP, BorderLayout.NORTH);
		displayP.add(centerP, BorderLayout.CENTER);
		
		setupFinalize();
		
	}
	
	/**
	 * basic getter method. how many points are left to spend. This number can change
	 * @return num of points left to spend for pointbuy
	 */
	public int getPointsLeft() //will need to be changed later. leaving this here for now.
	{
		return Integer.parseInt(pointsLeft.getText()); //points left
	}

}
