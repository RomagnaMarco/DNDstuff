package controller;

import javax.swing.JFrame;
import view.*;


/**
 * Controller class of MVC arch.
 * @author Marco
 *
 */
public class charController {

		
		private static JFrame frame;
		
		/**
		 * constructor for character controller
		 * @param frame used to draw the pages
		 */
		public charController(JFrame frame) 
		{
			this.frame = frame;
		}
		
		
		public static void main(String[] args) {
			JFrame frame = new JFrame();
			MMP menu = new MMP(frame);
			
			
	}

}
