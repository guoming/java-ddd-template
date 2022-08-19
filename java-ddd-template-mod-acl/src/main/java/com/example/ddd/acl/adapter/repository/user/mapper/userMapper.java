package com.example.ddd.acl.adapter.repository.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.ddd.acl.port.repository.user.po.userPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface userMapper extends BaseMapper<userPO> {

    userPO selectById(@Param("userId") Long userId);

}
