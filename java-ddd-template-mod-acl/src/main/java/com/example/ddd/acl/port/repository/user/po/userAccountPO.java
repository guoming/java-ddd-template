package com.example.ddd.acl.port.repository.user.po;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@TableName("user_account")
@NoArgsConstructor
public class userAccountPO {
    @TableId
    Long Id;
    Long userId;
    String password;
    String username;

    public userAccountPO(Long userId, String username, String password)
    {
        this.userId=userId;
        this.username=username;
        this.password=password;
    }
}
