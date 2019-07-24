package FactoryPattern;

public class BlackHuman implements Human {

    @Override
    public void getcolor() {
        System.out.println("黑人");
    }

    @Override
    public void say() {
        System.out.println("非洲人");
    }
}
