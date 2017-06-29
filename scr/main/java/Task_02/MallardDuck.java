package Task_02;

public class MallardDuck extends  Duck {
    private static final short FLIGHT_TIME = 10;
    private int DuckSpeed = 0;
    public MallardDuck(){
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
        Speed();
        getWay();
    }
    public void display() {
        System.out.println("I'm  Mallard duck!");
    }

    public int Speed() {
        int speed = 10 + (int)(Math.random() * ((100 - 10) + 1));
        if (speed >= 50){
            DuckSpeed = speed << 1;
        }
        else{
            DuckSpeed = speed >> 1;
        }
        System.out.println("Speed =" + DuckSpeed);
        return DuckSpeed;
    }
    public int getWay() {
        int  DuckWay = DuckSpeed * FLIGHT_TIME;
        return DuckWay;
    }
}

