package nit.com.game;

import java.util.Random;
import java.util.Scanner;

class Game1 {
    private int noofGuesses = 0;
    public int inputno;
    private int Rando;

    public Game1() {
        Random rand = new Random();
        int upperbound = 100;
        Rando = rand.nextInt(upperbound);
    }

    public void TakeUserinput(Scanner a1) {
        System.out.print("Guess a no:");
        inputno = a1.nextInt();
    }

    public void SetnoofGuesses(int Guesses) {
        this.noofGuesses = Guesses;
    }

    public int GetnoofGuesses() {
        return noofGuesses;
    }

    boolean NoofCorrectGuesses() {
        noofGuesses++;
        if (inputno == Rando) {
            System.out.printf("You guessed the no right: %d\n", Rando);
            System.out.printf("You guessed in %d attempts\n", noofGuesses);
            return true;
        } else if (inputno > Rando) {
            System.out.println("No is greater");
        } else if (inputno < Rando) {
            System.out.println("No is less");
        }
        return false;
    }
}



