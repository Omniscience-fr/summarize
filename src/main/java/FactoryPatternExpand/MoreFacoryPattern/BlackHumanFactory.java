package FactoryPatternExpand.MoreFacoryPattern;

public class BlackHumanFactory extends AbstractHumanFactory {
    @Override
    public Humans createFactory() {
        return  new BlackHumans();
    }
}
