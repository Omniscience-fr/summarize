package FactoryPatternExpand.SimpleFactoryPattern;

public class BlackHumans implements Humans {

    @Override
    public void getcolor() {
        System.out.println("黑人");
    }

    @Override
    public void say() {
        System.out.println("非洲人");
    }
}
