package com.ydlclass.entity.vo;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.ydlclass.entity.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVo {
    @NotNull(message = "用户名不能为空")
    private String username;
    @NotNull(message = "密码不能为空")
    private String password;

    @Min(value = 0, message = "年龄不能小于{value}")
    @Max(value = 120,message = "年龄不能大于{value}")
    private int age;

    @JsonFormat(
            pattern = "yyyy-MM-dd",
            timezone="GMT-8"
    )
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past(message = "生日不能大于今天")
    private Date birthday;

    @Pattern(regexp = "^1([358][0-9]|4[579]|66|7[0135678]|9[89])[0-9]{8}$", message = "手机号码不正确")
    private String phone;

    @Email
    private String email;
}
