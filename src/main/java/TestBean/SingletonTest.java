package TestBean;

import SingletonPattern.SluggardSingleton;
import org.junit.Test;
import SingletonPattern.EagerSingleton;

public class SingletonTest {

    /**
     * 饿汉模式
     */
    @Test
    public void eager(){
        EagerSingleton eagerSingleton = EagerSingleton.getEagerSingleton();
        eagerSingleton.say();
    }


    /**
     * 懒汉模式
     */
    @Test
    public void sluggerd(){
        SluggardSingleton sluggerdSingleton = SluggardSingleton.getSluggerdSingleton();
        sluggerdSingleton.say();
    }
}
