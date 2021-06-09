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
				pointsLeft = new JLabel("0");
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
	 * Takes in row(attribute) and modifies the Ability Scores with points
	 * If there is not enough points, the modification won't happen.
	 * Changes will also reflect with the points left option.
	 * By default, points are currently set at 27. (this may change)
	 * @param row The attribute value. check abScoresArr to see which is which
	 * @param positive to determine whether or not to add or subtract from the score
	 */
	public void ModifyScore(int row, boolean positive)
	{
		int pos = 1;
		if (positive == false)
		{
			pos*= -1;
		}
		int length = abScoresArr.length;
		for(int i = 0; i < length; i++)
		{
			if(row == i)
			{
				if(checkScore(row, positive) == true)
				{
					//finish this
				}
				else
				{
					//nothing happens. insufficient points
				}
			}
		}
	}
	
	/**
	 * Checks if enough points to modify that attribute score for a given attribute
	 * also checks if it doesn't go over  15 or under 8.
	 * @param AbilityScore checks this ability score to see if there enough points
	 * @return if able to modify this attribute
	 */
	public boolean checkScore(int AbilityScore, boolean positive)
	{
		boolean valid = true; //true by default
		
		int pL = getPointsLeft(); //points left
		int attr = getAttribute(AbilityScore); //gets int of ability score currently at
		int pN = getPointsNeeded(attr); // points needed. 1000 for sake of initializing
	
		if (positive == true)
		{
			if(pN > pL) //cannot add when points needed exceed points left
			{
				valid = false;
			}
			if(attr == 15) //cannot add past 15
			{
				valid = false;
			}
		}
		else
		{
			if(attr == 8) //cannot subtract past 8
			{
				valid = false;
			}
		}	
		return valid;
	}
	
	/**
	 * returns integer of attribute score
	 * @param AbilityScore given ability score to get integer from.
	 * @return integer of label value
	 */
	public int getAttribute(int AbilityScore)
	{
		return Integer.parseInt(statCurrArr[AbilityScore].getText()); 
	}
	
	/**
	 * returns value of points needed given the value of the attribute give
	 * @param attr being checked for how points are needed to modify
	 * @return number of points needed to modify attributes
	 */
	public int getPointsNeeded(int attr)
	{
		int pN = 100;
		if(attr == 8)
		{
			pN = 1;
		}
		else if (attr == 9)
		{
			pN = 2;
		}
		else if (attr == 10)
		{
			pN = 3;
		}
		else if (attr == 11)
		{
			pN = 4;
		}
		else if (attr == 12)
		{
			pN = 5;
		}
		else if (attr == 13)
		{
			pN = 7;
		}
		else if (attr == 14)
		{
			pN = 9;
		}//anything else will result in pN being 2 high to afford
		
		return pN;
	}
	
	/**
	 * basic getter method. how many points are left to spend. This number can change
	 * @return num of points left to spend for pointbuy
	 */
	public int getPointsLeft()
	{
		return Integer.parseInt(pointsLeft.getText()); //points left
	}

}
