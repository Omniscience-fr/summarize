package TestBean;

import org.junit.Test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.axis.utils.ClassUtils;


/**
 * @Author: fr
 * @Date: 2019/5/24 15:35
 */
public class StringTest {


    @Test
    public void Strings(){
        String s = "JAVA编程思想";
        System.out.println(s);
    }

//    @Test
//    public void show(HttpServletRequest request){
//        HttpSession session = request.getSession();
//        session.invalidate();
//    }

    @Test
    public void StringBuffers(){
        StringBuffer s = new StringBuffer();
        s.append("JAVAAAAAAAASDDDBB");
        System.out.println(s.length());

    }


}
