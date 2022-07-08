package com.ydlclass.datasource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Bean
    @Profile("prod")
    public DataSource prodataSource(){
        return new ProdDataSource();
    }
    @Bean
    @Profile("dev")
    public DataSource devdataSource(){
        return new DevDataSource();
    }

}
