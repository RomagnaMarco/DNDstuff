package model;

public class PointBuyPage {
	boolean cont = false; // cannot continue by default
						  // need to make sure the points are all spent
	
	int selected = 27; // default point buy starts here
					   // Can change on hitting confirm button after messing
					   // with the JCombo box (drop down)
	int pointsLeft = selected; // points left starts at amt selected
							   // is modified when allocation starts
							   // is modified when a new amt of points is selected.
	
	//Stats/Scores/ Ability Mods default.
	int Str = 8;
	int Dex = 8;
	int Con = 8;
	int Int = 8;
	int Wis = 8;
	int Cha = 8;
	
	//points spent on each. Changes when their respective stat gets lowered or raised.
	int StrPoint = 0;
	int DexPoint = 0;
	int ConPoint = 0;
	int IntPoint = 0;
	int WisPoint = 0;
	int ChaPoint = 0; 
	
}
