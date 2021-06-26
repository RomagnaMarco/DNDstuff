package model;

public class PointBuyPage {
	
	private boolean cont;
	private int selected;
	private int pointsLeft;
	
	private int Str;
	private int Dex;
	private int Con;
	private int Int;
	private int Wis;
	private int Cha;
	
	private int StrPoint;
	private int DexPoint;
	private int ConPoint;
	private int IntPoint;
	private int WisPoint;
	private int ChaPoint;
	
	
	public PointBuyPage()
	{

		cont = false; // cannot continue by default
							  // need to make sure the points are all spent
		
		selected = 27; // default point buy starts here
						   // Can change on hitting confirm button after messing
						   // with the JCombo box (drop down)
		
		pointsLeft = selected; // points left starts at amount selected
							   // is modified when allocation starts
							   // is modified when a new amount of points is selected.
		
		//Stats / Scores / Ability Modifiers /Attributes default.
		Str = 8;
		Dex = 8;
		Con = 8;
		Int = 8;
		Wis = 8;
		Cha = 8;
		
		//points spent on each. Changes when their respective stat gets lowered or raised.
		//aka pointsAllocated in CCPB
		StrPoint = 0;
		DexPoint = 0;
		ConPoint = 0;
		IntPoint = 0;
		WisPoint = 0;
		ChaPoint = 0;
		
	}

	/**
	 * returns value of points needed for the value of the attribute given
	 * default value returned is 1000, for when a range problem occur
	 * @param attr being checked for how points are needed to modify
	 * @param positive needs to know if subtracting or adding
	 * @return number of points needed to modify attributes
	 */
	public int getPointsNeeded(int attr, boolean positive)
	{
		int pN = 1000;
		if(positive == true) //adding up
		{
			if(attr > 7 && attr < 14) // 9 to 13
			{
				pN = 1;
			}
			else //attr == 15 || attr == 14
			{
				pN = 2;
			}
		}
		else //subtracting down
		{
			if(attr > 7 && attr < 15) // 9 to 13
			{
				pN = 1;
			}
			else //attr == 15
			{
				pN = 2;
			}	
		}
		
		return pN;
	}
	
	/**
	 * For PointBuy Page in Model. 
	 * @return if can continue away from this page via button push
	 */
	public boolean isCont() {
		return cont;
	}

	/**
	 * For PointBuy Page in Model. 
	 * @param cont new boolean value for if you can continue
	 */
	public void setCont(boolean cont) {
		this.cont = cont;
	}

	/**
	 * For PointBuy Page in Model.
	 * @return value selected by drop Down in CCPB (View)
	 */
	public int getSelected() {
		return selected;
	}

	/**
	 * For PointBuy Page in Model. 
	 * Should be Accompanied by a change to the PointsLeft in both view and model
	 * @param selected Upon selection of new value in the drop down menu in CCPB (view)
	 */
	public void setSelected(int selected) {
		this.selected = selected;
	}
	
	/**
	 * For PointBuy Page in Model.
	 * @return how many left the user has to spend on stats
	 */
	public int getPointsLeft() {
		return pointsLeft;
	}

	/**
	 * For PointBuy Page in Model.
	 * @param pointsLeft changes the amount of points left to a certain Amount
	 */
	public void setPointsLeft(int pointsLeft) {
		this.pointsLeft = pointsLeft;
	}

	/**
	 * gets int value of attr based on Fixed String entered. must match accordingly
	 * @param attrName name of Attribute. 3 letter abbreviation format in caps
	 * @return
	 */
	public int getAttribute(String attrName)
	{
		int desiredValue = 100; //set to 100 be default.
		if(attrName.equals("STR"))
		{
			desiredValue = getStr();
		}
		else if (attrName.equals("DEX"))
		{
			desiredValue = getDex();
		}
		else if (attrName.equals("CON"))
		{
			desiredValue = getCon();
		}
		else if (attrName.equals("INT"))
		{
			desiredValue = getInt();
		}
		else if (attrName.equals("WIS"))
		{
			desiredValue = getWis();
		}
		else if (attrName.equals("CHA"))
		{
			desiredValue = getCha();
		}
		else
		{
			System.out.println("An Error has occurred in the getAttribute() method. Check inputed String, it does not match the presets.");
		}
		if(desiredValue == 100)
		{
			System.out.println("desiredValue in method getAttribute() is still at default. In class PointBuyPage (part of model).");
		}
		return desiredValue;
	}
	
	/**
	 * gets int value of attr's points allocated based on Fixed String entered. must match accordingly
	 * @param attrName name of Attribute. 3 letter abbreviation format in caps
	 * @return
	 */
	public int getAttributePoints(String attrName)
	{
		int desiredValue = 100; //set to 100 be default.
		if(attrName.equals("STR"))
		{
			desiredValue = getStrPoint();
		}
		else if (attrName.equals("DEX"))
		{
			desiredValue = getDexPoint();
		}
		else if (attrName.equals("CON"))
		{
			desiredValue = getConPoint();
		}
		else if (attrName.equals("INT"))
		{
			desiredValue = getIntPoint();
		}
		else if (attrName.equals("WIS"))
		{
			desiredValue = getWisPoint();
		}
		else if (attrName.equals("CHA"))
		{
			desiredValue = getChaPoint();
		}
		else
		{
			System.out.println("An Error has occurred in the getAttributePoints() method. Check inputed String, it does not match the presets.");
		}
		if(desiredValue == 100)
		{
			System.out.println("desiredValue in method getAttributePoints() is still at default. In class PointBuyPage (part of model).");
		}
		return desiredValue;
	}
	
	/**
	 * takes in fixed String of Attribute's name and changes the respective attributes points allocated value in model
	 * @param attrName name of attribute. 3 letter abbreviation format in caps
	 * @param newValue value being set to for the attribute's points
	 */
	public void setAttributePoints(String attrName, int newValue)
	{
		
		if(attrName.equals("STR"))
		{
			 setStrPoint(newValue);
		}
		else if (attrName.equals("DEX"))
		{
			setDexPoint(newValue);
		}
		else if (attrName.equals("CON"))
		{
			setConPoint(newValue);
		}
		else if (attrName.equals("INT"))
		{
			setIntPoint(newValue);
		}
		else if (attrName.equals("WIS"))
		{
			setWisPoint(newValue);
		}
		else if (attrName.equals("CHA"))
		{
			setChaPoint(newValue);
		}
		else
		{
			System.out.println("An Error has occurred in the setAttributePoints() method. Check inputed String, it does not match the presets.");
		}
		
	}
	
	/**
	 * takes in fixed String of Attribute's name and changes the respective attribute value in the model
	 * @param attrName name of attribute. 3 letter abbreviation format in caps
	 * @param newValue value being set to for the attribute
	 */
	public void setAttribute(String attrName, int newValue)
	{
		
		if(attrName.equals("STR"))
		{
			 setStr(newValue);
		}
		else if (attrName.equals("DEX"))
		{
			setDex(newValue);
		}
		else if (attrName.equals("CON"))
		{
			setCon(newValue);
		}
		else if (attrName.equals("INT"))
		{
			setInt(newValue);
		}
		else if (attrName.equals("WIS"))
		{
			setWis(newValue);
		}
		else if (attrName.equals("CHA"))
		{
			setCha(newValue);
		}
		else
		{
			System.out.println("An Error has occurred in the setAttributePoints() method. Check inputed String, it does not match the presets.");
		}
		
	}
	
	public int getStr() {
		return Str;
	}

	
	public void setStr(int str) {
		Str = str;
	}

	public int getDex() {
		return Dex;
	}

	public void setDex(int dex) {
		Dex = dex;
	}

	public int getCon() {
		return Con;
	}

	public void setCon(int con) {
		Con = con;
	}

	public int getInt() {
		return Int;
	}

	public void setInt(int i) {
		Int = i;
	}

	public int getWis() {
		return Wis;
	}

	public void setWis(int wis) {
		Wis = wis;
	}

	public int getCha() {
		return Cha;
	}

	public void setCha(int cha) {
		Cha = cha;
	}

	public int getStrPoint() {
		return StrPoint;
	}

	public void setStrPoint(int strPoint) {
		StrPoint = strPoint;
	}

	public int getDexPoint() {
		return DexPoint;
	}

	public void setDexPoint(int dexPoint) {
		DexPoint = dexPoint;
	}

	public int getConPoint() {
		return ConPoint;
	}

	public void setConPoint(int conPoint) {
		ConPoint = conPoint;
	}

	public int getIntPoint() {
		return IntPoint;
	}

	public void setIntPoint(int intPoint) {
		IntPoint = intPoint;
	}

	public int getWisPoint() {
		return WisPoint;
	}

	public void setWisPoint(int wisPoint) {
		WisPoint = wisPoint;
	}

	public int getChaPoint() {
		return ChaPoint;
	}

	public void setChaPoint(int chaPoint) {
		ChaPoint = chaPoint;
	}
	
}
