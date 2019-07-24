package TestBean;

import FactoryPattern.AbstractFactory;
import FactoryPattern.BlackHuman;
import FactoryPattern.HumanFactory;
import FactoryPattern.WhiteHuman;
import org.junit.Test;

public class FactoryPatternTest {

    @Test
    public void black(){
        //炉子
        AbstractFactory factory = new HumanFactory();
        //创建人类
        BlackHuman human = factory.createHuman(BlackHuman.class);
        human.getcolor();
        human.say();
    }

    @Test
    public void white(){
        AbstractFactory factory = new HumanFactory();
        WhiteHuman human = factory.createHuman(WhiteHuman.class);
        human.getcolor();
        human.say();
    }

    


}
