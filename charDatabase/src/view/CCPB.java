package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

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
				plusArr[ai] = new JButton("+");
				minusArr[ai] = new JButton("-");
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
				rowArr[i].add(minusArr[ai]);
				rowArr[i].add(plusArr[ai]);
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
	 * Shows new pointsLeft in view to reflect the change also happening in the model
	 * 
	 * @param pointsLeftModel points left stored in the model
	 */
	public void modifyPointsLeft(int pointsLeftModel)
	{
		String value = Integer.toString(pointsLeftModel);
		pointsLeft.setText(value); //points left
	}

	/**
	 * Modifies Attribute shown in view (up or down 1 value)
	 * @param attrName name of Attribute to modify
	 * @param modValue the value by which statsCurrArr[attrIndex] changes
	 */
	public void modifyAttribute(String attrName,Integer modValue)
	{
		int attrIndex = findArrIndexWithAttrAbbreviation(attrName);
		String newValue = Integer.toString(modValue);
		statCurrArr[attrIndex].setText(newValue);
	}

	/**
	 * Modifies amount of pointsAllocated shown in view
	 * @param attrName name of Attribute to modify
	 * @param modValue the amount of points to change in statCostArr[attrIndex] by
	 */
	public void modifyPointsAllocated(String attrName, Integer modValue)
	{
		int attrIndex = findArrIndexWithAttrAbbreviation(attrName);
		String newValue = Integer.toString(modValue);
		statCostArr[attrIndex].setText(newValue);
	}
	
	/**
	 * Given an fixed String that represents the name of an attribute, spits out the index in the arrs in view
	 * Usable on several Arrays in CCPB since the attributes of the arrays all align
	 * @param attrName name of Attribute. 3 letter abbreviation format in caps
	 */
	public int findArrIndexWithAttrAbbreviation(String attrName)
	{
		int desiredIndex = 100; //purposely out of bounds by default
		
		if(attrName.equals("STR"))
		{
			desiredIndex = 0;
		}
		else if (attrName.equals("DEX"))
		{
			desiredIndex = 1;
		}
		else if (attrName.equals("CON"))
		{
			desiredIndex = 2;
		}
		else if (attrName.equals("INT"))
		{
			desiredIndex = 3;
		}
		else if (attrName.equals("WIS"))
		{
			desiredIndex = 4;
		}
		else if (attrName.equals("CHA"))
		{
			desiredIndex = 5;
		}
		else
		{
			System.out.println("An Error has occurred in the findArrIndexWithAttrAbbreviation() method. Check inputed String, it does not match the presets.");
		}
		if(desiredIndex == 100)
		{
			System.out.println("desiredIndex in method findArrIndexWithAttrAbbreviation() is still at default. In class CCPB (part of view).");
		}
		return desiredIndex;
	}
	
	/**
	 * getter for confirm Button in CCPB
	 * @return
	 */
	public JButton getConfirmB()
	{
		return confirmB;
	}
	
	/**
	 * a getter for the plus buttons in CCPB
	 * @return
	 */
	public JButton[] getPlusArr()
	{
		return plusArr;
	}
	
	/**
	 * a getter for the minus buttons in CCPB
	 * @return
	 */
	public JButton[] getMinusArr()
	{
		return minusArr;
	}
	
	/**
	 * action listener will work for this plus STR button
	 * @param listenPlusSTR
	 */
	public void addPlusSTRListener(ActionListener listenPlusSTR)
	{
		plusArr[0].addActionListener(listenPlusSTR);
	}
	
	/**
	 * action listener will work for this plus DEX button
	 * @param listenPlusDEX
	 */
	public void addPlusDEXListener(ActionListener listenPlusDEX)
	{
		plusArr[1].addActionListener(listenPlusDEX);
	}
	
	/**
	 * action listener will work for this plus CON button
	 * @param listenPlusCON
	 */
	public void addPlusCONListener(ActionListener listenPlusCON)
	{
		plusArr[2].addActionListener(listenPlusCON);
	}
	
	/**
	 * action listener will work for this plus INT button
	 * @param listenPlusINT
	 */
	public void addPlusINTListener(ActionListener listenPlusINT)
	{
		plusArr[3].addActionListener(listenPlusINT);
	}
	
	/**
	 * action listener will work for this plus WIS button
	 * @param listenPlusWIS
	 */
	public void addPlusWISListener(ActionListener listenPlusWIS)
	{
		plusArr[4].addActionListener(listenPlusWIS);
	}
	
	/**
	 * action listener will work for this plus CHA button
	 * @param listenPlusCHA
	 */
	public void addPlusCHAListener(ActionListener listenPlusCHA)
	{
		plusArr[5].addActionListener(listenPlusCHA);
	}
	
	/**
	 * action listener will work for this Minus STR button
	 * @param listenMinusSTR
	 */
	public void addMinusSTRListener(ActionListener listenMinusSTR)
	{
		minusArr[0].addActionListener(listenMinusSTR);
	}
	
	/**
	 * action listener will work for this Minus DEX button
	 * @param listenMinusDEX
	 */
	public void addMinusDEXListener(ActionListener listenMinusDEX)
	{
		minusArr[1].addActionListener(listenMinusDEX);
	}
	
	/**
	 * action listener will work for this Minus CON button
	 * @param listenMinusCON
	 */
	public void addMinusCONListener(ActionListener listenMinusCON)
	{
		minusArr[2].addActionListener(listenMinusCON);
	}
	
	/**
	 * action listener will work for this Minus INT button
	 * @param listenMinusINT
	 */
	public void addMinusINTListener(ActionListener listenMinusINT)
	{
		minusArr[3].addActionListener(listenMinusINT);
	}
	
	/**
	 * action listener will work for this Minus WIS button
	 * @param listenMinusWIS
	 */
	public void addMinusWISListener(ActionListener listenMinusWIS)
	{
		minusArr[4].addActionListener(listenMinusWIS);
	}
	
	/**
	 * action listener will work for this Minus CHA button
	 * @param listenMinusCHA
	 */
	public void addMinusCHAListener(ActionListener listenMinusCHA)
	{
		minusArr[5].addActionListener(listenMinusCHA);
	}
	
	/**
	 * action listener will work for this confirm button
	 * @param listenConfirm
	 */
	public void addConfirmListener(ActionListener listenConfirm)
	{
		confirmB.addActionListener(listenConfirm);
	}
}
