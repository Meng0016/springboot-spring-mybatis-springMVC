package com.ydlclass.factorybean;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.lang.reflect.Constructor;

public class DataSourceFactoryBean implements FactoryBean<DataSource> {
    @Override
    public DataSource getObject() throws Exception {

        //实例化一个bean，交给容器管理，这个创建过程是复杂的，甚至我们连类都不知道

        DruidDataSource dataSource=new DruidDataSource();
        dataSource.setUsername("root");
        return dataSource;

        //com/ydlclass/factorybean/DataSourceFactoryBean
       /* Class<?> aClass = Class.forName("com.ydlclass.factorybean.DataSourceFactoryBean");
        Constructor<?> declaredConstructor = aClass.getDeclaredConstructor();
        return declaredConstructor.newInstance();*/


    }

    @Override
    public Class<?> getObjectType() {
        return DataSource.class;
       /* try {
            return Class.forName("com.ydlclass.factorybean.DataSourceFactoryBean");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;*/
    }
}
