package first;

import java.util.Scanner;

public class RiddleGame {
	public static void main(String[] args) {
		Scanner  sc = new Scanner(System.in);
		int score = 0;
		
		String[] riddles = {
				"I speak without a mouth and hear without ears. I have no body, but I come alive with the wind. What am I?",
				"The more you take, the more you leave behind. What am I?",
				"I'am not alive, but I can grow; I dont have lungs, but I need air; I don't have a mouth, but water kills me. What am I?"
				};
		
		String[] answers = {
				"An echo",
				"Footsteps",
				"A fire"
				};
		
		String[] hints = {
				"Hint: This thing is known for its ability to reflect sound.",
				"Hint: Think about what you leave behind when you walk.",
				"Hint: It produces heat and light."
		};
		
		int numRiddles = riddles.length;
		
		while(true) {
			int randomIndex = (int) (Math.random() * numRiddles);
			String selectedRiddle = riddles[randomIndex];
			String correctAnswer = answers[randomIndex];
			String hint = hints[randomIndex];
			
			System.out.println("Riddle: "+selectedRiddle);
			
			String userAnswer = sc.nextLine();
			
			if(userAnswer.equalsIgnoreCase(correctAnswer)) {
				System.out.println("Correct!");
				score++;
			}else {
				System.out.println("Wrong! Would you like a hint? (yes/no)");
				String giveHint = sc.nextLine().toLowerCase();
				
				if(giveHint.equals("yes")) {
					System.out.println(hint);
				}
			}
			System.out.println("Continue playing? (yes/no)");
			String playAgain = sc.nextLine().toLowerCase();
			if(!playAgain.equals("yes")) {
				break;
			}
		}
		
		System.out.println("Your final score: "+ score);
		System.out.println("Thanks for playing!");
	}
}
