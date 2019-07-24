package FactoryPattern;

/**
 * 工厂类
 */
public abstract class AbstractFactory {
    public abstract <T extends Human> T createHuman(Class<T> c);

}
