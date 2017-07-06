package Task_03;

import java.util.Scanner;

/**
 * Class work with player
 */

public class Game {

    Player player1 = new Player();
    Player player2 = new Player();
    View view = new View();
    boolean player1ShotRight;


    public void newStart() {
        System.out.println("Let's play, enter your name : ");
        player1.name = (new Scanner(System.in)).nextLine();
        player2.name = "Computer";
        System.out.println("Start, " + player1.name + ".");
        init();
        player1ShotRight = true;
        while (player1.allLenght != 0 && player2.allLenght != 0) {
            if (player1ShotRight) {
                if (!player1.shooting(player2.field, false, false)) player1ShotRight = !player1ShotRight;
            } else {
                if (!player2.shooting(player1.field, true, false)) player1ShotRight = !player1ShotRight;
            }
            view.showSea(player1, player2, true, false);
        }
        if (player1.allLenght == 0) System.out.println("The winner is the player " + player2.name + "!");
        else System.out.println("The winner is the player " + player1.name + "!");
    }

    /**
     * Creation and placement of players' ships
     */
    public void init() {

        view.showSea(player1, player2, true, false);
        player1.field.placeShipsByPlayer(player1.ships, view);
        player2.field.placeShipsRandomly(player2.ships);
        view.showSea(player1, player2, true, false);
    }
}
