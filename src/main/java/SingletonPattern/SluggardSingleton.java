package SingletonPattern;

/**
 * 懒汉模式
 */
public class SluggardSingleton {
    private static SluggardSingleton singletion = null;

    private SluggardSingleton(){

    }

    public static SluggardSingleton getSluggerdSingleton(){
        if(singletion == null){
            singletion = new SluggardSingleton();
        }
        return singletion;
    }

    public void say(){
        System.out.println("懒汉模式");
    }
}
