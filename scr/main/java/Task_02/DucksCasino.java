package Task_02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class DucksCasino {

    private static final short RATE = 100;
    private static final short DUCKS_COUNT = 5;
    private static int myCash = 500;

    private MallardDuck mallard;
    private StoneDuck stone;
    private WhistlingDuck whistling;
    private BulletDuck bullet;
    private CubaDuck cuba;
    private ArrayList<Duck> ducksList = new ArrayList<>();

    public static void main(String[] args) {
        DucksCasino racecasino = new DucksCasino();

        System.out.println("Hello ans Welcome. This is a duck casino in which betting on a duck.");

        while (myCash != 0 ){
            racecasino.createDucksList();
            racecasino.maxSpeedDuck();
           }
        System.out.println("Sorry, u don't have enough money in your account Game over");
    }

    /**
     * createDucksList()
     * Create ArrayList of Ducks
     */
    private  void createDucksList() {
        Random rand = new Random();
        for (int i = 0; i < DUCKS_COUNT; i++) {
            int duckNumber = rand.nextInt(5) + 1;
                switch (duckNumber) {
                    case 1:
                        ducksList.add(mallard = new MallardDuck());
                        break;
                    case 2:
                        ducksList.add(stone = new StoneDuck());
                        break;
                    case 3:
                        ducksList.add(whistling = new WhistlingDuck());
                        break;
                    case 4:
                        ducksList.add(bullet = new BulletDuck());
                        break;
                    case 5:
                        ducksList.add(cuba = new CubaDuck());
                        break;
                }
        }
    }

    /**
     * readChoise()
     * Reads keyboard input
     */
    private int readChoise() {
        int duckNumber;
        try{ BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            do {
                System.out.println("\n Select a duck number from 1 to 5 : ");

                duckNumber = Integer.parseInt(reader.readLine());
            } while ((duckNumber > DUCKS_COUNT )|| (duckNumber < 0));
            return duckNumber;
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new RuntimeException();
    }

    /**
     * maxSpeedDuck()
     * It considers the maximum speed and displays the path that the fastest duck ran,
     * also operations with balance
     */
    private void maxSpeedDuck(){
        ArrayList<Duck> winDuck = new ArrayList<>();
        ArrayList<Duck> myDuck = new ArrayList<>();
        int duckNumber = readChoise();
        int max = 0;
        for (int i = 0; i < ducksList.size(); i++)
        {
            ducksList.get(i).printSpeed();
            if (ducksList.get(i).resultSpeed >= max){
                max = ducksList.get(i).resultSpeed;
                winDuck.add(ducksList.get(i));
            }
            if (i == duckNumber){
                myDuck.add(ducksList.get(i));
            }
        }
        System.out.println("\n Max speed was : "+ max );

       if (myDuck.equals(winDuck)){
           System.out.println("Your Duck Won, Try again\n");
           myCash +=2*RATE;
           System.out.println("Balance:"+ myCash);
       }
       else {
           System.out.println("You almost won, but the other duck was faster, try again \n");
           myCash -=RATE;
           System.out.println("Balance :"+ myCash);
       }
        ducksList.clear();
    }
}


