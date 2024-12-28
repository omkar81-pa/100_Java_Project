package nit.com.game;

import java.util.Scanner;
public class Game {
    public static void main(String[] args) {
        Game1 gaming = new Game1();
        boolean b = false;
        Scanner a1 = new Scanner(System.in);
        while (!b) {
            gaming.TakeUserinput(a1);
            b = gaming.NoofCorrectGuesses();
        }
        a1.close();
    }
}
