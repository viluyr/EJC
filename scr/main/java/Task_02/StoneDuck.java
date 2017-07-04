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

    public  void printSpeed() {
        System.out.println("Stone Duck Speed: =" + resultSpeed);
    }

    @Override
    public int getWay() {
        int  duckWay = 0;
        resultSpeed = duckWay;
        return resultSpeed;
    }
}
