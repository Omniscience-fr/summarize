package SingletonPattern;

/**
 * 饿汉模式
 */
public class EagerSingleton {

    private static final EagerSingleton singleton = new EagerSingleton();
    private EagerSingleton(){
    }


    public static EagerSingleton getEagerSingleton(){
        return singleton;
    }

    public void say(){
        System.out.println("懒汉模式");
    }

}
