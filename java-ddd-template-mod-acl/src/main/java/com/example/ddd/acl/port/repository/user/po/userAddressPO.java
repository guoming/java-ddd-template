package com.example.ddd.acl.port.repository.user.po;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@TableName("user_address")
@NoArgsConstructor
public class userAddressPO {


    @TableId
    Long Id;

    Long userId;

    String street;
    String province;
    String city;
    String region;

    public userAddressPO(Long userId,String street, String province, String city, String region)
    {
        this.userId=userId;
        this.street=street;
        this.province=province;
        this.city=city;
        this.region=region;
    }
}
