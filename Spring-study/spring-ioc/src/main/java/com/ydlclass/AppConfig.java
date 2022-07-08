package com.ydlclass;

import com.ydlclass.config.ConfigSelector;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(value = "com.ydlclass",excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE))

@Import(ConfigSelector.class)
public class AppConfig {
}
