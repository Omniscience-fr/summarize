package FactoryPattern;

public class YellowHuman implements Human {
    @Override
    public void getcolor() {
        System.out.println("黄种人");
    }

    @Override
    public void say() {
        System.out.println("亚洲人");
    }
}
