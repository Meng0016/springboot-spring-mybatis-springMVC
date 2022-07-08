package ydlclass;

import com.ydlclass.UserDao;
import com.ydlclass.YdlContainer;
import org.junit.Test;

public class Test1Container {
    @Test
    public void test1(){
      YdlContainer.MAP.put("userDao",new UserDao());
      YdlContainer.MAP.get("userDao");


    }
}
