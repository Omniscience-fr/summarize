package TestBean;

import FactoryPattern.Human;
import FactoryPatternExpand.SimpleFactoryPattern.BlackHumans;
import FactoryPatternExpand.SimpleFactoryPattern.HumanFactorys;
import org.junit.Test;

public class SimpleFactoryPatternTest {

    @Test
    public void black(){
        //直接创建人类
        BlackHumans blackHumans = HumanFactorys.createFactory(BlackHumans.class);
        blackHumans.getcolor();
        blackHumans.say();
    }
}
