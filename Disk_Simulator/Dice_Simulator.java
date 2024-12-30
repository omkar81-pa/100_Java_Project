package Disk_Simulator;

import java.util.Random;
import java.util.Scanner;

public class Dice_Simulator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of dice: ");
        
        int userInput = input.nextInt();
        
        if (userInput <= 0) {
            System.out.println("Please enter a positive number of dice.");
            return;
        }

        Random random = new Random();
        System.out.println("Hey User! You rolled:");
        
        int total = 0;
        
        for (int i = 0; i < userInput; i++) {
            int diceRoll = random.nextInt(6) + 1; // Roll a dice (1-6)
            total += diceRoll;
            System.out.print(diceRoll + " "); // Print each dice roll
        }
        
        System.out.println("\nTotal: " + total); // Print total
    }
}
