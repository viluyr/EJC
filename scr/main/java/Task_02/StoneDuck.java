package Task_02;

public class StoneDuck extends Duck {
    private int stoneDuckSpeed;

    public StoneDuck() {
        quackBehavior = new Quack();
        flyBehavior = new FlyNoWay();
        setSpeed();
        getWay();
    }

    public void display() {
        System.out.println("I'm rubber duck, i can't fly");
    }

    public  int  setSpeed() {
        return  stoneDuckSpeed = 0;
    }

    public int getWay() {
        int  DuckWay = 0;
        return DuckWay;
    }
}
