package Task_03;

import java.util.Random;
import java.util.Scanner;

/**
 * Class Field
 *
 * v_01
 */

public class Field {
    public Cell[][] cells = new Cell[10][10];
    Player player;

    Field(Player player) {
        this.player = player;
        init();
    }

    void init() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                cells[i][j] = new Cell(i, j, null, false);
            }
        }
    }

    /**
     * placeShipsRandomly
     * Arranges ships automatically
     *
     * @param ships v_01
     */
    void placeShipsRandomly(Ship[][] ships) {
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < ships[i].length; j++) {
                int upperLeftX, upperLeftY, deckQty;
                boolean isHorizontal;
                do {
                    upperLeftX = random.nextInt(10);
                    upperLeftY = random.nextInt(10);
                    deckQty = i + 1;
                    isHorizontal = random.nextBoolean();
                } while (!checkFreeSpace(upperLeftX, upperLeftY, deckQty, isHorizontal, this));
                ships[i][j] = new Ship(this.cells[upperLeftX][upperLeftY], deckQty, isHorizontal, this);
            }
        }
    }

    /**
     * placeShipsByPlayer
     * Arranges ships by Player
     *
     * @param ships Array of ships
     * @param view  show Class
     *
     * v_01
     */

    void placeShipsByPlayer(Ship[][] ships, View view) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < ships[i].length; j++) {
                int upperLeftX, upperLeftY, leng;
                boolean isHorizontal = true;
                String isHorizontalStr;
                do {
                    boolean error;
                    leng = i + 1;
                    if (i > 0) {
                        do {
                            error = false;
                            System.out.println("Enter orientation " + (j + 1) + "st "
                                    + leng + "-Ship decks (h - horizontally , v - vertically):");
                            isHorizontalStr = (new Scanner(System.in)).nextLine();
                            if (isHorizontalStr.equals("h")) isHorizontal = true;
                            else if (isHorizontalStr.equals("v")) isHorizontal = false;
                            else error = true;
                            if (error) System.out.println("Input error try again.");
                        } while (error);
                    }
                    do {
                        error = false;
                        System.out.println( "\n Enter the coordinate of the upper or left deck " + (j + 1) + "st " + leng + "-Ship decks(example: a6)");
                        String s = (new Scanner(System.in)).nextLine();
                        upperLeftX = s.charAt(0) - 97;
                        upperLeftY = s.charAt(1) - 49;
                        if (s.length() > 2) upperLeftY = (s.charAt(1) - 48) * 10 + s.charAt(2) - 49;
                        if (upperLeftX < 0 || upperLeftX > 9 || upperLeftY < 0 || upperLeftY > 9) error = true;
                        if (error) System.out.println("Value outside the field! try again.");
                    } while (error);
                    if (!checkFreeSpace(upperLeftX, upperLeftY, leng, isHorizontal, this))
                        System.out.println("You can not put in this place. try again.");
                } while (!checkFreeSpace(upperLeftX, upperLeftY, leng, isHorizontal, this));
                ships[i][j] = new Ship(this.cells[upperLeftX][upperLeftY], leng, isHorizontal, this);
                view.showSea(this.player, true);
            }
        }
    }

    /**
     * checkFreeSpace
     * Here there is a check of presence of a place on a game field
     * at the moment of creation of the new ship
     *
     * @param isHorizontal
     * @param field
     * @param a            - Upper left X position,
     * @param b            - Upper left Y position
     *                     v_01
     */

    boolean checkFreeSpace(int a, int b, int deckQty, boolean isHorizontal, Field field) {
        if (isHorizontal && (a + deckQty) > 10) return false;
        if (!isHorizontal && (b + deckQty) > 10) return false;
        for (int i = 0; i < deckQty; i++) {
            for (int j = a - 1; j < a + 2; j++) {
                for (int k = b - 1; k < b + 2; k++) {
                    try {
                        if (isHorizontal && field.cells[j + i][k].ship != null) return false;
                    } catch (ArrayIndexOutOfBoundsException e) {
                    }
                    try {
                        if (!isHorizontal && field.cells[j][k + i].ship != null) return false;
                    } catch (ArrayIndexOutOfBoundsException e) {
                    }
                }
            }

        }
        return true;
    }
}
