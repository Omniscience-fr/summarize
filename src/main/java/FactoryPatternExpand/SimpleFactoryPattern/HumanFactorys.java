package FactoryPatternExpand.SimpleFactoryPattern;

import FactoryPattern.Human;

public class HumanFactorys {

    public static <T extends Humans> T createFactory(Class<T> c){
        Humans human = null;
        try {
             human = (Humans) Class.forName(c.getName()).newInstance();

        }catch (Exception e){
            System.out.println("生产类创建失败");
        }
        return (T) human;
    }

}
