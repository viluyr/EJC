package Task_02;
import java.util.Random;

/**
 * Class Bullet Duck Describes the realization of a duck.
 *@author Denis Kus
 *@since Duck Race v_1
 */

public class BulletDuck extends Duck {

    private static final short FLIGHT_TIME = 10;
    private int duckSpeed = 0;
    private static Random random = new Random();

    public BulletDuck(){
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
        getWay();
    }

    @Override
    public void display() {
        System.out.println("I'm  Bullet duck!");
    }

    @Override
    public void printSpeed() {
        System.out.println("Bullet Duck Speed =" + duckSpeed);
    }

    public int speed() {
        int speed =10 + random.nextInt(150);
        if (speed >= 50){
            duckSpeed = speed << 1;
        }
        else{
            duckSpeed = speed >> 1;
        }
        return duckSpeed;
    }

    @Override
    public int getWay() {
        int speed = speed();
        int  duckWay = speed * FLIGHT_TIME;
        resultSpeed = duckWay;
        return resultSpeed;
    }
}