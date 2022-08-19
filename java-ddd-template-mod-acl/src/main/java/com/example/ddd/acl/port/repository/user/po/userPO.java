package com.example.ddd.acl.port.repository.user.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.List;


@Data
@TableName("user")
public class userPO {

     @TableId
    Long userId;
    String name;
    Integer age;
    String telephone;
    String email;
    Integer status;
    @TableField(exist = false)
    userAddressPO address;
    @TableField(exist = false)
    List<userAccountPO> accounts;
}
