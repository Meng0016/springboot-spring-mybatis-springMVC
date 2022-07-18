package com.meng.token.handler;

import com.alibaba.fastjson.JSON;
import com.meng.token.result.ResponseResult;
import com.meng.token.utils.WebUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Component
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException {
        ResponseResult result = new ResponseResult(HttpStatus.FORBIDDEN.value(), "没有权限访问");
        String json = JSON.toJSONString(result);
        WebUtils.renderString(response,json);
    }

}
