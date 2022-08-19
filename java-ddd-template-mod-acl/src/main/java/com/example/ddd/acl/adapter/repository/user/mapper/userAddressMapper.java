package com.example.ddd.acl.adapter.repository.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.ddd.acl.port.repository.user.po.userAddressPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface userAddressMapper extends BaseMapper<userAddressPO> {

    userAddressPO selectById(@Param("user_id") Long userId);

    void deleteByUserId(@Param("user_id") Long userId);
}
