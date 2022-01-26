package homework.finger;

import java.util.Random;

public class ComputerPlayer extends Player{
		Random rand=new Random();
	 	
		
		public int nextHand() {
			return rand.nextInt(3);
		}
	}
	