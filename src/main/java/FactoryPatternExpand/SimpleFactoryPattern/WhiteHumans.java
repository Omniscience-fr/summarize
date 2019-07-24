package FactoryPatternExpand.SimpleFactoryPattern;

public class WhiteHumans implements Humans {
    @Override
    public void getcolor() {
        System.out.println("白人");
    }

    @Override
    public void say() {
        System.out.println("欧洲人");
    }
}
