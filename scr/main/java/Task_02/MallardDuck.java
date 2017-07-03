package Task_02;

import java.util.Random;

/**
 * Class Mallard Duck Describes the realization of a duck.
 *
 *@author Denis Kus
 *@since Duck Race v_1
 *
 */
public class MallardDuck extends  Duck {
    private static final short FLIGHT_TIME = 10;
    private int DuckSpeed = 0;
    private static Random random = new Random();
    public MallardDuck(){
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
        getWay();
    }
    @Override
    public void display() {
        System.out.println("I'm  Mallard duck!");
    }

    @Override
    public String getName() {
        return "Mallard Duck";
    }

    public int Speed() {
        int speed =10 + random.nextInt(90);
        if (speed >= 10){
            DuckSpeed = speed << 1;
        }
        else{
            DuckSpeed = speed >> 1;
        }
        System.out.println("Mallard Duck Speed =" + DuckSpeed);
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

