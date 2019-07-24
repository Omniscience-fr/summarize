package TestBean;

import FactoryPattern.BlackHuman;
import FactoryPatternExpand.MoreFacoryPattern.BlackHumanFactory;
import FactoryPatternExpand.MoreFacoryPattern.Humans;
import FactoryPatternExpand.MoreFacoryPattern.YellowHumanFactory;
import org.junit.Test;

public class MoreFactoryPatternTest {

    /**
     *根据各自的不同，创建各自的生产工厂
     */


    @Test
    public void black(){
        BlackHumanFactory blackHumanFactory = new BlackHumanFactory();
        Humans factory = blackHumanFactory.createFactory();
        factory.getcolor();
        factory.say();
    }

    @Test
    public void yellow(){
        YellowHumanFactory yellowHumanFactory = new YellowHumanFactory();
        Humans factory = yellowHumanFactory.createFactory();
        factory.getcolor();
        factory.say();
    }


}
