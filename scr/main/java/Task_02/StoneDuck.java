package Task_02;

/**
 * Class Stone Duck Describes the realization of a duck.
 *
 *@author Denis Kus
 *@since Duck Race v_1
 *
 */

public class StoneDuck extends Duck {

    public StoneDuck() {
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
        int stoneDuckSpeed= 0;
        return  stoneDuckSpeed ;
    }
    @Override
    public int getWay() {
        int  DuckWay = 0;
        System.out.println("Stone Duck Speed:"+ DuckWay);
        resultSpeed = DuckWay;
        return resultSpeed;
    }
}
