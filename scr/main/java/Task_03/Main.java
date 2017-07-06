package Task_03;

import java.util.Scanner;

/**
 *
 */
public class Main {
    public static void main(String[] args) {
        int n = 0;
        while (n != 2) {
            System.out.println("**********Select an action**********");
            System.out.println("1 - Play");
            System.out.println("2 - Exit");
            n = Integer.parseInt((new Scanner(System.in)).nextLine());
            if (n == 1) {
                Game game = new Game();
                game.newStart();
            }
        }
    }
}