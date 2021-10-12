package nms.questions;

import java.util.Scanner;

public class QuerstionNumber8 {
	public static void main(String[] args) {
		String shuffle[] = new String[]
		        {
		            "fferbu" , "loaft" , "ritsng", "bbleduo"
		        } ;
		        
		String answer[] = new String[]
		        {
		            "buffer" , "float" , "string", "doubble"
		        } ;
		Scanner sc = new Scanner(System.in);
		int score = 0;
		System.out.println("Lets start the game: ");
		for(int i = 0; i < shuffle.length; i++) {
			System.out.println("Guess the right word:........");
			System.out.println("Shuffeled word is: " + shuffle[i]);
			String ans = sc.next();
			if(answer[i].equals(ans)) {
				System.out.println("You have guessed corectly: ");
				score += 1;
			}
			else System.out.println("OOPs! .. worng ans ");
		}
		sc.close();
		System.out.println("Your Score is: "+ score);
	}
}
