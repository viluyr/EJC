package Task_02;

import java.util.Random;
/**
 * Class Cuba Duck Describes the realization of a duck.
 *
 *@author Denis Kus
 *@since Duck Race v_1
 *
 */

public class CubaDuck extends Duck {
    private static final short FLIGHT_TIME = 10;
    private int DuckSpeed = 0;
    private static Random random = new Random();

    public CubaDuck(){
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
        getWay();
    }
    @Override
    public void display() {
        System.out.println("I'm  Cuba duck!");
    }

    @Override
    public String getName() {
        return "Cuba Duck";
    }

    public int Speed() {
        int speed =10 + random.nextInt(90);
        if (speed >= 50){
            DuckSpeed = speed << 1;
        }
        else{
            DuckSpeed = speed >> 1;
        }
        System.out.println("Cuba Duck Speed =" + DuckSpeed);
        return DuckSpeed;
    }

    @Override
    public int getWay() {
        int speed = Speed();
        int  DuckWay = speed * FLIGHT_TIME;
        resultSpeed = DuckWay;
        return resultSpeed;
    }


}
