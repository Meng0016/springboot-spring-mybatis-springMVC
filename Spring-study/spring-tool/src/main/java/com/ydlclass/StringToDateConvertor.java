package com.ydlclass;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringToDateConvertor implements Converter<String , Date> {
    @Override
    public Date convert(String source) {
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat dateFormat=new SimpleDateFormat(pattern);
            try {
                return dateFormat.parse(source);
            } catch (ParseException e) {
                e.printStackTrace();
                throw new RuntimeException("日期类型转换失败");
            }
    }
}
