package com.example.ddd.acl.adapter.repository.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.ddd.acl.port.repository.user.po.userAccountPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public   interface userAccountMapper extends BaseMapper<userAccountPO> {

    userAccountPO selectById(@Param("user_id") Long userId);

    void deleteByUserId(@Param("user_id") Long userId);

}

