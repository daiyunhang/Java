package dd_07_03_²ÂÓÎÏ·;

import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {
		System.out.println("1.  ²ÂÊı×Ö");
		System.out.println("2.  ²Â×ÖÄ¸");
		System.out.print("Ñ¡Ôñ£º");
		int c = new Scanner(System.in).nextInt();
		
		GuessGame game = null;
		switch(c) {
		case 1: game = new GuessNumberGame();break;
		case 2: game = new GuessLetterGame();break;
		}
		game.start();
		
		
	}
	
}
