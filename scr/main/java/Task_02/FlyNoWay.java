package Task_02;

/**
 * Class FlyNoWay Describes the realization of a duck which
 * can't fly.
 *
 *@author Denis Kus
 *@since Duck Race v_1
 *
 */

public class FlyNoWay implements FlyBehavior {
    public void fly(){
        System.out.println(" I Can't Fly");
    }
}
