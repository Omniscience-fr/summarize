package FactoryPattern;

public class WhiteHuman implements Human {
    @Override
    public void getcolor() {
        System.out.println("白人");
    }

    @Override
    public void say() {
        System.out.println("欧洲人");
    }
}
