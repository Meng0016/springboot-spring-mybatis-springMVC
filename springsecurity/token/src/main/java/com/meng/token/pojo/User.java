package com.meng.token.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "sys_user")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 用户id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 昵称
     */
    private String nickName;
    /**
     * 密码
     */
    private String password;
    /**
     * 账号状态 0/1
     */
    private String status;
    /**
     * 邮箱
     * */
    private String email;
    /**
     * 手机号
     * */
    private String phonenumber;
    /**
     * 性别 0/1/2
     * */
    private String sex;
    /**
     * 头像
     * */
    private String avatar;
    /**
     * 用户类型 （0管理员 1普通用户）
     * */
    private String userType;
    /**
     * 创建用户ID
     * */
    private Long createBy;
    /**
     * 创建时间
     * */
    private Date createTime;
    /**
     * 更新用户
     * */
    private Long updateBy;
    /**
     * 更新时间
     * */
    private Date updateTime;
    /**
     * 删除标志（0未删除 1已删除）
     * */
    private Integer delFlag;

}
