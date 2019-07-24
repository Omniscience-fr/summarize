package FactoryPatternExpand.MoreFacoryPattern;

import FactoryPatternExpand.MoreFacoryPattern.Humans;

public class YellowHumans implements Humans {
    @Override
    public void getcolor() {
        System.out.println("黄种人");
    }

    @Override
    public void say() {
        System.out.println("亚洲人");
    }
}
