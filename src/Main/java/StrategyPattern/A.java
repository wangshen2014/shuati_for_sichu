package StrategyPattern;

/**
 * Created by patrickyu on 10/12/16.
 */
public class A {

    public void func(X obj){
        pre();
        obj.work();
        post();
    }

    private void pre(){
        System.out.println("PRE: ");
    }

    private void post(){
        System.out.println("POST: ");
    }
}

