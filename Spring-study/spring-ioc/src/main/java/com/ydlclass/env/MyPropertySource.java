package com.ydlclass.env;



import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.PropertySource;

import java.util.Properties;

public  class MyPropertySource extends PropertySource {
   /* @Value("${os.name}")
    private String os;
    */
    private Properties properties=new Properties();


    public MyPropertySource(String name) {
        super(name);
        properties.put("hello","properties");
    }

    @Override
    public Object getProperty(String s) {
        return properties.get(s);
    }
}
