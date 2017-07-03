package Task_02;

/**
 * Class Whistling Duck Describes the realization of a duck.
 *
 *@author Denis Kus
 *@since Duck Race v_1
 *
 */

public class WhistlingDuck extends Duck {

    public WhistlingDuck() {
        quackBehavior = new Quack();
        flyBehavior = new FlyNoWay();
        getWay();
    }

    @Override
    public void display() {
        System.out.println("I'm rubber duck, i can't fly");
    }

    @Override
    public String getName() {
        return "Stone Duck";
    }

    public  int  setSpeed() {
        int whistlingDuckSpeed = 0;
        return  whistlingDuckSpeed ;
    }

    @Override
    public int getWay() {
        int  DuckWay = 0;
        System.out.println("Stone Duck Speed :" + DuckWay);
        resultSpeed= DuckWay;
        return resultSpeed;
    }
}