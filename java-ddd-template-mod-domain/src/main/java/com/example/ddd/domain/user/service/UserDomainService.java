package com.example.ddd.domain.user.service;

import com.example.ddd.acl.port.repository.user.userRepository;
import com.example.ddd.domain.user.entity.UserEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserDomainService {

    @Resource
    userRepository userRepository;

    public UserEntity create(UserEntity user)
    {
       return UserEntity.fromPO(userRepository.insert(UserEntity.toPO(user)));
    }

    public UserEntity update(UserEntity user)
    {
      return UserEntity.fromPO( userRepository.update(UserEntity.toPO(user)));
    }

    public void delete(long userId)
    {

        userRepository.deleteById(userId);
    }

    public UserEntity selectById(Long userId)
    {
      return UserEntity.fromPO(userRepository.selectById(userId));
    }

}
