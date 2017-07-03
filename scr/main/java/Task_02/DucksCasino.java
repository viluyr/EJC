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

        while (myCash != 0 ){

            racecasino.createDucksList();
            //racecasino.readChoise();
            racecasino.maxSpeedDuck();

           }
        System.out.println("Game over");
    }

    private  void createDucksList() {
        Random rand = new Random();
        for (int i = 0; i < DUCKS_COUNT; i++) {
            int duckNumber = rand.nextInt(5) + 1;
                switch (duckNumber) {
                    case 1:
                        ducksList.add(mallard = new MallardDuck());
                        System.out.println(mallard.getName());
                        break;
                    case 2:
                        ducksList.add(stone = new StoneDuck());
                        System.out.println(stone.getName());
                        break;
                    case 3:
                        ducksList.add(whistling = new WhistlingDuck());
                        System.out.println(whistling.getName());
                        break;
                    case 4:
                        ducksList.add(bullet = new BulletDuck());
                        System.out.println(bullet.getName());
                        break;
                    case 5:
                        ducksList.add(cuba = new CubaDuck());
                        System.out.println(cuba.getName());
                        break;
                }
        }
    }

    public int readChoise() {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Select a duck number from 1 to 5 : ");
            int duckNumber;
            duckNumber = Integer.parseInt(reader.readLine());
            if ((duckNumber > DUCKS_COUNT )|| (duckNumber < 0)) {
                System.out.println("Error you entered the wrong number, please try again!");
                duckNumber = Integer.parseInt(reader.readLine());
            }
            return duckNumber;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void maxSpeedDuck(){
        ArrayList<Duck> winDuck = new ArrayList<>();
        ArrayList<Duck> myDuck = new ArrayList<>();
        int duckNumber = readChoise();
        int max = 0;
        for (int i = 0; i < ducksList.size(); i++)
        {
            if (ducksList.get(i).resultSpeed >= max){
                max = ducksList.get(i).resultSpeed;
                winDuck.add(ducksList.get(i));
            }
            if (i == duckNumber){
                myDuck.add(ducksList.get(i));
            }
        }
        System.out.println("Max speed was : "+ max);

       if (myDuck.equals(winDuck)){
           System.out.println("Your Duck Won");
           myCash +=RATE;
           System.out.println("Balance:"+ myCash);
       }
       else {
           System.out.println("You almost won, but the other duck was faster, try again");
           myCash -=RATE;
           System.out.println("Balance:"+ myCash);
       }
    }
}


