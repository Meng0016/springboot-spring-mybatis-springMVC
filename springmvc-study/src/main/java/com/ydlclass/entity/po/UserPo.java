package com.ydlclass.entity.po;


import com.ydlclass.entity.dto.UserDto;
import com.ydlclass.entity.vo.QueryVo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserPo {
    private String username;
    private String password;


    public static void main(String[] args) {
        UserPo userPo=new UserPo("zhangsan","123");
        UserDto userDto=new UserDto();


        QueryVo queryVo=new QueryVo();
        queryVo.setUser(new UserPo("tom","1234"));

        BeanUtils.copyProperties(queryVo.getUser(),userDto);
        System.out.println(userDto);
    }
}
