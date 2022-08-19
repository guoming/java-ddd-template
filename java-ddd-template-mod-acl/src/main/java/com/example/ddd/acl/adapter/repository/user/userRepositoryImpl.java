package com.example.ddd.acl.adapter.repository.user;

import com.example.ddd.acl.adapter.repository.user.mapper.userAccountMapper;
import com.example.ddd.acl.adapter.repository.user.mapper.userAddressMapper;
import com.example.ddd.acl.adapter.repository.user.mapper.userMapper;
import com.example.ddd.acl.port.repository.user.po.userAccountPO;
import com.example.ddd.acl.port.repository.user.po.userPO;
import com.example.ddd.acl.port.repository.user.userRepository;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


@Component
public class userRepositoryImpl implements userRepository {

    @Resource
    userMapper userMapper;

    @Resource
    userAddressMapper userAddressMapper;

    @Resource
    userAccountMapper  userAccountMapper;

    @Override
    @Transactional
    public userPO insert(userPO user) {
        try {
            userMapper.insert(user);
            user.getAddress().setUserId(user.getUserId());
            userAddressMapper.insert(user.getAddress());
            for (userAccountPO account : user.getAccounts()) {
                account.setUserId(user.getUserId());
                userAccountMapper.insert(account);
            }

            return user;
        }
        catch (DuplicateKeyException e)
        {
            return selectById(user.getUserId());
        }
    }

    @Override
    @Transactional
    public userPO update(userPO user) {

        user.getAddress().setUserId(user.getUserId());
        userAddressMapper.deleteByUserId(user.getUserId());
        userAddressMapper.insert(user.getAddress());
        userAccountMapper.deleteByUserId(user.getUserId());
        for (userAccountPO account : user.getAccounts()) {
            account.setUserId(user.getUserId());
            userAccountMapper.insert(account);
        }
        userMapper.updateById(user);
        return user;
    }

    @Override
    public userPO selectById(Long userId) {
        return userMapper.selectById(userId);
    }

    @Override
    @Transactional
    public void deleteById(Long userid) {
         userMapper.deleteById(userid);
         userAddressMapper.deleteByUserId(userid);
         userAccountMapper.deleteByUserId(userid);
    }
}
