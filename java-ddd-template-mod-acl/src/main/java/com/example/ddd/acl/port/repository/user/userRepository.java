package com.example.ddd.acl.port.repository.user;


import com.example.ddd.acl.port.repository.user.po.userPO;

public interface userRepository {
    userPO insert(userPO user);
    userPO update(userPO user);
    userPO selectById(Long userId);
    void deleteById(Long userId);
}
