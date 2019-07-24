package FactoryPatternExpand.MoreFacoryPattern;

public class YellowHumanFactory extends AbstractHumanFactory {
    @Override
    public Humans createFactory() {
        return new YellowHumans();
    }
}
