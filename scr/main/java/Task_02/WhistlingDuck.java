package Task_02;


public class WhistlingDuck extends Duck {
    private int WhistlingDuckSpeed;

    public WhistlingDuck() {
        quackBehavior = new Quack();
        flyBehavior = new FlyNoWay();
        setSpeed();
        getWay();
    }

    public void display() {
        System.out.println("I'm rubber duck, i can't fly");
    }

    public  int  setSpeed() {
       return  WhistlingDuckSpeed = 0;
    }

    public int getWay() {
        int  DuckWay = 0;
        return DuckWay;
    }
}