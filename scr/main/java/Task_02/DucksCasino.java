package Task_02;

import java.util.ArrayList;


public class DucksCasino {

    private static final short RATE = 100;
    private static final short DUCKS_COUNT = 5;
    private int myCash = 500 ;

    public static void main(String[] args) {
        MallardDuck mallard = new MallardDuck();
        StoneDuck stone = new StoneDuck();
        WhistlingDuck whistling = new WhistlingDuck();
        BulletDuck bullet = new BulletDuck();
        CubaDuck cuba = new CubaDuck();

        ArrayList<Duck> duckList = new ArrayList<Duck>();
        duckList.add(mallard);
        duckList.add(stone);
        duckList.add(whistling);
        duckList.add(bullet);
        duckList.add(cuba);

        while (myCash != 0){
            randomizeList(duckList);

            myCash -= RATE;
    }

    }
    public int readchoise(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Select a duck number from 1 to 5 " );
            duckNumber = Integer.parseInt(reader.readLine());
            if (duckNumber > DUCKS_COUNT || duckNumber < 0 ){

                System.out.println("Error you entered the wrong number, please try again!" );
                duckNumber = Integer.parseInt(reader.readLine());
                }
            return duckNumber;
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new RuntimeException();
    }
 // выбор утки
    public int ducsRun(){
         int choiseduck = readchoise();

    }
    public void randomizeList(ArrayList<Duck>)   {
 //  перемешивание листа
    }

}
