package com.ydlclass.common;

import lombok.Builder;
import lombok.Data;
/*
*
* 这个工具类统一返回
* */


@Data
@Builder
public class R {

    private static final int CODE_SUCCESS=21000;
    private static final int CODE_ERROR=11000;
    private static final String MSG_ERROR="操作失败";
    private static final String MSG_SUCCESS="操作成功";


    //业务代码  公司自己规定的
    private Integer code;
    //附加信息
    private String message;
    //成功响应数据
    private Object data;

    public static R success(){
        return R.builder().code(R.CODE_SUCCESS).message(R.MSG_SUCCESS).build();
    }

    public static R success(Object data){
        return R.builder().code(R.CODE_SUCCESS).message(R.MSG_SUCCESS).data(data).build();
    }

    public static R fail(){
        return R.builder().code(R.CODE_ERROR).message(R.MSG_ERROR).build();
    }


}
