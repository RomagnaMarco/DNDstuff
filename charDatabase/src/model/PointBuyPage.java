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
		StrPoint = 0;
		DexPoint = 0;
		ConPoint = 0;
		IntPoint = 0;
		WisPoint = 0;
		ChaPoint = 0; 
	}

	/**
	 * returns value of points needed for the value of the attribute given
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
