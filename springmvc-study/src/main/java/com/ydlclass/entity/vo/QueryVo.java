package com.ydlclass.entity.vo;

import com.ydlclass.entity.po.UserPo;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data

public class QueryVo {
    private String sortField;
    private UserPo user;
    private Long[] ids;
    private List<UserPo> userList;
    private Map<String, UserPo> userMap;
}
