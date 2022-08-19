package com.example.ddd.ohs.local.appservice;

import com.example.ddd.ohs.local.dto.UserDTO;
import com.example.ddd.domain.user.entity.UserEntity;
import com.example.ddd.domain.user.service.UserDomainService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author guoming
 */
@Service
public class UserAppService
{
    @Resource
    UserDomainService userDomainService;



    public UserDTO insert(UserDTO userDTO) {

        return UserDTO.fromDO(userDomainService.create(UserDTO.toDO(userDTO)));
    }

    public UserDTO update(UserDTO user)
    {
        return UserDTO.fromDO( userDomainService.update(UserDTO.toDO(user)));
    }

    public void delete(Long userId)
    {
        userDomainService.delete(userId);
    }

    public UserDTO selectById(Long userId)
    {
        UserEntity userEntity = userDomainService.selectById(userId);
        return UserDTO.fromDO(userEntity);
    }

}
